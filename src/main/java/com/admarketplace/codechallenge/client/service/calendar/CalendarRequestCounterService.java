package com.admarketplace.codechallenge.client.service.calendar;

public interface CalendarRequestCounterService {

	boolean allowRequestIn(long currentMinute);
}
