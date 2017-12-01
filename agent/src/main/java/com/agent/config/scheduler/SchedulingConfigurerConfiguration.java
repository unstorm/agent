package com.agent.config.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.agent.hjsun.test.TimerService;

@Configuration
public class SchedulingConfigurerConfiguration implements SchedulingConfigurer {

	 private static final Logger logger = LoggerFactory.getLogger(TimerService.class);
	
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    	logger.info("설정 시작!!!!!!!!!!!!!!!!!!!!!!!!!");
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(100);
        taskScheduler.initialize();
        taskRegistrar.setTaskScheduler(taskScheduler);
    }
}
