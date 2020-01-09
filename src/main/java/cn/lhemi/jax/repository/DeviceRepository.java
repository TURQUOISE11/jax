package cn.lhemi.jax.repository;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 存储Channel
 * @author: TURQUOISE
 * @create: 2019/8/8 9:43
 */
public class DeviceRepository {
    /**
     * deviceId->Channel
     */

    private Map<String, ChannelHandlerContext> channelHandlerContextCache = new ConcurrentHashMap<>();

    public boolean containsKey(String key) {
        return channelHandlerContextCache.containsKey(key);
    }

    public boolean containsValue(ChannelHandlerContext value) {
        return channelHandlerContextCache.containsValue(value);
    }

    public DeviceRepository putDeviceCache(String key, ChannelHandlerContext value) {
        channelHandlerContextCache.put(key, value);
        return this;
    }

    public ChannelHandlerContext getDeviceCache(String key) {
        return channelHandlerContextCache.get(key);
    }

    public void removeDeviceCache(String key) {
        this.channelHandlerContextCache.remove(key);
    }

    public int sizeDeviceCache() {
        return this.channelHandlerContextCache.size();
    }

    public Map<String, ChannelHandlerContext> getChannelHandlerContextCache() {
        return channelHandlerContextCache;
    }

    public void setChannelHandlerContextCache(Map<String, ChannelHandlerContext> channelHandlerContextCache) {
        this.channelHandlerContextCache = channelHandlerContextCache;
    }
}
