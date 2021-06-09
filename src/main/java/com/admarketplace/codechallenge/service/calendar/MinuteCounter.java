package com.admarketplace.codechallenge.service.calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MinuteCounter {

	private AtomicLong numRequests = new AtomicLong(0);
	private AtomicLong minuteVar = new AtomicLong(0);

	@Scheduled(fixedRate = 60000)
	public void reset(){
		System.out.println("reset..." + new Date().toString());
		numRequests = new AtomicLong(0);
		minuteVar = new AtomicLong(0);
	}

	public void addToCounter(){
		numRequests.getAndIncrement();
	}

	public long getCounter(){
		return numRequests.get();
	}

	public long getMinute(){
		return minuteVar.get();
	}

	public void setMinute(long minute){
		minuteVar.set(minute);
	}
}
