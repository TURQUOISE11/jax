package cn.lhemi.jax.channel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

/**
 * @description:  处理handler
 * @author: TURQUOISE
 * @create: 2019-07-30 11:01
 */
@Component
public class JaxChannelInboundHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    }
}
