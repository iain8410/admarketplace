package com.admarketplace.codechallenge.client.service.distributed;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
public class CalendarResponse {
	private Date requestStart;
	private long numRequests;
}
