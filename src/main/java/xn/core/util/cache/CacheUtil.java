package xn.core.util.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;

import xn.core.cache.cachemanager.CacheManager;
import xn.core.cache.cachemanager.CacheTable;
import xn.core.cache.readonlycache.BasicTableCache;
import xn.core.cache.readonlycache.PigInfoReadOnlyCache;
import xn.core.data.enums.CodeEnum;
import xn.core.data.enums.NameEnum;
import xn.core.data.enums.interfaces.ICodeEnum;
import xn.core.data.enums.interfaces.INameEnum;
import xn.core.data.enums.interfaces.IPigInfoEnum;
import xn.core.exception.CacheBusiException;
import xn.core.exception.Thrower;
import xn.core.model.BaseDataModel;
import xn.core.shiro.UserDetail;
import xn.core.util.data.Maps;
import xn.core.util.data.StringUtil;

/**
 * @Description: 根据传入的枚举赋值名字
 * @author zhangjs5
 * @date 2016年5月4日 上午9:27:14
 */
public class CacheUtil {

    /**
     * @Description: 赋值耳牌号名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    // public static <T extends BaseDataModel> List<T> setEarBrand(List<T> list) throws Exception {
    //
    // return setEarBrand(list, NameEnum.EAR_BRAND.getId());
    // }

    /**
     * @Description: 赋值耳牌号名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setEarBrand(List<T> list, String id) throws Exception {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();
                t.set("earBrand", getEarBrand(Maps.getString(map, id, "")));
            }
        }
        return list;
    }

    /**
     * @Description: 获取耳牌号名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static String getEarBrand(String id) throws Exception {

        Map<String, String> map = getData(getFarmId(), "PP_L_EAR_CODE", id);
        return Maps.getString(map, "EAR_BRAND", "");
    }

    /**
     * @Description: 赋值物料名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setMaterialName(List<T> list) throws Exception {

        return setMaterialName(list, NameEnum.MATERIAL_NAME.getId());
    }

    /**
     * @Description: 赋值物料名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setMaterialName(List<T> list, String id) throws Exception {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();
                t.set("materialName", getMaterialName(Maps.getString(map, id, "")));
            }
        }
        return list;
    }

    /**
     * @Description: 获取物料名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static String getMaterialName(String id) throws Exception {

        Map<String, String> map = getData(getFarmId(), "CD_M_MATERIAL", id);
        return Maps.getString(map, "MATERIAL_NAME", "");
    }

    /**
     * @Description: 赋值猪只类型名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setPigClassName(List<T> list) throws Exception {

        return setPigClassName(list, NameEnum.PIG_CLASS_NAME.getId());
    }

    /**
     * @Description: 赋值猪只类型名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setPigClassName(List<T> list, String id) throws Exception {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();
                t.set("pigClassName", getPigClassName(Maps.getString(map, id, "")));
            }
        }
        return list;
    }

    /**
     * @Description: 获取猪只类型名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static String getPigClassName(String id) throws Exception {

        Map<String, String> map = getData("CD_L_PIG_CLASS", id);
        return Maps.getString(map, "PIG_CLASS_NAME", "");
    }

    /**
     * @Description: 赋值编码名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    // public static <T extends BaseDataModel> List<T> setCodeName(List<T> list, CodeEnum typeCode) throws Exception {
    //
    // return setCodeName(list, "codeValue", typeCode);
    // }

    /**
     * @Description: 赋值编码名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    // public static <T extends BaseDataModel> List<T> setCodeName(List<T> list, String id, CodeEnum typeCode) throws Exception {
    //
    // if (list != null && list.size() > 0) {
    // for (T t : list) {
    // Map<String, Object> map = t.getData();
    // t.set(typeCode.getCodeName(), getCodeName(Maps.getString(map, id, ""), typeCode.getTypeCode()));
    // }
    // }
    //
    // return list;
    // }

    /**
     * @Description: 赋值猪舍类型名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setHouseTypeName(List<T> list) throws Exception {

        return setHouseTypeName(list, NameEnum.HOUSE_TYPE_NAME.getId());
    }

    /**
     * @Description: 赋值猪舍类型名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setHouseTypeName(List<T> list, String id) throws Exception {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();
                t.set("houseTypeName", getHouseTypeName(Maps.getString(map, id, "")));
            }
        }
        return list;
    }

    /**
     * @Description: 获取猪舍类型名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static String getHouseTypeName(String houseTypeId) throws Exception {

        Map<String, String> map = getData("CD_L_PIG_HOUSE", houseTypeId);
        return Maps.getString(map, "HOUSE_TYPE_NAME");
    }

    /**
     * @Description: 获取编码名称
     * @author Zhangjc
     * @param indexes
     * @param indexesValue
     * @return
     * @throws Exception
     */
    // public static String getCodeName(String typeCode, String codeValue) throws Exception {
    //
    // return getCodeName("", typeCode, codeValue);
    // }

