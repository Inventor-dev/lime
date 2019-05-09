package xyz.lemone.lime.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.lemone.lime.core.base.entity.DataEntity;

/**
 * 系统用户
 * @author lemon
 * @since 2019/3/24
 */
@Data
@EqualsAndHashCode
@TableName("sys_user")
public class User extends DataEntity<User,Long> {


    private static final long serialVersionUID = -8420819413503034055L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;
    /**
     * 用户编码
     */
    private String code;

    /**
     * 邮件地址
     */
    private String email;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 登录密码
     */
    private String password;


    public User() {
    }
}
