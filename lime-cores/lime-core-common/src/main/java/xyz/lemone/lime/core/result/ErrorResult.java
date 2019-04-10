package xyz.lemone.lime.core.result;

import org.springframework.http.HttpStatus;

/**
 * 错误信息返回类
 * @author lemon
 * @since 2019/3/27
 */
public class ErrorResult<E> extends JsonResult<E> {

    private static final long serialVersionUID = 305397469774011470L;

    {
        success  = false;
        // 默认 500
        status  =HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    /**
     * 返回状态码
     * {@link HttpStatus}
     */
    protected Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}