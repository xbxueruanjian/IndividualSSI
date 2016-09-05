package xn.core.service;

import org.springframework.stereotype.Service;

import xn.core.model.system.ActionTrackModel;

@Service
public interface IActionTrackService {
    /**
     * @Description: 来访信息表插入
     * @author Administrator
     * @param atm
     */
    public void saveGuestInfro(ActionTrackModel atm);

    /**
     * @Description: 修改密码
     * @author Administrator
     * @param rowId
     * @param password
     */
    public void eidtPassword(String password);


}
