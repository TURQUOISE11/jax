package cn.lhemi.jax;


import cn.lhemi.jax.channel.JaxChannelInitializer;
import cn.lhemi.jax.configuration.JaxNettyProperties;
import cn.lhemi.jax.configuration.JaxProperties;
import cn.lhemi.jax.repository.ChannelRepository;
import cn.lhemi.jax.repository.Repository;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019/7/30 13:57
 */
@Slf4j
@Configuration
@ConditionalOnBean(JaxServerMarkerConfiguration.Mark.class)
@EnableConfigurationProperties({JaxProperties.class, JaxNettyProperties.class})
public class JaxServerAutoConfiguration implements SmartLifecycle {
    @Autowired
    private JaxNettyProperties jaxNettyProperties;
    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    @Bean
    public JaxNettyProperties jaxNettyProperties() {
        return new JaxNettyProperties();
    }

    public ServerBootstrap bootstrap() {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup())
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(jaxChannelInitializer)
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();
        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
        for (@SuppressWarnings("rawtypes") ChannelOption option : keySet) {
            b.option(option, tcpChannelOptions.get(option));
        }
        return b;
    }

    @Autowired
//    @Qualifier("jaxChannelInitializer")
    private JaxChannelInitializer jaxChannelInitializer;

    @Bean(name = "tcpChannelOptions")
    public Map<ChannelOption<?>, Object> tcpChannelOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<>();
        options.put(ChannelOption.SO_BACKLOG, jaxNettyProperties.getBacklog());
        return options;
    }

    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(jaxNettyProperties.getBossCount());
    }

    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(jaxNettyProperties.getWorkerCount());
    }

    @Bean(name = "tcpSocketAddress")
    public InetSocketAddress tcpPort() {
        return new InetSocketAddress(jaxNettyProperties.getPort());
    }

    @Bean(name = "channelRepository")
    public ChannelRepository channelRepository() {
        return new ChannelRepository();
    }

    @Bean(name = "repository")
    public Repository repository() {
        return new Repository();
    }


//    @Bean
//    public JaxServerBootstrap jaxServerBootstrap() throws InterruptedException {
//        return new JaxServerBootstrap(serverBootstrap,tcpPort);
//    }


    @Override
    public void start() {
        try {
            new JaxServerBootstrap(bootstrap(), tcpPort).start();
        } catch (Exception e) {
            log.error("启动失败!");
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
