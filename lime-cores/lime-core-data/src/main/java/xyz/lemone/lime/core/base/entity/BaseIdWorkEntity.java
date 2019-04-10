package xyz.lemone.lime.core.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 自动生成全局唯一主键
 * @author lemon
 * @since 2019/3/27
 */
@Data
public class BaseIdWorkEntity extends DataEntity<BaseIdWorkEntity,Long> {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId(value = "id" , type = IdType.ID_WORKER)
    private Long id;


}
