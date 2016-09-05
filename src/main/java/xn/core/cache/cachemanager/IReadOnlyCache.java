package xn.core.cache.cachemanager;

import java.util.Map;

/**
 * @Description: 缓存类接口
 * @author zhangjs5
 * @date 2016年5月3日 下午5:48:57
 */
public interface IReadOnlyCache {

    /**
     * @Description: 刷新缓存
     * @author zhangjs5
     * @throws Exception
     */
    public void refresh() throws Exception;

    /**
     * @Description: 获取缓存
     * @author zhangjs5
     * @param name
     * @return
     * @throws Exception
     */
    public Object get(String name) throws Exception;

    /**
     * @Description: 加载数据
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public Map<String, Object> loadData() throws Exception;

    /**
     * @Description: 加载条数
     * @author Zhangjc
     * @return
     */
    public int size();

    /**
     * @Description: 取缓存类
     * @author Zhangjc
     * @return
     */
    public String getClassName();

    /**
     * @Description: 存缓存类
     * @author Zhangjc
     * @param paramString
     */
    public void setClassName(String paramString);

}
