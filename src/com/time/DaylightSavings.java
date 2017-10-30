package com.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DaylightSavings {

	public static void main(String[] args) {
		LocalDateTime l1 = LocalDateTime.now();
		
		ZonedDateTime ny = ZonedDateTime.of(l1, ZoneId.of("US/Eastern"));
		
		System.out.println(Duration.between(l1, ny));
	}
	
}
