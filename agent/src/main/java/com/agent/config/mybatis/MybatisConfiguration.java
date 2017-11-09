package com.agent.config.mybatis;

import javax.sql.DataSource;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("oracle")
//@MapperScan("com.agent.mapper")
public class MybatisConfiguration {

	
}