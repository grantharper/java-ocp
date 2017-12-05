package com.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DaylightSavings {

	public static void main(String[] args) {
		LocalDateTime l1 = LocalDateTime.now();
		
		ZonedDateTime ny = ZonedDateTime.of(l1, ZoneId.of("US/Eastern"));
		ZonedDateTime ca = ZonedDateTime.of(l1, ZoneId.of("US/Pacific"));
		System.out.println(ny);
		System.out.println(ca);
		
		System.out.println(Duration.between(l1, ny)); //PT0S
		System.out.println(Duration.between(ny, ca)); //PT3H
		System.out.println(Duration.between(ca, ny)); //PT-3H
		
		LocalDateTime now = LocalDateTime.now(); //like
		LocalDateTime futureThree = now.plusHours(3); //like ca
		System.out.println("3 hours from now:" + Duration.between(now, futureThree));
		
		
		LocalDateTime daylightSavings = LocalDateTime.of(2017, Month.MARCH, 12, 1, 30);
		ZonedDateTime zonedDaylightSavings = ZonedDateTime.of(daylightSavings, ZoneId.of("US/Eastern"));
		
		
		LocalDateTime insensitive = daylightSavings.plusHours(1);
		System.out.println("LocalDateTime doesn't care about daylight savings: " + insensitive);
		ZonedDateTime sensitive = zonedDaylightSavings.plusHours(1);
		System.out.println("ZonedDateTime does care about daylight savings: " + sensitive);
		
		//Duration and Period behave differently around DST
		//Period adds a conceptual day
		System.out.println("Period adds a conceptual day:" + zonedDaylightSavings.plus(Period.ofDays(1)));
		//Duration adds the 24 hours, so it is affected by the time shift
		System.out.println("Duration adds 24 hours:" + zonedDaylightSavings.plus(Duration.ofDays(1)));
		
		
		//when a duration is calculated between two times that are of different type, the second is converted to the first and then compared
		
		LocalTime lt = LocalTime.now();
		ZonedDateTime zdt = LocalDateTime.now().plusHours(1).atZone(ZoneId.of("US/Pacific"));
		
		System.out.println(lt);
		System.out.println(zdt);
		System.out.println("coverts to localtime the compares: " + Duration.between(lt, zdt)); //PT1H
		
		System.out.println("attempts to convert to zoneddatetime then throws exception: " + Duration.between(zdt, lt));
		
		
	}
	
}
