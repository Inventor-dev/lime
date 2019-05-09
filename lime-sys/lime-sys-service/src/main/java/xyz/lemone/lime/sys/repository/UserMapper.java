package xyz.lemone.lime.sys.repository;

import org.apache.ibatis.annotations.Mapper;
import xyz.lemone.lime.core.base.repository.BaseMapper;
import xyz.lemone.lime.sys.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User,Long> {
}
