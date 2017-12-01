package com.agent.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.agent.config.scheduler.SchedulingConfigurerConfiguration;

@SpringBootApplication
//@EnableScheduling
//@ComponentScan({"com.agent.hjsun.test"})
public class AgentApplication {

	public static void main(String[] args) {
		
		//SchedulingConfigurerConfiguration schedulingConfigurerConfiguration = context.getBean("configureTasks",)
		SpringApplication.run(AgentApplication.class, args);
	}
}
