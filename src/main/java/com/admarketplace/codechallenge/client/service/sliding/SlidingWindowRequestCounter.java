package com.admarketplace.codechallenge.client.service.sliding;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SlidingWindowRequestCounter implements SlidingWindowRequestCounterService {

	public static long MAX_REQUESTS = 100;
	private final SlidingMinuteCounter slidingMinuteCounter;

	@Override
	public boolean allowRequestIn() {
		if ( slidingMinuteCounter.getCounter() == 0L){
			slidingMinuteCounter.reset();
		}

		System.out.println("counter:" + slidingMinuteCounter.getCounter() + " start minute:" + slidingMinuteCounter.getStartTime()
				+ " curr time:" + LocalDateTime.now() + " end minute:" + slidingMinuteCounter.getEndTime());
		if ( slidingMinuteCounter.inDateRange(LocalDateTime.now()) ){
			slidingMinuteCounter.addToCounter();

			if (slidingMinuteCounter.getCounter() < MAX_REQUESTS) {
				System.out.println("       true ");
				return true;
			}
		}
		else {
			slidingMinuteCounter.reset();

			slidingMinuteCounter.addToCounter();

			return true;
		}

		return false;
	}
}
