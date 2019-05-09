package xyz.lemone.lime.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"xyz.lemone.lime.core","xyz.lemone.lime.sys"})
@EnableFeignClients(basePackageClasses = {xyz.lemone.lime.api.sys.Constants.class})
public class SystemWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(SystemWebApplication.class, args);
    }

}
