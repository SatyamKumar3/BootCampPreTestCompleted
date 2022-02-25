package bootcamp.pretest.prob3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import bootcamp.pretest.util.DateTimeUtil;

@Component
public class StoreAvailabilityDAO {

	private final List<Calendar> calendars = new ArrayList<Calendar>();

	public StoreAvailabilityDAO() {
		calendars.add(new Calendar("STORE001", "ALL", DateTimeUtil.parseISOLocalTime("13:30")));
		calendars.add(new Calendar("STORE002", "SUNDAY", DateTimeUtil.parseISOLocalTime("13:30")));
		calendars.add(new Calendar("STORE003", "MONDAY", DateTimeUtil.parseISOLocalTime("13:30")));
	}

	public List<Calendar> getCalendars() {
		return calendars;
	}

}
