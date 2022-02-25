package bootcamp.pretest.prob2;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.pretest.util.DateTimeUtil;

@Component
public class CapacityService implements Callable<Integer> {

	@Autowired(required = false)
	private AvailabilityRequest request;

	@Autowired
	private CapacityDAO capacityDAO;

	private static final Logger logger = LoggerFactory.getLogger(CapacityService.class);

	@Override
	public Integer call() throws Exception {
		logger.info("Capacity Thread started Executing");
		
		Date reqDate = DateTimeUtil.parseISOLocalDate(request.getReqDate());

		List<Capacity> capacities = capacityDAO.getCapacities();
		System.out.println("capacities.size(): "+ capacities.size());
		
		long capacity = capacities.stream().filter(c -> c.getStoreNo().equalsIgnoreCase(request.getStoreNo()))
				.filter(c -> c.getProductId().equalsIgnoreCase(request.getProductId()))
				.filter(c -> c.getDate().compareTo(reqDate) == 0).filter(c -> c.getNoOfOrdersAccepted() > 0).count();

		System.out.println("Capacity: " + capacity);

		return (int) capacity;

	}

	public void setRequest(AvailabilityRequest request) {
		this.request = request;
	}

	public void setCapacityDAO(CapacityDAO capacityDAO) {
		this.capacityDAO = capacityDAO;
	}

}