    /**
     * @Description: 获取编码名称
     * @author Zhangjc
     * @param indexes
     * @param indexesValue
     * @return
     * @throws Exception
     */
    public static String getCodeName(String indexes, String columnName, String typeCode, String codeValue) throws Exception {

        List<Map<String, String>> list = getCodeList(indexes, typeCode.trim() + "," + codeValue.trim());
        if (list != null && list.size() > 0) {
            Map<String, String> map = list.get(0);
            return Maps.getString(map, columnName, "");
        }
        return "";
    }

    /**
     * @Description: 赋值产线名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setLineName(List<T> list) throws Exception {

        return setLineName(list, NameEnum.LINE_NAME.getId());
    }

    /**
     * @Description: 赋值产线名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setLineName(List<T> list, String id) throws Exception {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();
                t.set("lineName", getLineName(Maps.getString(map, id, "")));
            }
        }
        return list;
    }

    /**
     * @Description: 获取产线名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static String getLineName(String lineId) throws Exception {

        Map<String, String> map = getData(getFarmId(), "PP_O_LINE", lineId);
        return Maps.getString(map, "LINE_NAME", "");
    }

    /**
     * @Description: 赋值猪舍名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setHouseName(List<T> list) throws Exception {

        return setHouseName(list, "houseId");
    }

    /**
     * @Description: 赋值猪舍名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setHouseName(List<T> list, String id) throws Exception {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();
                t.set("houseName", getHouseName(Maps.getString(map, id, "")));
            }
        }
        return list;
    }

    /**
     * @Description: 获取猪舍名称
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static String getHouseName(String pighouseId) throws Exception {

        Map<String, String> map = getData(getFarmId(), "PP_O_HOUSE", pighouseId);
        return Maps.getString(map, "HOUSE_NAME", "");
    }

    // ********************************************上面是老的方法************************************************************//

    /**
     * @Description: 获取CD_L_CODE_LIST缓存数据
     * @author Zhangjc
     * @param indexes
     * @param indexesValue
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getCodeList(String indexes, String indexesValue) throws Exception {

        return getList(NameEnum.CODE_NAME.getTableName(), indexes, indexesValue);
    }

    /**
     * @Description: 获取下拉列表
     * @author Zhangjc
     * @param typeCode
     * @param linkValue
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getComboCodeList(String typeCode, String linkValue) throws Exception {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (StringUtil.isBlank(linkValue)) {
            list = getCodeList("typeCode", typeCode);
        } else {
            list = getCodeList("typeCode,linkValue", typeCode + "," + linkValue);
        }
        
        // CodeListReadOnlyCache cache = (CodeListReadOnlyCache) CacheManager.getReadOnlyCache(CodeListReadOnlyCache.class);
        // List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        // list.addAll(cache.getList(typeCode));
        // if (StringUtil.isNonBlank(linkValue) && list != null && list.size() > 0) {
        // for (int i = 0; i < list.size(); i++) {
        // if (!linkValue.equals(list.get(0).get("LINK_VALUE"))) {
        // list.remove(i);
        // i--;
        // }
        // }
        // }
        return list;
    }

    /**
     * @Description: 赋值名字
     * @author Zhangjc
     * @param list
     * @param columns
     * @param typeCode
     * @return
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setName(List<T> list, INameEnum[] columns, ICodeEnum... codeEnums) throws Exception {

        return setName(list, columns, null, codeEnums);
    }

    /**
     * @Description:赋值名字
     * @author Zhangjc
     * @param list
     * @param columns
     * @return
     * @throws Exception
     */
    // public static <T extends BaseDataModel> List<T> setName(List<T> list, NameEnum[] columns) throws Exception {
    //
    // return setName(list, columns);
    // }

