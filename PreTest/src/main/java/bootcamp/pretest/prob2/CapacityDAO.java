package bootcamp.pretest.prob2;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CapacityDAO {
	private final List<Capacity> capacities = new ArrayList<Capacity>();

	public CapacityDAO() {
		try {
			capacities.add(new Capacity("Store001", "Prod1", "2021-02-19", 0.0));
			capacities.add(new Capacity("Store001", "Prod1", "2021-02-20", 2.0));
			capacities.add(new Capacity("Store001", "Prod1", "2021-02-21", 2.0));
			capacities.add(new Capacity("Store001", "Prod1", "2021-02-22", 0.0));
		} catch (ParseException e) {
			System.out.println("Unable to parse date: " + e.getMessage());
		}
	}

	public List<Capacity> getCapacities() {
		return capacities;
	}

	@Override
	public String toString() {
		return String.format("CapacityDAO [capacities=%s]", capacities);
	}

}
