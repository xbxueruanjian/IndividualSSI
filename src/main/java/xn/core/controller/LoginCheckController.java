package xn.core.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.bitwalker.useragentutils.UserAgent;
import xn.core.exception.CoreBusiException;
import xn.core.exception.Thrower;
import xn.core.model.system.ActionTrackModel;
import xn.core.service.IActionTrackService;
import xn.core.shiro.CompanycodeUsernamePasswordToken;
import xn.core.util.AddressUtil;
import xn.core.util.MD5Util;

@Component
@Controller
@RequestMapping("/login")
public class LoginCheckController extends BaseController {

    @Autowired
    private IActionTrackService actionTrackService;


    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {

        // if (!request.getMethod().equals("POST")) {
        // request.setAttribute("message", "请填写登录信息");
        // throw new AuthenticationException("请填写登录信息！");
        // }
        try {
            request.setCharacterEncoding("utf-8");
        }
        catch (UnsupportedEncodingException e) {
            Thrower.throwException(CoreBusiException.LOGIN_CODE_ERROR);
        }

        Subject subject = SecurityUtils.getSubject();

        String companycode = getString("companycode");
        String username = getString("username");
        String password = getString("password");
        boolean isUseCookie = obtainIsUseCookie(request);

        CompanycodeUsernamePasswordToken token = new CompanycodeUsernamePasswordToken(companycode, username, password);
        // 是否记住登录状态（只记录公司名、用户名）
        token.setRememberMe(isUseCookie);
        try {
            // shiro核心 认证方法
            subject.login(token);
            if (!subject.isAuthenticated()) {
                token.clear();
            }

            ActionTrackModel actionTrackModel = getBean(ActionTrackModel.class);
            
            actionTrackModel.setScreenWidth(getString("width"));
            actionTrackModel.setScreenHeight(getString("height"));
            actionTrackModel.setLanguage(request.getLocale().getLanguage());
            actionTrackModel.setStartTime(new Date());
            actionTrackModel.setIp(AddressUtil.getIpAddr(request));

            String head = request.getHeader("User-Agent");
            try {
                UserAgent userAgent = new UserAgent(head);
                actionTrackModel.setExplorer(userAgent.getBrowser().getName());
                actionTrackModel.setExplorerVer((userAgent.getBrowserVersion().getVersion()));
            }
            catch (Exception e) {
                log.error(e.getMessage());
            }

            Map<String, String> addrmap = AddressUtil.getAddresses(request, "utf-8");
            if (addrmap != null && !addrmap.isEmpty()) {
                actionTrackModel.setCountry(addrmap.get("country"));
                actionTrackModel.setProvince(addrmap.get("region"));
                actionTrackModel.setCity(addrmap.get("city"));
                actionTrackModel.setArea(addrmap.get("county"));
            }
            actionTrackService.saveGuestInfro(actionTrackModel);
            // response.sendRedirect(request.getContextPath() + "/jsp/Main.jsp");
        }
        catch (IncorrectCredentialsException e) {
            Thrower.throwException(CoreBusiException.LOGIN_PASSWORD_ERROR);
        }
        catch (AuthenticationException e) {
            Thrower.throwException(CoreBusiException.LOGIN_NAME_ERROR);
        }

        // 使用JSONP使用下面这个方法
        // response.setHeader("Access-Control-Allow-Origin", "*");
        // String callbackparam = getString("callbackparam");
        // return new JSONPObject(callbackparam, getReturnMap());

        return getReturnMap();
    }


    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Object> login_check() {
        if (SecurityUtils.getSubject().getSession() != null) {
            SecurityUtils.getSubject().logout();
        }
        // return "login";
        return getReturnMap();
    }

    @RequestMapping("/editPassword")
    @ResponseBody
    public Map<String, Object> editPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oldPassword = MD5Util.generateMD5code(getString("oldPassword"));
        String newPassword = MD5Util.generateMD5code(getString("newPassword"));
        String surePassword = MD5Util.generateMD5code(getString("surePassword"));

        if (!getUserDetail().getPassword().equals(oldPassword)) {
            throw new Exception("旧密码不正确！");
        }
        if (!newPassword.equals(surePassword)) {
            throw new Exception("两次密码不一致！");
        }
        if (newPassword.equals(oldPassword)) {
            throw new Exception("新密码不能和旧密码一样！");
        }
        // 同步session，同步数据库
        getUserDetail().setPassword(newPassword);
        getUserDetail().setIsInitPw("N");
        actionTrackService.eidtPassword(newPassword);

        return getReturnMap();
    }

    protected boolean obtainIsUseCookie(HttpServletRequest request) {

        Object obj = request.getParameter("isUseCookie");

        boolean flag = false;

        if (obj != null) {
            String str = obj.toString();
            if (str.equalsIgnoreCase("on")) {
                flag = true;
            }
        }
        return flag;
    }
}