    /**
     * @Description: 列表赋值名称操作
     * @author Zhangjc
     * @param list
     * @param columns
     * @param ids
     * @param typeCode
     * @return
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setName(List<T> list, INameEnum[] columns, String[] ids, ICodeEnum... codeEnums)
            throws Exception {

        return setName(list, columns, ids, null, codeEnums);
    }

    /**
     * @Description:列表赋值名称操作
     * @author Zhangjc
     * @param list
     * @param columns
     * @param ids
     * @param names
     * @param codeEnums
     * @return
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setName(List<T> list, INameEnum[] columns, String[] ids, String[] names, ICodeEnum... codeEnums)
            throws Exception {

        if (ids != null && ids.length > 0) {
            if (columns.length != ids.length) {
                Thrower.throwException(CacheBusiException.COMMON_COL_VAL_SIZE_ERROR, "NameEnum数组", "id数组");
            }
        }

        if (names != null && names.length > 0) {
            if (columns.length != names.length) {
                Thrower.throwException(CacheBusiException.COMMON_COL_VAL_SIZE_ERROR, "NameEnum数组", "id数组");
            }
        }

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();

                for (int i = 0; i < columns.length; i++) {
                    INameEnum nameCahe = columns[i];
                    
                    // list中id名称
                    String id = ids != null ? ids[i] : null;
                    // 给页面显示用的名字
                    String name = names != null ? names[i] : null;

                    // id对应的值
                    String idValue = "";
                    // name对应的值
                    String nameValue = "";
                    // 查询codeName特殊处理，并且有多个ID只能配置在CodeEnum
                    if (nameCahe.equals(NameEnum.CODE_NAME)) {
                        if (codeEnums == null || codeEnums.length == 0) {
                            Thrower.throwException(CacheBusiException.SET_NAME_TYPE_CODE_ERROR);
                        }

                        String[] perIds = null;
                        String[] perNames = null;
                        if (StringUtil.isNonBlank(id)) {
                            perIds = id.split(",");
                            if (perIds.length != codeEnums.length) {
                                Thrower.throwException(CacheBusiException.COMMON_COL_VAL_SIZE_ERROR, "codeName的Id", "codeEnums");
                            }
                        }

                        if (StringUtil.isNonBlank(name)) {
                            perNames = name.split(",");
                            if (perNames.length != codeEnums.length) {
                                Thrower.throwException(CacheBusiException.COMMON_COL_VAL_SIZE_ERROR, "codeName的name", "codeEnums");
                            }
                        }

                        for (int j = 0; j < codeEnums.length; j++) {
                            ICodeEnum codeEnum = codeEnums[j];
                            id = perIds != null ? perIds[j] : codeEnum.getCodeId();
                            name = perNames != null ? perNames[j] : codeEnum.getCodeName();
                            idValue = Maps.getString(map, id, "");
                            nameValue = getName(idValue, nameCahe, codeEnum);
                            t.set(name, nameValue);
                        }
                    } else {
                        id = StringUtil.isNonBlank(id) ? id : nameCahe.getId();
                        name = StringUtil.isNonBlank(name) ? name : nameCahe.getName();
                        String[] perIds = id.split(",");
                        String[] perNames = name.split(",");
                        for (int j = 0; j < perIds.length; j++) {
                            idValue = Maps.getString(map, perIds[j], "");
                            nameValue = getName(idValue, nameCahe);
                            t.set(perNames[j], nameValue);
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     * @Description: 赋值名称，不查询codeName
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    // public static <T extends BaseDataModel> List<T> setName(List<T> list, NameEnum nameEnum) throws Exception {
    //
    // String[] ids = nameEnum.getId().split(",");
    // return setName(list, nameEnum, ids);
    // }

    /**
     * @Description: 赋值名称，不查询codeName
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    // public static <T extends BaseDataModel> List<T> setName(List<T> list, String id, NameEnum nameEnum) throws Exception {
    //
    // String[] ids = id.split(",");
    // return setName(list, nameEnum, ids);
    // }

    /**
     * @Description: 赋值名称，不查询codeName
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    // public static <T extends BaseDataModel> List<T> setName(List<T> list, String[] ids, NameEnum nameEnum) throws Exception {
    //
    // return setName(list, nameEnum, ids, null);
    // }

    /**
     * @Description: 赋值名称，查询codeName
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setName(List<T> list, NameEnum nameEnum, CodeEnum... codeEnums) throws Exception {

        String[] ids = nameEnum.getId().split(",");
        String[] names = nameEnum.getName().split(",");
        return setName(list, nameEnum, ids, names, codeEnums);
    }

    /**
     * @Description: 赋值名称，查询codeName
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setName(List<T> list, NameEnum nameEnum, String id, CodeEnum... codeEnums) throws Exception {

        String[] ids = id.split(",");
        String[] names = nameEnum.getName().split(",");
        return setName(list, nameEnum, ids, names, codeEnums);
    }

    /**
     * @Description: 赋值名称，查询codeName
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setName(List<T> list, NameEnum nameEnum, String id, String name, CodeEnum... codeEnums)
            throws Exception {

        String[] ids = id.split(",");
        String[] names = name.split(",");
        return setName(list, nameEnum, ids, names, codeEnums);
    }

    /**
     * @Description: 赋值名称，查询codeName
     * @author Zhangjc
     * @param list
     * @throws Exception
     */
    public static <T extends BaseDataModel> List<T> setName(List<T> list, NameEnum nameEnum, String[] ids, String[] names, CodeEnum... codeEnums)
            throws Exception {

        if (list != null && list.size() > 0) {
            for (T t : list) {
                Map<String, Object> map = t.getData();

                if (codeEnums != null && codeEnums.length > 0) {
                    for (CodeEnum codeEnum : codeEnums) {
                        t.set(codeEnum.getCodeName(), getName(Maps.getString(map, codeEnum.getCodeId(), ""), nameEnum, codeEnum));
                    }
                } else {
                    if (ids == null) {
                        ids = nameEnum.getId().split(",");
                    }
                    if (names == null) {
                        names = nameEnum.getName().split(",");
                    }

                    if (ids.length != names.length) {
                        Thrower.throwException(CacheBusiException.COMMON_COL_VAL_SIZE_ERROR, "name", "id");
                    }
                    for (int i = 0; i < ids.length; i++) {
                        t.set(names[i], getName(Maps.getString(map, ids[i], ""), nameEnum));
                    }
                }
            }
        }
        return list;
    }

