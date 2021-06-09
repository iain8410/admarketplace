package com.admarketplace.codechallenge.server.service;

import java.util.Date;

public interface DistributedRequestCounter {

	public boolean allowRequestIn(Date requestDate);
}
