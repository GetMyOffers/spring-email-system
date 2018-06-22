package io.nebulas.notify_platform.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * created by Keqi Huang on 2018/6/20.
 */
@Getter
@Setter
@Configuration
public class DataSourceProperties {
    @Value("${db.driver}")
    private String driverClass;
    @Value("${db.minPoolSize}")
    private int minPoolSize;
    @Value("${db.maxPoolSize}")
    private int maxPoolSize;

    @Value("${db.notifyplatform.username}")
    private String notifyplatformUsername;
    @Value("${db.notifyplatform.password}")
    private String notifyplatformPassword;

    @Value("${db.url4notifyplatform}")
    private String notifyplatformJdbcUrl;
}
