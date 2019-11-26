package xyz.lemone.lime.core.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.lemone.lime.core.support.mybatis.plus.MetaObjectHandler;

@Configuration
@MapperScan("xyz.lemone.lime.*.mapper*")
public class MyBatisPlusAutoConfiguration {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    
    /**
     * 字段填充
     * @return
     */
    @Bean
    public MetaObjectHandler metaObjectHandler(){
        MetaObjectHandler metaObjectHandler = new MetaObjectHandler() ;
        return metaObjectHandler;
    }

    /**
     * 乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}
