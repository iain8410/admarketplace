package com.admarketplace.codechallenge.server.service;

import com.admarketplace.codechallenge.client.service.distributed.CalendarResponse;

import java.util.Date;

public class RedisCacheQuery implements CacheQuery {

	// inject the StringRedisTemplate
	// private final StringRedisTemplate redisTemplate;

	@Override
	public Date findRequestStartTime() {
		// hit the redis query
		// SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY kk:mm:ss");
		// redisTemplate.opsForValue.get("calendarStartTime")
		// return sdf.format();

		// form the results
		return new Date();
	}

	@Override
	public long getNumberRequests() {
		// return redisTemplate.opsForValue.get("numRequests");
		return 0;
	}

	@Override
	public void addNumberRequests() {
		// ValueOperations values = redisTemplate.opsForValue();
		// values.set("numRequests", (getNumberRequests() + 1));
	}
}
