package cn.lhemi.jax.entity;

import io.netty.channel.Channel;
import io.netty.util.concurrent.ScheduledFuture;

/**
 * @description: channel 调度任务
 * @author: TURQUOISE
 * @create: 2018-06-01 16:18
 */
public class ChannelMessage {
    private Channel channel;
    private ScheduledFuture scheduledFuture;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public ScheduledFuture getScheduledFuture() {
        return scheduledFuture;
    }

    public void setScheduledFuture(ScheduledFuture scheduledFuture) {
        this.scheduledFuture = scheduledFuture;
    }
}
