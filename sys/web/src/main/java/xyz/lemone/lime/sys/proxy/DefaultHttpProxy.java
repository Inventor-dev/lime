package xyz.lemone.lime.sys.proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class DefaultHttpProxy {
    private static final Log log = LogFactory.getLog(DefaultHttpProxy.class);
    private static ConnectionManager connectionFactory = new ConnectionManager();
    private static MethodProcessor methodProcessor = new MethodProcessorBuilder().build();

    public static MethodProcessor getMethodProcessor() {
        return methodProcessor;
    }

    public static void setMethodProcessor(MethodProcessor methodProcessor) {
        DefaultHttpProxy.methodProcessor = methodProcessor;
    }

    /**
     * 执行url请求
     */
    public boolean execute(ServletRequest request, ServletResponse response) {
        long beforeTime = System.currentTimeMillis();
        // 根据request创建请求
        HttpRequestBase httpRequest = methodProcessor.doRequest(request);
        if (httpRequest == null) {
            return false;
        }

        // 从连接池中获得HttpClient
        CloseableHttpClient httpClient = connectionFactory.getHttpClient();
        CloseableHttpResponse proxyRes = null;
        try {
            HttpClientContext httpContext = HttpClientContext.create();
            proxyRes = httpClient.execute(httpRequest, httpContext);
            HttpServletResponse servletRes = (HttpServletResponse) response;
            methodProcessor.doResponse(servletRes, proxyRes);
            HttpEntity entity = proxyRes.getEntity();
            if (proxyRes.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                OutputStream outputStream = response.getOutputStream();
                entity.writeTo(outputStream);
                outputStream.flush();
            } else {
                servletRes.sendError(proxyRes.getStatusLine().getStatusCode());
            }
            long afterTime = System.currentTimeMillis();
            log.info("-----代理耗时["+(afterTime-beforeTime)+"ms]-----");
        } catch (IOException e) {
            log.error("", e);
            return false;
        }
        return true;
    }
}