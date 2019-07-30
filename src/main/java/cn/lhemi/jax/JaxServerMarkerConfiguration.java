package cn.lhemi.jax;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: TURQUOISE
 * @create: 2019-07-30 08:52
 */
@Configuration
public class JaxServerMarkerConfiguration {
    @Bean
    public Mark jaxServerMarkerConfiguration() {
        return new Mark();
    }

    class Mark {

    }
}
