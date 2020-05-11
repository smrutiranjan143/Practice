package com.practice.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.practice.service.CronService;
@Component
public class OptimizingScheduler{
	
	@Autowired
	private CronService cronservice;
	
	@Scheduled(cron = "0 0 2 * * *")
	public void scheduledUserdetailsUsingCron() {
		cronservice.deleteUserdetails();
	}

}
