package cn.lhemi.jax;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019-07-30 11:05
 */
@Slf4j
public class JaxServerBootstrap {

    private ServerBootstrap serverBootstrap;
    private InetSocketAddress tcpPort;
    private Channel serverChannel;

    public JaxServerBootstrap() {
    }

    public JaxServerBootstrap(ServerBootstrap serverBootstrap, InetSocketAddress tcpPort) throws InterruptedException {
        this.serverBootstrap = serverBootstrap;
        this.tcpPort = tcpPort;
        serverChannel = serverBootstrap.bind(tcpPort).sync().channel().closeFuture().sync().channel();
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannel.close();
        serverChannel.parent().close();
    }

    public void start() throws Exception {
        serverChannel = serverBootstrap.bind(tcpPort).sync().channel().closeFuture().sync().channel();
        log.info("启动成功! 监听端口: {}", tcpPort);
    }

    public Channel getServerChannel() {
        return serverChannel;
    }

    public void setServerChannel(Channel serverChannel) {
        this.serverChannel = serverChannel;
    }
}
