package cn.lhemi.jax.repository;

import cn.lhemi.jax.entity.ChannelMessage;
import lombok.Data;

import java.util.HashMap;

/**
 * Netty相关存储仓库
 *
 * @description:
 * @author: TURQUOISE
 * @create: 2018-06-01 16:16
 */
@Data
public class Repository {
    private HashMap<String, ChannelMessage> channelCache = new HashMap<>();

    public Repository put(String key, ChannelMessage channelMessage) {
        channelCache.put(key, channelMessage);
        return this;
    }

    public Repository set(String key, ChannelMessage channelMessage) {
        ChannelMessage channelMessage1 = channelCache.get(key);
        if (channelMessage.getChannel() != null) {
            channelMessage1.setChannel(channelMessage.getChannel());
        }
        if (channelMessage.getScheduledFuture() != null) {
            channelMessage1.setScheduledFuture(channelMessage.getScheduledFuture());
        }

        channelCache.put(key, channelMessage1);
        return this;
    }

    public ChannelMessage get(String key) {
        return channelCache.get(key);
    }

    public void remove(String key) {
        this.channelCache.remove(key);
    }

    public int size() {
        return this.channelCache.size();
    }
}
