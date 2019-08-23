package cn.lhemi.jax;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019-07-30 11:05
 */

public class JaxServerBootstrap {
    private static final Logger logger = LoggerFactory.getLogger(JaxServerBootstrap.class);
    private ServerBootstrap serverBootstrap;
    private InetSocketAddress tcpPort;
    private Channel serverChannel;

    public JaxServerBootstrap() {
    }

    public JaxServerBootstrap(ServerBootstrap serverBootstrap, InetSocketAddress tcpPort) throws InterruptedException {
        this.serverBootstrap = serverBootstrap;
        this.tcpPort = tcpPort;
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannel.close();
        serverChannel.parent().close();
    }

    public void start() throws Exception {
        logger.info("TCP server listen on port : {}", tcpPort.getPort());
        serverChannel = serverBootstrap.bind(tcpPort).sync().channel().closeFuture().sync().channel();
    }

    public Channel getServerChannel() {
        return serverChannel;
    }

    public void setServerChannel(Channel serverChannel) {
        this.serverChannel = serverChannel;
    }
}
