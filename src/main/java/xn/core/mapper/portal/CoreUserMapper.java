package xn.core.mapper.portal;


import org.apache.ibatis.annotations.Param;

import xn.core.model.portal.CoreUserModel;

/**
 * Created Eclipse Java EE. User:li.zhou Date:2016-4-9 Time:14:03:07
 */
public interface CoreUserMapper  {
	
	/**
     * 根据用户名和公司编码登录
     * 
     * @param entity
     * @return
     */
	CoreUserModel userLogin(CoreUserModel entity);

	/**
     * 根据用户名查询所在公司
     * 
     * @param userName
     * @return
     */
	CoreUserModel searchUserByName(String userName);

    /**
     * @Description: 修改密码
     * @author Administrator
     * @param rowId
     * @param password
     */
    void editPassword(@Param("rowId") long rowId, @Param("password") String password);
}
