package cn.lhemi.jax;

import cn.lhemi.jax.repository.CtxRepository;
import cn.lhemi.jax.repository.DeviceIdRepository;
import cn.lhemi.jax.repository.DeviceRepository;
import cn.lhemi.jax.repository.Repository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019-08-08 11:53
 */
@Component
public class JaxSpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private static DeviceRepository deviceRepository;
    private static Repository repository;
    private static CtxRepository ctxRepository;
    private static DeviceIdRepository deviceIdRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        JaxSpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getCtx() {
        return JaxSpringContextUtil.applicationContext;
    }

    public static <T> T getBean(Class<T> t) {
        return JaxSpringContextUtil.applicationContext.getBean(t);
    }


    public static DeviceRepository getDeviceRepository() {
        return deviceRepository;
    }

    public static void setDeviceRepository(DeviceRepository deviceRepository) {
        JaxSpringContextUtil.deviceRepository = deviceRepository;
    }

    public static Repository getRepository() {
        return repository;
    }

    public static void setRepository(Repository repository) {
        JaxSpringContextUtil.repository = repository;
    }

    public static CtxRepository getCtxRepository() {
        return ctxRepository;
    }

    public static void setCtxRepository(CtxRepository ctxRepository) {
        JaxSpringContextUtil.ctxRepository = ctxRepository;
    }
    public static DeviceIdRepository getDeviceIdRepository() {
        return deviceIdRepository;
    }

    public static void setDeviceIdRepository(DeviceIdRepository deviceIdRepository) {
        JaxSpringContextUtil.deviceIdRepository = deviceIdRepository;
    }


}
