package xyz.lemone.lime.core.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.lemone.lime.core.base.entity.DataEntity;

import java.io.Serializable;

/**
 * service 接口基类
 * 定义基础方法
 * @param <E>
 * @param <I>
 */
public interface BaseService<E extends DataEntity<E,I>,I extends Serializable> extends IService<E> {


    
}
