package xyz.lemone.lime.core.support.mybatis.plus;

import org.apache.ibatis.reflection.MetaObject;

public class MetaObjectHandler implements com.baomidou.mybatisplus.core.handlers.MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        // TODO 获取当前登录人ID填充新增人
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // TODO 获取当前登录人ID填充修改人
    }
}
