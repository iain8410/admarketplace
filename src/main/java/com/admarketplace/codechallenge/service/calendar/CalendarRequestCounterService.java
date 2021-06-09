package com.admarketplace.codechallenge.service.calendar;

public interface CalendarRequestCounterService {

	boolean allowRequestIn(long currentMinute);
}
