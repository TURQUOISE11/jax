package cn.lhemi.jax;


/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019-08-23 11:27
 */
public class JaxServer {
    public static void start() throws Exception {
        JaxServerBootstrap bootstrap = JaxSpringContextUtil.getBean(JaxServerBootstrap.class);
        bootstrap.start();
    }
}
