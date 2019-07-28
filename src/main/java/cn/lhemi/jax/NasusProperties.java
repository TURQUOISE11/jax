package cn.lhemi.jax;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
@ConfigurationProperties("jax")
public class NasusProperties {
    @NotNull
    private String name = "何蜜";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
