package bootcamp.pretest.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {

	public static Date parseISOLocalDate(String dateString) {
		return Date.from(LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay()
				.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate parseISOInstantLocalDate(String dateTimeString) {
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString,
				DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC));
		return zonedDateTime.toLocalDate();
	}

	public static LocalTime parseISOInstantLocalTime(String dateTimeString) {
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString,
				DateTimeFormatter.ISO_INSTANT.withZone(ZoneOffset.UTC));
		return zonedDateTime.toLocalTime();
	}

	public static LocalTime parseISOLocalTime(String timeStr) {
		return LocalTime.parse(timeStr, DateTimeFormatter.ISO_LOCAL_TIME);
	}

}
