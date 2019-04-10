package xyz.lemone.lime.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.lemone.lime.core.lisenter.ApplicationReadyListener;

@Configuration
public class ApplicationAutoConfig {

    @Bean
    public ApplicationReadyListener readyListener(){
        ApplicationReadyListener listener =new ApplicationReadyListener();
        return listener;
    }





}
