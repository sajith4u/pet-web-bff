package com.ignyte.epet.bff.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "shop-client")
@Getter
@Setter
public class ShopServiceConfig {
    private String baseUrl;
}
