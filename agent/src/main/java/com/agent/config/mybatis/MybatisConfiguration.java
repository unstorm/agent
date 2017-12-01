package com.agent.config.mybatis;


import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Lazy
@Configuration
@MapperScan(basePackages= {"com.agent.dto"}, sqlSessionFactoryRef="scliteSqlSessionFactory")
@EnableTransactionManagement(proxyTargetClass=false)
public class MybatisConfiguration {

	@Inject
	@Qualifier("datasource")
	private DataSource dataSource;
	
	@Bean
	@Primary
	public SqlSessionFactory sqliteSqlSessionFactory(@Qualifier("datasource") DataSource dataSource,
			ApplicationContext applicationContext) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sql/*_SQL.xml"));
		return sqlSessionFactoryBean.getObject();
		
	}
	
}