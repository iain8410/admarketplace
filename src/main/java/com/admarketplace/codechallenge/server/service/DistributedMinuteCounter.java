package com.admarketplace.codechallenge.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Component
@RequiredArgsConstructor
public class DistributedMinuteCounter {

	private final RedisCacheQuery redisCacheQuery;

	@Scheduled(fixedRate = 60000)
	public void reset(){
		System.out.println("reset..." + new Date().toString());
		redisCacheQuery.reset();
	}
}
