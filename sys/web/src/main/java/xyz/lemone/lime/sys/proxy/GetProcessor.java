package xyz.lemone.lime.sys.proxy;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class GetProcessor extends MethodProcessor {

	MethodProcessor  NEXT_METHOD;

    public GetProcessor() {
        super();
        // 指向POST请求处理方式
        NEXT_METHOD = new PostProcessor();
    }

    /**
     * 根据ServletRequest生成HttpRequestBase
     * @param request
     * @return
     */
    @Override
    public HttpRequestBase doRequest(ServletRequest request) {
        if (request == null || !(request instanceof HttpServletRequest)) {
            return null;
        }

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (!servletRequest.getMethod().equals("GET")) {
            return NEXT_METHOD.doRequest(request);
        }


        // 获得目标url
        String url = uriRoute.routeUri(servletRequest);
        // 目标路径为空，表示不路由
        if (StringUtils.isEmpty(url)) {
            return null;
        }

        // 创建get请求
        HttpGet httpGet = new HttpGet(url);
        // 处理请求协议
        httpGet.setProtocolVersion(doProtocol(servletRequest));
        // 处理请求头
        httpGet.setHeaders(doHeaders(servletRequest));

        return httpGet;
    }
}