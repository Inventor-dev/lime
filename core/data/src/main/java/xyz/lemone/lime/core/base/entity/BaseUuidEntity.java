package xyz.lemone.lime.core.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * UUID 主键
 * @author lemon
 * @since 2019/3/27
 */
@Data
public class BaseUuidEntity extends DataEntity<BaseUuidEntity,Long> {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId(value = "id" , type = IdType.UUID)
    private Long id;


}