    /**
     * @Description: 获取codeName
     * @author Zhangjc
     * @param idValue
     * @param nameEnum
     * @param codeEnum
     * @return
     * @throws Exception
     */
    public static String getName(String idValue, INameEnum nameEnum, ICodeEnum codeEnum) throws Exception {

        idValue = idValue == null ? null : idValue.trim();
        return getName(codeEnum.getTypeCode() + "," + idValue, nameEnum);
    }

    /**
     * @Description: 获取名称
     * @author Zhangjc
     * @param idValue
     * @param nameEnum 如果nameEnum.getIndexe()不为空，则根据索引去查询
     * @return
     * @throws Exception
     */
    public static String getName(String idValue, INameEnum nameEnum) throws Exception {

        Map<String, String> map = null;

        if (nameEnum.getFarmFlag()) {
            // 根据索引查询
            if (StringUtil.isNonBlank(nameEnum.getIndexe())) {
                map = getData(getFarmId(), nameEnum.getTableName(), nameEnum.getIndexe(), idValue);
            } else {
                map = getData(getFarmId(), nameEnum.getTableName(), idValue);
            }
        } else {
            // 根据索引查询
            if (StringUtil.isNonBlank(nameEnum.getIndexe())) {
                map = getData(nameEnum.getTableName(), nameEnum.getIndexe(), idValue);
            } else {
                map = getData(nameEnum.getTableName(), idValue);
            }
        }

        if (map == null) {
            return "";
        }
        return Maps.getString(map, nameEnum.getColumnName(), "");
    }

