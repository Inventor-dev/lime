package lime.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权服务
 *
 * @author lemon
 */
@SpringBootApplication(scanBasePackages = "xyz.lemone.lime")
public class AuthServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
    
}
