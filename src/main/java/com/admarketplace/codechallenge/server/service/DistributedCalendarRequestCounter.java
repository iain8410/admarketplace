package com.admarketplace.codechallenge.server.service;

import com.admarketplace.codechallenge.client.service.calendar.CalendarRequestCounterService;
import com.admarketplace.codechallenge.client.service.calendar.MinuteCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DistributedCalendarRequestCounter implements DistributedRequestCounter {

	public static long MAX_REQUESTS = 100;

	private final RedisCacheQuery redisCacheQuery;

	@Override
	public boolean allowRequestIn(Date requestDate) {
		Date calendarStartTime = redisCacheQuery.findRequestStartTime();
		long numRequests = redisCacheQuery.getNumberRequests();
		long calMinute = getMinute(calendarStartTime);
		long reqMinute = getMinute(requestDate);

		redisCacheQuery.addNumberRequests();

		System.out.println("cal start:" + calendarStartTime + " req minute:" + reqMinute);
		if ( numRequests > MAX_REQUESTS && calMinute == reqMinute){
			System.out.println("       false ");
			return false;
		}

		return true;
	}

	private long getMinute(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}
}
