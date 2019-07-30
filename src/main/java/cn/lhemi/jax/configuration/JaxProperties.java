package cn.lhemi.jax.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
@ConfigurationProperties("jax")
public class JaxProperties {
    @NotNull
    private String name = "jax";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
