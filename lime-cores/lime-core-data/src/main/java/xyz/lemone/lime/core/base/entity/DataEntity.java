package xyz.lemone.lime.core.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 记录基类
 * 所有表必备字段
 * @author lemon
 * @since 2019/3/24
 * @param <E> 实体
 * @param <I> 主键
 */
@Data
public class DataEntity<E extends DataEntity,I extends Serializable> extends Model<E> {

    private static final long serialVersionUID = 1L;
    /**
     * 数据状态 正常
     */
    public static final Integer DATA_FLAG_NORMAL = 0;
    /**
     * 数据状态 删除
     */
    public static final Integer DATA_FLAG_DELETED = 1;
    /**
     * 数据状态 草稿
     */
    public static final Integer DATA_FLAG_TEMP = 2;



    /**
     * 创建人
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private Long creater;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create",fill = FieldFill.INSERT,update="now()")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField(value = "modified_by",fill = FieldFill.INSERT_UPDATE)
    private Long modifier;
    /**
     *  修改时间
     */
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE,update="now()")
    private LocalDateTime modifiedTime;

    /**
     * 数据状态标识
     * @see DataEntity.DATA_FLAG_NORMAL 正常
     * @see DataEntity.DATA_FLAG_DELETED 删除
     * @see DataEntity.DATA_FLAG_TEMP 草稿
     */
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "data_flag",fill = FieldFill.INSERT)
    private Integer dataFlag;


    public DataEntity() {
    }
}
