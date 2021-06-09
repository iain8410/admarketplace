package com.admarketplace.codechallenge.client.service.calendar;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalendarRequestCounter implements CalendarRequestCounterService {

	public static long MAX_REQUESTS = 100;
	private final MinuteCounter minuteCounter;

	@Override
	public boolean allowRequestIn(long currentMinute) {
		if ( minuteCounter.getMinute() == 0L){
			minuteCounter.setMinute(currentMinute);
		}

		minuteCounter.addToCounter();

		System.out.println("counter:" + minuteCounter.getCounter() + " minute:" + minuteCounter.getMinute() + " curr min:" + currentMinute);
		if ( minuteCounter.getCounter() > MAX_REQUESTS && currentMinute == minuteCounter.getMinute()){
			System.out.println("       false ");
			return false;
		}

		return true;
	}
}
