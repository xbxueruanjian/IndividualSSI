package xn.core.cache.cachemanager;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @Description: 抽象只读缓存类
 * @author Zhangjc
 * @date 2016年5月11日 下午2:49:21
 */
public abstract class AbstractReadOnlyCache implements IReadOnlyCache {

    private static Logger log = Logger.getLogger(AbstractReadOnlyCache.class);

    private Map<String, Object> cache;

    private Map<Long, Object> cacheByFarm;

    private String className;

    public AbstractReadOnlyCache() {
    }

    public AbstractReadOnlyCache(Map<String, Object> map) {
        cache = map;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @Description: 根据猪场ID刷新需要根据猪场分割的缓存
     * @author Zhangjc
     * @param farmId
     * @throws Exception
     */
    public synchronized void refresh(long farmId) throws Exception {

        log.info("需要猪场分割只读缓存刷新! className:" + getClassName() + "farmId:" + farmId);
        if (cacheByFarm != null) {
            cacheByFarm.remove(farmId);
            cacheByFarm.put(farmId, loadDataByFarm(farmId));
        }
        // 缓存为空全量刷新
        else {
            refresh();
        }
    }

    @Override
    public synchronized void refresh() throws Exception {

        log.info("只读缓存刷新! className:" + getClassName());

        log.info("需要猪场分割只读缓存刷新! className:" + getClassName());
        Map<Long, Object> newCacheByFarm = loadDataByFarm();
        Map<Long, Object> oldCacheByFarm = cacheByFarm;
        cacheByFarm = newCacheByFarm;

        if (oldCacheByFarm != null) {
            oldCacheByFarm.clear();
            oldCacheByFarm = null;
        }

        log.info("普通只读缓存刷新! className:" + getClassName());
        Map<String, Object> newCache = loadData();
        Map<String, Object> oldCache = cache;
        cache = newCache;

        if (oldCache != null) {
            oldCache.clear();
            oldCache = null;
        }
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public Object get(long farmId) {
        return cacheByFarm.get(farmId);
    }

    @Override
    public int size() {
        int farmSize = cacheByFarm != null ? cacheByFarm.size() : 0;
        int size = cache != null ? cache.size() : 0;
        return size + farmSize;
    }

    public Set<String> keySet() {
        return cache != null ? cache.keySet() : null;
    }

    @Override
    public abstract Map<String, Object> loadData() throws Exception;

    /**
     * @Description: 加载数据根据猪场区分
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public abstract Map<Long, Object> loadDataByFarm() throws Exception;

    /**
     * @Description: 加载数据根据猪场区分 根据FarmId加载对应猪场
     * @author zhangjs5
     * @return
     * @throws Exception
     */
    public abstract Object loadDataByFarm(long farmId) throws Exception;
}

