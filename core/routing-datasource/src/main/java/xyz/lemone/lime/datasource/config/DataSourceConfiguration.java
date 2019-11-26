package xyz.lemone.lime.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import xyz.lemone.lime.datasource.aspect.MasterSlaveAspect;
import xyz.lemone.lime.datasource.jdbc.DatasourceTypeEnum;
import xyz.lemone.lime.datasource.jdbc.MasterSlaveRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/**
 * 数据源配置类
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DataSourceConfiguration {

	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource(DruidDataSource masterDataSource,DruidDataSource slaveDataSource) {
		MasterSlaveRoutingDataSource proxy = new MasterSlaveRoutingDataSource();
		Map<Object, Object> targetDataResources = new HashMap(2);
		targetDataResources.put(DatasourceTypeEnum.MASTER, masterDataSource);
		targetDataResources.put(DatasourceTypeEnum.SLAVE, slaveDataSource);
		proxy.setDefaultTargetDataSource(masterDataSource());
		proxy.setTargetDataSources(targetDataResources);
		proxy.afterPropertiesSet();
		return proxy;
	}

	@Bean
	public MasterSlaveAspect masterSlaveAspect() {
		MasterSlaveAspect masterSlaveAspect = new MasterSlaveAspect();
		return masterSlaveAspect;
	}


	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.master")
	public DruidDataSource masterDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.slave")
	public DruidDataSource slaveDataSource() {
		return DruidDataSourceBuilder.create().build();
	}





}
