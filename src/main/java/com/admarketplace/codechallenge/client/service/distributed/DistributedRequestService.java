package com.admarketplace.codechallenge.client.service.distributed;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

@RequiredArgsConstructor
public class DistributedRequestService implements DistributedRequestCounterService{

	private final RestTemplate restTemplate;

	@Override
	public boolean allowRequestIn() {
		final UriComponents build = UriComponentsBuilder.fromHttpUrl("https:remote-host")
				.path("/checkrequests")
				.queryParam("requestDate", new Date())
				.build();

		final ResponseEntity<String> response = restTemplate.exchange(build.toUri(),
				HttpMethod.POST, new HttpEntity<>(headers()), String.class);

		return response.getStatusCode().equals(HttpStatus.OK);
	}

	HttpHeaders headers() {
		return new HttpHeaders();
	}
}
