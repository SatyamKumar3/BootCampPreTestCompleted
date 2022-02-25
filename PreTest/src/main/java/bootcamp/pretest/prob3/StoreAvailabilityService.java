package bootcamp.pretest.prob3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.pretest.util.DateTimeUtil;

@Component
public class StoreAvailabilityService {

	@Autowired
	private StoreAvailabilityDAO storeAvailabilityDAO;
	
	public List<Calendar> checkAvailability(StoreAvailabilityRequest request) {
		LocalTime requestTime = DateTimeUtil.parseISOInstantLocalTime(request.getRequestDate());
		DayOfWeek requestDay = DateTimeUtil.parseISOInstantLocalDate(request.getRequestDate()).getDayOfWeek();

		List<Calendar> calendars = storeAvailabilityDAO.getCalendars();
		
		return calendars.stream().filter(c -> c.getLocationID().equals(request.getStoreID()))
				.filter(c -> c.getCutOffTime().isAfter(requestTime))
				.filter(c -> c.getDay().equals("ALL") || DayOfWeek.valueOf(c.getDay()).equals(requestDay))
				.collect(Collectors.toList());
	}

}
