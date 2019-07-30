package cn.lhemi.jax.annotation;

import cn.lhemi.jax.JaxServerMarkerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description: 启用注解
 * @author: TURQUOISE
 * @create: 2019-07-30 08:53
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JaxServerMarkerConfiguration.class)
public @interface EnableJaxServer {
}
