package xyz.lemone.lime.oauth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author lemon
 */
@Controller
public class LoginController {

    
    @GetMapping("/login.html")
    public String loginPage(){
        return "login";
    }
    
    @GetMapping("/login_form.html")
    public String loginForm(){
        return "login_form";
    }
    
    @GetMapping("/me")
    public @ResponseBody String hello(){
        return "login_form";
    }
    

}
