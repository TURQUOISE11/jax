package cn.lhemi.jax;


import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NasusProperties.class)
public class AutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public NasusProperties nasusProperties(){
        return new NasusProperties();
    }

}
