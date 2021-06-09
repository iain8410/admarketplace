package com.admarketplace.codechallenge.server.service;

import com.admarketplace.codechallenge.client.service.distributed.CalendarResponse;

import java.util.Date;

public interface CacheQuery {
	Date findRequestStartTime();
	long getNumberRequests();
	void addNumberRequests();
	void reset();
}
