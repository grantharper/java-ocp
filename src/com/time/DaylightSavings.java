package com.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DaylightSavings {

	public static void main(String[] args) {
		LocalDateTime l1 = LocalDateTime.now();
		
		ZonedDateTime ny = ZonedDateTime.of(l1, ZoneId.of("US/Eastern"));
		ZonedDateTime ca = ZonedDateTime.of(l1, ZoneId.of("US/Pacific"));
		System.out.println(Duration.between(l1, ny));
		System.out.println(Duration.between(ny, ca));
		
		
		LocalDateTime daylightSavings = LocalDateTime.of(2017, Month.MARCH, 12, 1, 30);
		ZonedDateTime zonedDaylightSavings = ZonedDateTime.of(daylightSavings, ZoneId.of("US/Eastern"));
		
		
		LocalDateTime insensitive = daylightSavings.plusHours(1);
		System.out.println("LocalDateTime doesn't care about daylight savings: " + insensitive);
		ZonedDateTime sensitive = zonedDaylightSavings.plusHours(1);
		System.out.println("ZonedDateTime does care about daylight savings: " + sensitive);
		
		
		
		
	}
	
}
