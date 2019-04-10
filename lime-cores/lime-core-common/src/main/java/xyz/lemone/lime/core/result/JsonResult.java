package xyz.lemone.lime.core.result;

import java.io.Serializable;

/**
 * 数据返回基类
 * @author lemon
 * @since 2019/3/27
 */
public class JsonResult<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 是否执行成功
     */
    protected boolean success;

    /**
     * 返回 消息
     */
    protected String message;
    /**
     * 返回数据内容
     */
    protected E data;

    public JsonResult() {
        super();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
