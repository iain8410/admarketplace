package com.admarketplace.codechallenge.service.sliding;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class SlidingMinuteCounter {

	public static final Integer WINDOW_SIZE = 60;

	private AtomicLong numRequests = new AtomicLong(0);
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public synchronized void reset(){
		System.out.println("sliding reset..." + new Date().toString());
		numRequests = new AtomicLong(0);

		setDateRange(LocalDateTime.now());
	}

	public void addToCounter(){
		numRequests.getAndIncrement();
	}

	public long getCounter(){
		return numRequests.get();
	}

	public LocalDateTime getStartTime(){
		return startTime;
	}

	public LocalDateTime getEndTime(){
		return endTime;
	}

	public boolean inDateRange(LocalDateTime localDateTime){
		return localDateTime.isAfter(startTime) && localDateTime.isBefore(endTime);
	}

	/** Initialize the sliding window range
	 *
	 * @param startTime LocalDateTime
	 */
	public void setDateRange(LocalDateTime startTime){
		this.startTime = startTime;
		this.endTime = startTime.plusSeconds(WINDOW_SIZE);
		System.out.println("window start time :" + startTime + " end time:" + endTime);
	}
}
