package cn.lhemi.jax.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @description: Just for fun
 * @author: TURQUOISE
 * @create: 2019/7/31 14:06
 */
@Valid
@ConfigurationProperties("jax")
public class JaxProperties {


    /**
     * 名称
     */
    @NotNull
    private String name = "jax";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
