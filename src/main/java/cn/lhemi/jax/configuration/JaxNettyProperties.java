package cn.lhemi.jax.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description: Netty配置
 * @author: TURQUOISE
 * @create: 2019/7/31 14:06
 */
@Valid
@ConfigurationProperties("jax.netty")
public class JaxNettyProperties {

    /**
     * 监听端口
     */
    @NotNull
    private int port = 9007;
    /**
     * Boss线程数量
     */
    @NotNull
    private int bossCount = 100;
    /**
     * Worker线程数量
     */
    @NotNull
    private int workerCount = 200;
    /**
     * 初始化连接大小
     */
    @NotNull
    private int backlog = 100;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBossCount() {
        return bossCount;
    }

    public void setBossCount(int bossCount) {
        this.bossCount = bossCount;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }

    public int getBacklog() {
        return backlog;
    }

    public void setBacklog(int backlog) {
        this.backlog = backlog;
    }
}
