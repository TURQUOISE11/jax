package cn.lhemi.jax;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @description: JaxServer 启动
 * @author: TURQUOISE
 * @create: 2019-07-30 11:05
 */

public class JaxServerBootstrap {
    private static final Logger logger = LoggerFactory.getLogger(JaxServerBootstrap.class);
    private ServerBootstrap serverBootstrap;
    private InetSocketAddress tcpPort;
    private ChannelFuture channelFuture;

    public JaxServerBootstrap() {
    }

    public JaxServerBootstrap(ServerBootstrap serverBootstrap, InetSocketAddress tcpPort) throws InterruptedException {
        this.serverBootstrap = serverBootstrap;
        this.tcpPort = tcpPort;
    }

    @PreDestroy
    public void stop() throws Exception {
        channelFuture.channel().close();
        channelFuture.channel().parent().close();
    }

    public void start() throws Exception {
        channelFuture = serverBootstrap.bind(tcpPort).sync();
        logger.info("TCP server listen on port : {}", tcpPort.getPort());
    }

    public boolean isActive() {
        return channelFuture != null && channelFuture.channel().isActive();
    }
}
