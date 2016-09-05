package xn.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import xn.core.model.ParamModel;
import xn.core.model.system.CacheTablesModel;
import xn.core.model.system.MenuView;

/***
 * @Description: 公共工具接口
 * @author fangc
 * @date 2016年4月15日 上午10:25:38
 */
@Service
public interface IParamService {

    /**
     * @Description: 验证数据是否存，可通过数组传递多个值，但两数组长度要一致
     * @author Zhangjc
     * @param tableName
     * @param rowId
     * @param paramModel
     * @return
     * @throws Exception
     */
    public long isExist(String tableName, Long rowId, List<ParamModel> paramModel) throws Exception;

    /**
     * @Description: 根据代码类别、创建人、公司ID创建编码
     * @author Zhangjc
     * @param typeCode
     * @param createId
     * @param companyId
     * @return
     * @throws Exception
     */
    public String getBCode(String typeCode, long createId, long companyId, long farmId) throws Exception;

    /**
     * @Description: 根据公司ID 和设置代码ID获取设置值
     * @author Zhangjc
     * @param companyId
     * @param settingCode
     * @return
     * @throws Exception
     */
    public String getSettingValueByCode(String settingCode) throws Exception;

    /**
     * @Description: 查询所有需要缓存的表数据
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> getCacheDataBySql(String sql) throws Exception;

    /**
     * @Description: 查询根据的缓存表数据
     * @author Zhangjc
     * @param farmFlag ture 查询根据猪场区分 false查询不根据猪场区分的
     * @return
     * @throws Exception
     */
    public Map<String, List<Map<String, String>>> getCacheTableData(boolean farmFlag, Long farmId) throws Exception;

    /**
     * @Description: 查询缓存的配置信息
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public List<CacheTablesModel> getCacheTableConfig(boolean farmflag) throws Exception;

    /**
     * @Description: 查询导航栏
     * @author Zhangjc
     * @param companyId
     * @param employeeId
     * @return
     * @throws Exception
     */
    public Map<String, Object> searchMenuByUserId() throws Exception;

    /**
     * @Description: 判断是否在这个表中存在这个ID的数据
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    public boolean isExitDetail(String tableName, String columnName, long[] ids, boolean hasFarm) throws Exception;

    /**
     * @Description: 查询菜单下拉框
     * @author zhangjs
     * @return
     * @throws Exception
     */
    public List<MenuView> searchMenuBobox() throws Exception;

    /**
     * @Description: 获取猪场周次信息
     * @author zhangjs
     * @return week 周次 year , start_date,end_date
     * @throws Exception
     */
    public Map<String, String> getWeekInfo() throws Exception;

    /**
     * @Description: 获取序列号
     * @author zhangjs
     * @param seqName
     * @return
     * @throws Exception
     */
    public long executeGetSeq(String seqName) throws Exception;

}
