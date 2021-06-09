package com.admarketplace.codechallenge.client.controller;

import com.admarketplace.codechallenge.client.service.sliding.SlidingWindowRequestCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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