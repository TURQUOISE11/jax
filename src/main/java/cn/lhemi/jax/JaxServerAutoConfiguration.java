package cn.lhemi.jax;


import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(JaxServerMarkerConfiguration.Mark.class)
@EnableConfigurationProperties(JaxProperties.class)
public class JaxServerAutoConfiguration {
    @Bean
    public JaxProperties jaxProperties() {
        return new JaxProperties();
    }

}
