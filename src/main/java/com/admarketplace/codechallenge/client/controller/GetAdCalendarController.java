package com.admarketplace.codechallenge.client.controller;

import com.admarketplace.codechallenge.client.service.calendar.CalendarRequestCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class GetAdCalendarController {

	private final CalendarRequestCounter requestCounterService;

	@GetMapping("/getad/calendar")
	public ResponseEntity getAd() {
		if ( requestCounterService.allowRequestIn(LocalDateTime.now().getMinute())) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}