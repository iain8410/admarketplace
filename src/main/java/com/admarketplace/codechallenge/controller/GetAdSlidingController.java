package com.admarketplace.codechallenge.controller;

import com.admarketplace.codechallenge.service.calendar.CalendarRequestCounter;
import com.admarketplace.codechallenge.service.sliding.SlidingMinuteCounter;
import com.admarketplace.codechallenge.service.sliding.SlidingWindowRequestCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class GetAdSlidingController {

	private final SlidingWindowRequestCounter slidingWindowRequestCounter;

	@GetMapping("/getad/sliding")
	public ResponseEntity getAdSliding() {
		if ( slidingWindowRequestCounter.allowRequestIn()) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}