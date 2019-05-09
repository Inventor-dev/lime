package xyz.lemone.lime.sys.proxy;

import javax.servlet.http.HttpServletRequest;

public class DefaultUriRoute extends UriRoute {

    String urlPrefix = "https://preview.pro.ant.design:443";

    @Override
    public String routeUri(HttpServletRequest request) {
        return urlPrefix + request.getRequestURI();
    }
}