    /**
     * @Description: 根据主键获取数据信息(区分猪场ID)
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public static Map<String, String> getData(Long farmId, String tableName, String primaryKey) throws Exception {

        farmId = farmId == null ? getFarmId() : farmId;
        CacheTable cacheTable = getCacheTable(farmId, tableName);
        if (cacheTable != null) {
            Map<String, String> map = null;
            try {
                map = cacheTable.getMap(primaryKey);
            }
            catch (Exception e) {
                map = null;
            }
            if (map != null) {
                return map;
            }
        }
        return new HashMap<String, String>();
    }

    /**
     * @Description: 根据索引获取获取数据信息(区分猪场ID)
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public static Map<String, String> getData(Long farmId, String tableName, String indexes, String indexesValue) throws Exception {

        List<Map<String, String>> list = getList(farmId, tableName, indexes, indexesValue);
        if (list != null && list.size() > 0) {
            Map<String, String> map = list.get(0);
            return map;
        }
        return new HashMap<String, String>();
    }

    /**
     * @Description: 根据主键获取数据信息（不区分猪场ID）
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public static Map<String, String> getData(String tableName, String primaryKey) throws Exception {

        CacheTable cacheTable = getCacheTable(tableName);
        if (cacheTable != null) {
            Map<String, String> map;
            try {
                map = cacheTable.getMap(primaryKey);
            }
            catch (Exception e) {
                map = null;
            }
            if (map != null) {
                return map;
            }
        }
        return new HashMap<String, String>();
    }

    /**
     * @Description: 根据索引获取数据信息（不区分猪场ID）
     * @author Zhangjc
     * @param indexes
     * @param indexesValue
     * @return
     * @throws Exception
     */
    public static Map<String, String> getData(String tableName, String indexes, String indexesValue) throws Exception {

        List<Map<String, String>> list = getList(tableName, indexes, indexesValue);
        if (list != null && list.size() > 0) {
            Map<String, String> map = list.get(0);
            return map;
        }
        return new HashMap<String, String>();
    }

    /**
     * @Description: 根据索引获取缓存信息（区分猪场ID）
     * @author Zhangjc
     * @param indexes
     * @param indexesValue
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getList(Long farmId, String tableName, String indexes, String indexesValue) throws Exception {

        farmId = farmId == null ? getFarmId() : farmId;
        CacheTable cacheTable = getCacheTable(farmId, tableName);
        if (cacheTable != null) {
            List<Map<String, String>> list = null;
            try {
                list = cacheTable.getList(indexes, indexesValue);
            }
            catch (Exception e) {
                list = null;
            }
            if (list != null) {
                return list;
            }
        }
        return new ArrayList<Map<String, String>>();
    }

    /**
     * @Description: 根据索引获取缓存信息（不区分猪场ID）
     * @author Zhangjc
     * @param indexes
     * @param indexesValue
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getList(String tableName, String indexes, String indexesValue) throws Exception {

        CacheTable cacheTable = getCacheTable(tableName);
        if (cacheTable != null) {
            List<Map<String, String>> list = null;
            try {
                list = cacheTable.getList(indexes, indexesValue);
            }
            catch (Exception e) {
                list = null;
            }
            if (list != null) {
                return list;
            }
        }
        return new ArrayList<Map<String, String>>();
    }

    /**
     * @Description: 获取缓存中的CACHETABLE(区分猪场ID)
     * @author Zhangjc
     * @param tableName
     * @return
     * @throws Exception
     */
    private static CacheTable getCacheTable(long farmId, String tableName) throws Exception {

        tableName = tableName.toUpperCase();
        // 取缓存中的表
        BasicTableCache tableCache = (BasicTableCache) CacheManager.getReadOnlyCache(BasicTableCache.class);
        CacheTable cacheTable = tableCache.getCacheTable(farmId, tableName);
        return cacheTable;
    }

    /**
     * @Description: 获取缓存中的CACHETABLE（不区分猪场ID）
     * @author Zhangjc
     * @param tableName
     * @return
     * @throws Exception
     */
    private static CacheTable getCacheTable(String tableName) throws Exception {

        tableName = tableName.toUpperCase();
        // 取缓存中的表
        BasicTableCache tableCache = (BasicTableCache) CacheManager.getReadOnlyCache(BasicTableCache.class);
        CacheTable cacheTable = tableCache.getCacheTable(tableName);
        return cacheTable;
    }

