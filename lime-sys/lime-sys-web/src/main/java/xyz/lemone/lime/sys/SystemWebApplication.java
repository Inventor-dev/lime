package xyz.lemone.lime.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableOAuth2Sso
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"xyz.lemone.lime.core", "xyz.lemone.lime.sys"})
@EnableFeignClients(basePackageClasses = {xyz.lemone.lime.api.sys.Constants.class})
public class SystemWebApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SystemWebApplication.class, args);
    }
    
}
