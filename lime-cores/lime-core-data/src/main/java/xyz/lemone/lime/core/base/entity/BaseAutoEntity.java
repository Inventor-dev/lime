package xyz.lemone.lime.core.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 数据库自增加实体
 * @author lemon
 * @since 2019/3/27
 */
@Data
public class BaseAutoEntity extends DataEntity<BaseAutoEntity,Long> {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private Long id;


}
