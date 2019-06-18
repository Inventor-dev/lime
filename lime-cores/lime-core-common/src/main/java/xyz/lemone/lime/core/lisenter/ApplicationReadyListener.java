package xyz.lemone.lime.core.lisenter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 系统 启动监听
 * @author lemon
 * @version 2018/2/9
 */
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Value("${spring.application.name: }")
    private String serviceName;
    
    @Value("${spring.application.version: }")
    private String serviceVersion;
    
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("\r");
        System.out.println("    ╭────╮         ╭───╮   ╭──── ────╮      ╭───╮       ╭──────╮     ");
        System.out.println("    ╰╮  ╭╯        /  ╭─╯   │    │    │     ╱     ╲      │       ╲    ");
        System.out.println("     │  │        /   ╰─╮   │ ─     ─ │    │       │     │   _   │    ");
        System.out.println("     │  │       │    ╭─╯   │   ╲_╱   │    │   O   │     │   │   │    ");
        System.out.println("     │  │       │    ╰─╮   │         │    │   │   │     │   │   │    ");
        System.out.println("    ╭╯  ╰────╮  │      │   │    │    │     ╲     ╱      │   │   │    ");
        System.out.println("    ╰────────╯  ╰──────╯   ╰────╯────╯      ╰───╯       ╰───┴───╯    ");
        System.out.println("\r");
        System.out.println("    @Inventor-dev :: MicroService -> " + serviceName + " (v" + serviceVersion +")" );
        System.out.println("\r");
    }
}