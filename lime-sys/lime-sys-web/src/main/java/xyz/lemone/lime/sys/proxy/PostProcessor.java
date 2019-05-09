package xyz.lemone.lime.sys.proxy;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PostProcessor extends MethodProcessor {

    @Override
    public HttpRequestBase doRequest(ServletRequest request) {
        if (request == null || !(request instanceof HttpServletRequest)) {
            return null;
        }

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (!servletRequest.getMethod().equals("POST")) {
            return null;
        }

        // 获得目标url
        String url = uriRoute.routeUri(servletRequest);
        // 目标路径为空，表示不路由
        if (StringUtils.isEmpty(url)) {
            return null;
        }

        // 创建POST请求
        HttpPost httpPost = new HttpPost(url);
        // 处理请求协议
        httpPost.setProtocolVersion(doProtocol(servletRequest));
        // 处理请求头
        httpPost.setHeaders(doHeaders(servletRequest));
        // 处理请求体
        try {
            httpPost.setEntity(new InputStreamEntity(servletRequest.getInputStream()));
        } catch (IOException e) {
            // 取流失败，则要抛出异常，阻止本次请求
            throw new RuntimeException(e);
        }

        return httpPost;
    }
}