    /**
     * @Description: 刷新缓存
     * @author Zhangjc
     * @throws Exception
     */
    public static void BasicTableCaheRefresh(long farmId) throws Exception {

        BasicTableCache tableCache = (BasicTableCache) CacheManager.getReadOnlyCache(BasicTableCache.class);
        tableCache.refresh(farmId);
    }

    /**
     * @Description: 刷新缓存
     * @author Zhangjc
     * @throws Exception
     */
    public static void BasicTableCaheRefresh() throws Exception {

        BasicTableCache tableCache = (BasicTableCache) CacheManager.getReadOnlyCache(BasicTableCache.class);
        tableCache.refresh();
    }

    /**
     * @Description:获取SESSION中的猪场ID
     * @author Zhangjc
     * @return
     */
    public static long getFarmId() {

    	UserDetail user = (UserDetail) SecurityUtils.getSubject().getSession().getAttribute("userDetail");
        return user.getFarmId();
    }

    // *********************************************猪只信息缓存BEGIN*****************************************************//
    /**
     * @Description: 获取猪只缓存
     * @author Zhangjc
     * @param pigId
     * @param pigInfoEnum
     * @return
     * @throws Exception
     */
    public static Map<String, String> getPigInfo(String pigId, IPigInfoEnum pigInfoEnum) throws Exception {

        return getPigInfo(pigId, pigInfoEnum, pigInfoEnum.getName());
    }

    /**
     * @Description: 获取猪只缓存
     * @author Zhangjc
     * @param pigId
     * @param pigInfoEnum
     * @return
     * @throws Exception
     */
    public static Map<String, String> getPigInfo(String pigId, IPigInfoEnum pigInfoEnum, String names) throws Exception {

        String[] name = names.split(",");
        return getPigInfo(pigId, pigInfoEnum, name);
    }

    /**
     * @Description: 获取猪只缓存
     * @author Zhangjc
     * @param pigId
     * @param pigInfoEnum
     * @param names
     * @return
     * @throws Exception
     */
    public static Map<String, String> getPigInfo(String pigId, IPigInfoEnum pigInfoEnum, String[] name) throws Exception {

        // 取缓存猪只信息
        Map<String, String> map = getPigInfoCahe().getPigInfo(getFarmId(), pigId);

        if (name == null) {
            Thrower.throwException(CacheBusiException.PARAM_NOT_NULL_ERROR, "name");
        }
        // 缓存中的字段
        String ids = pigInfoEnum.getId();
        String[] id = ids.split(",");

        if (id.length != name.length) {
            Thrower.throwException(CacheBusiException.COMMON_COL_VAL_SIZE_ERROR, "name", "id");
        }
        // 页面中需要显示的名称
        Map<String, String> result = new HashMap<String, String>();
        for (int i = 0; i < id.length; i++) {
            result.put(name[i], Maps.getString(map, id[i], ""));
        }
        return result;
    }

    /**
     * @Description: 刷新猪只缓存
     * @author Zhangjc
     * @throws Exception
     */
    public static void PigInfoCaheRefresh() throws Exception {

        getPigInfoCahe().refresh();
    }

    /**
     * @Description: 刷新猪只缓存 根据猪场区分 PP_L_EAR_CODE CD_L_PIG_CLASS CD_L_BREED CD_L_CODE_LIST
     * @author Zhangjc
     * @throws Exception
     */
    public static void PigInfoCaheRefresh(long farmId) throws Exception {

        getPigInfoCahe().refresh(farmId);
    }

    /**
     * @Description: 获取猪只信息缓存
     * @author Zhangjc
     * @return
     * @throws Exception
     */
    private static PigInfoReadOnlyCache getPigInfoCahe() throws Exception {

        return (PigInfoReadOnlyCache) CacheManager.getReadOnlyCache(PigInfoReadOnlyCache.class);
    }
    // *********************************************猪只信息缓存END*****************************************************//
}
