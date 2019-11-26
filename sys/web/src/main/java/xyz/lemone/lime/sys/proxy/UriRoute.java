package xyz.lemone.lime.sys.proxy;

import javax.servlet.http.HttpServletRequest;

public abstract class UriRoute {

    /**
     * 路由到目标地址
     * @param request
     * @return
     */
    public abstract String routeUri(HttpServletRequest request);
}