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
public class AvailabilityService implements Callable<Integer> {
	private static final Logger logger = LoggerFactory.getLogger(AvailabilityService.class);

	@Autowired(required = false)
	private AvailabilityRequest request;

	@Autowired
	private AvailabilityDAO availabilityDAO;

	@Override
	public Integer call() throws Exception {
		logger.info("Availability Thread started Executing");

		List<Availability> availabilityList = availabilityDAO.getAvailabilities();

		Date reqDate = DateTimeUtil.parseISOLocalDate(request.getReqDate());

		long availability = availabilityList.stream().filter(a -> a.getStoreNo().equalsIgnoreCase(request.getStoreNo()))
				.filter(a -> a.getProductId().compareToIgnoreCase(request.getProductId()) == 0)
				// .filter(a -> a.getDate().compareTo(reqDate) == 0).filter(a -> a.getAvailQty()
				// > request.getReqQty())
				.filter(a -> a.getDate().compareTo(reqDate) == 0).filter(a -> a.getAvailQty() > 0).count();

		System.out.println("Availability: " + availability);

		return (int) availability;
	}

	public void setRequest(AvailabilityRequest request) {
		this.request = request;
	}

	public AvailabilityDAO getAvailabilityDAO() {
		return availabilityDAO;
	}

	public void setAvailabilityDAO(AvailabilityDAO availabilityDAO) {
		this.availabilityDAO = availabilityDAO;
	}

}
