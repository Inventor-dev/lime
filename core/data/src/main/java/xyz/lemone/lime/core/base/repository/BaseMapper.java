package xyz.lemone.lime.core.base.repository;

import xyz.lemone.lime.core.base.entity.DataEntity;

import java.io.Serializable;

/**
 * 基础Mapper 类
 * @param <E> 元素类型
 * @param <I> 主键
 */
public interface BaseMapper<E extends DataEntity<E,I>,I extends Serializable> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<E> {




}
