package xyz.lemone.lime.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lemon
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SystemServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class, args);
    }
}
