package cn.lhemi.jax.entity;

import io.netty.channel.Channel;
import io.netty.util.concurrent.ScheduledFuture;
import lombok.Data;

/**
 * @description: channel 调度任务
 * @author: TURQUOISE
 * @create: 2018-06-01 16:18
 */
@Data
public class ChannelMessage {
    private Channel channel;
    private ScheduledFuture scheduledFuture;
}
