package xyz.lemone.lime.core.result;

/**
 * 数据返回基类
 * @param <E>
 */
public class BaseResult<E> extends JsonResult<E> {

    private static final long serialVersionUID = 1L;

    {
        success = true;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
