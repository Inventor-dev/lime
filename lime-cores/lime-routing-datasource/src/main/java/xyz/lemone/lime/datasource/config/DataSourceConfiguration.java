package xyz.lemone.lime.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import xyz.lemone.lime.datasource.aspect.MasterSlaveAspect;
import xyz.lemone.lime.datasource.jdbc.DatasourceTypeEnum;
import xyz.lemone.lime.datasource.jdbc.MasterSlaveRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "productMasterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.product.master")
    public DataSource productMasterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "productSlaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.product.slave")
    public DataSource productSlaveDataSource1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "studyMasterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.study.master")
    public DataSource studyMasterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "studySlaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.study.slave")
    public DataSource studySlaveDataSource1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dataSource")
    public AbstractRoutingDataSource dataSource() {
        MasterSlaveRoutingDataSource proxy = new MasterSlaveRoutingDataSource();
        Map<Object, Object> targetDataResources = new HashMap();
        targetDataResources.put(DatasourceTypeEnum.PRODUCT_MASTER, productMasterDataSource());
        targetDataResources.put(DatasourceTypeEnum.PRODUCT_SLAVE, productSlaveDataSource1());
        targetDataResources.put(DatasourceTypeEnum.STUDY_MASTER, studyMasterDataSource());
        targetDataResources.put(DatasourceTypeEnum.STUDY_SLAVE, studySlaveDataSource1());
        proxy.setDefaultTargetDataSource(productMasterDataSource());
        proxy.setTargetDataSources(targetDataResources);
        proxy.afterPropertiesSet();
        return proxy;
    }

    @Bean
    public MasterSlaveAspect masterSlaveAspect(){
        MasterSlaveAspect masterSlaveAspect = new MasterSlaveAspect() ;
        return masterSlaveAspect;
    }



}
