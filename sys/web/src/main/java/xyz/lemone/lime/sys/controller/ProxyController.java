package xyz.lemone.lime.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.lemone.lime.sys.proxy.DefaultHttpProxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 代理控制器
 */

@Controller
public class ProxyController {

    DefaultHttpProxy httpProxy = new DefaultHttpProxy();


    @RequestMapping("/api/**")
    @ResponseBody
    public void api(HttpServletRequest request, HttpServletResponse response) throws IOException {
        httpProxy.execute(request,response);
    }



}
