package cn.lhemi.jax;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019-07-30 08:53
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JaxServerMarkerConfiguration.class)
public @interface EnableJaxServer {
}
