package cn.lhemi.jax.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @description: 初始化
 * @author: TURQUOISE
 * @create: 2019-07-30 10:59
 */
@ChannelHandler.Sharable
public abstract class JaxChannelInitializer extends ChannelInitializer<SocketChannel> {
    private JaxChannelInboundHandler handler = new JaxChannelInboundHandler();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new StringDecoder()).addLast(new StringEncoder()).addLast(handler);
    }
}
