package com.admarketplace.codechallenge.server.controller;

import com.admarketplace.codechallenge.client.service.sliding.SlidingWindowRequestCounter;
import com.admarketplace.codechallenge.server.service.DistributedCalendarRequestCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class DistributedRequestController {

	private final DistributedCalendarRequestCounter distributedCalendarRequestCounter;

	@PostMapping("/checkrequests/{requestDate}")
	public ResponseEntity getAdSliding(@RequestParam(value="requestDate") Date requestDate) {
		if ( distributedCalendarRequestCounter.allowRequestIn(requestDate)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}