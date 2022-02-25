package bootcamp.pretest.prob2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AvailabilityDAO {
	private final List<Availability> availabilities = new ArrayList<Availability>();

	public AvailabilityDAO() {
		try {
			availabilities.add(new Availability("Store001", "Prod1", "2021-02-19", 1.0));
			availabilities.add(new Availability("Store001", "Prod1", "2021-02-20", 3.0));
			availabilities.add(new Availability("Store001", "Prod1", "2021-02-21", 0.0));
		} catch (ParseException e) {
			System.out.println("Unable to parse date: " + e.getMessage());
		}
	}

	public List<Availability> getAvailabilities() {
		return availabilities;
	}


	@Override
	public String toString() {
		return String.format("AvailabilityDAO [availabilities=%s]", availabilities);
	}
	
	
}
