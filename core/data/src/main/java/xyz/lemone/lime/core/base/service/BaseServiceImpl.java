package xyz.lemone.lime.core.base.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.lemone.lime.core.base.entity.DataEntity;
import xyz.lemone.lime.core.base.repository.BaseMapper;

import java.io.Serializable;

/**
 * 基础 service 服务实现类
 * @param <M>
 * @param <E>
 * @param <I>
 */
public class BaseServiceImpl<M extends BaseMapper<E,I>,E extends DataEntity<E,I>,I extends Serializable>
        extends ServiceImpl<M,E> implements BaseService<E,I> {









}
