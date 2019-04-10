package xyz.lemone.lime.core.result.ant;

import lombok.Data;

import java.io.Serializable;

/**
 * Ant Design  分页
 * @author lemon
 * @since 2019/3/27
 */
@Data
public class Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每页显示条数
     */
    private long size ;

    /**
     * 总数据量
     */
    private long total;

    /**
     * 当前页
     */
    private long current ;


    public Pagination(long current, long size, long total) {
        this.size = size;
        this.total = total;
        this.current = current;
    }

}
