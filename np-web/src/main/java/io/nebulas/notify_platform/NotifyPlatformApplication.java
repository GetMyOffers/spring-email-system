package io.nebulas.notify_platform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * created by Keqi Huang on 2018/6/14.
 */
@PropertySource({
        "classpath:application.properties",
        "classpath:notifyplatform.properties"
})
@Slf4j
@EnableAutoConfiguration
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"io.nebulas.notify_platform"})
@SpringBootApplication
public class NotifyPlatformApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(NotifyPlatformApplication.class, args);
        log.info("Server Started");
    }
}
