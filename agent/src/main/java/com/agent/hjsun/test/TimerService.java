package com.agent.hjsun.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimerService {
	 private static final Logger logger = LoggerFactory.getLogger(TimerService.class);
	 private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	 
	 private static final int interval = 2000;
	 
	 @Scheduled(fixedRate = interval)
	  public void fixedRate() throws Exception{
		 logger.info("Fixed fixedRate Task :: Execution Time - {}", dateFormat.format(new Date()) );		 
	  }
	 
//	 @Scheduled(fixedDelay = interval)
//	 public void fixedDelay() throws Exception{
//		 logger.info("Fixed fixedDelay Task :: Execution Time - {}", dateFormat.format(new Date()) );
//		 Thread.sleep(3000);
//	 }
	 
}
