package xyz.lemone.lime.sys.proxy;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicHeader;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public abstract class MethodProcessor {




    protected UriRoute uriRoute = new DefaultUriRoute();

    protected MethodProcessor processor;

    /**
     * 根据ServletRequest生成HttpRequestBase
     * @param request
     * @return
     */
    public abstract HttpRequestBase doRequest(ServletRequest request);

    /**
     * 处理响应
     * @param servletRes
     * @param proxyRes
     */
    public void doResponse(HttpServletResponse servletRes, CloseableHttpResponse proxyRes) {
        // 处理消息头
        Header[] headers = proxyRes.getAllHeaders();
        if (headers != null) {
            for (Header header : headers) {
                if("Connection".equals(header.getName())){
                    servletRes.addHeader("Connection","keep-alive");
                    continue;
                }
                servletRes.addHeader(header.getName(), header.getValue());
            }
        }
    }

    /**
     * 处理请求协议
     * @param request
     * @return
     */
    protected ProtocolVersion doProtocol(HttpServletRequest request) {
        String protocol = request.getProtocol();
        char[] cProtocol = protocol.toCharArray();
        // https的第4个字符是'S'
        if (cProtocol[4] == 'S') {
            String p = new String(cProtocol, 0, 5); //协议
            int major = Integer.valueOf(new String(cProtocol, 6, 1));   //major
            int minor = Integer.valueOf(new String(cProtocol, 8, 1));   //minor
            return new ProtocolVersion(p, major, minor);
        } else {
            String p = new String(cProtocol, 0, 4); //协议
            int major = Integer.valueOf(new String(cProtocol, 5, 1));   //major
            int minor = Integer.valueOf(new String(cProtocol, 7, 1));   //minor
            return new ProtocolVersion(p, major, minor);
        }
    }

    /**
     * 处理请求头
     * @param request
     * @return
     */
    protected Header[] doHeaders(HttpServletRequest request) {
        List<Header> headers = new ArrayList<Header>(16);
        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getHeader(name);
            headers.add(new BasicHeader(name, value));
        }
        return headers.toArray(new Header[0]);
    }

    public UriRoute getUriRoute() {
        return uriRoute;
    }

    public void setUriRoute(UriRoute uriRoute) {
        this.uriRoute = uriRoute;
    }






}

