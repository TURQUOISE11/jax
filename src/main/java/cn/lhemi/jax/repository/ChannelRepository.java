package cn.lhemi.jax.repository;

import io.netty.channel.Channel;
import lombok.Data;

import java.util.HashMap;

/**
 * 存储Channel
 *
 * @Author: TURQUOISE
 * @Description:
 * @Date: Created in 2018/3/27 15:46
 */
@Data
public class ChannelRepository {
    /**
     * clientId->Channel
     */
    private HashMap<String, Channel> channelCache = new HashMap<>();

    public ChannelRepository putChannelCache(String key, Channel value) {
        channelCache.put(key, value);
        return this;
    }

    public Channel getChannelCache(String key) {
        return channelCache.get(key);
    }

    public void removeChannelCache(String key) {
        this.channelCache.remove(key);
    }

    public int sizeChannelCache() {
        return this.channelCache.size();
    }

}
