package xyz.lemone.lime.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权服务
 *
 * @author lemon
 */
@SpringBootApplication(scanBasePackages = "xyz.lemone.lime")
public class OauthApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }
    
}
