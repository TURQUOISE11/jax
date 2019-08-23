package cn.lhemi.jax.repository;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 存储Channel
 * @author: TURQUOISE
 * @create: 2019/8/8 9:43
 */
public class DeviceIdRepository {
    /**
     * deviceId->Channel
     */

    private Map<String, String> deviceIdCache = new ConcurrentHashMap<>();

    public boolean containsKey(String key) {
        return deviceIdCache.containsKey(key);
    }

    public boolean containsValue(String value) {
        return deviceIdCache.containsValue(value);
    }

    public DeviceIdRepository putDeviceIdCache(String key, String value) {
        deviceIdCache.put(key, value);
        return this;
    }

    public String getDeviceIdCache(String key) {
        return deviceIdCache.get(key);
    }

    public void removeDeviceIdCache(String key) {
        this.deviceIdCache.remove(key);
    }

    public int sizeDeviceIdCache() {
        return this.deviceIdCache.size();
    }

    public Map<String, String> getDeviceIdCache() {
        return deviceIdCache;
    }

    public void setDeviceIdCacheCache(Map<String, String> channelHandlerContextCache) {
        this.deviceIdCache = channelHandlerContextCache;
    }
}
