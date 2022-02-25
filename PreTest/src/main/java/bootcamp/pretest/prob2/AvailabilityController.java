package bootcamp.pretest.prob2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController {

	private static final Logger logger = LoggerFactory.getLogger(AvailabilityController.class);
	
	@Autowired
	private AvailabilityService availabilityService;
	
	@Autowired
	private CapacityService capacityService; 
	
	@PostMapping("/getProdAvailability")
	public ResponseEntity<AvailabilityResponse> getProdAvailability(@RequestBody AvailabilityRequest request) throws InterruptedException, ExecutionException {
		ResponseEntity<AvailabilityResponse> responseEntity = null;
		AvailabilityResponse response = new AvailabilityResponse(request);
		
		availabilityService.setRequest(request);
		capacityService.setRequest(request);
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> availabilityFuture = executorService.submit(availabilityService);
		Future<Integer> capacityFuture = executorService.submit(capacityService);

		logger.info("availabilityFuture & capacityFuture will get the result seperately");
		
		/*Basis size of this list which is being returned form DAO layer, controller is preparing the value of status field */
		
		if (availabilityFuture.get() > 0 && capacityFuture.get() == 0) {
			response.setStatus("No Capacity");
			responseEntity = new ResponseEntity<AvailabilityResponse>(response, HttpStatus.OK);
		} else if (availabilityFuture.get() > 0 && capacityFuture.get() > 0) {
			response.setStatus("Available");
			responseEntity = new ResponseEntity<AvailabilityResponse>(response, HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<AvailabilityResponse>(HttpStatus.NO_CONTENT);
		}
//		if (availabilityFuture.get() == 0 && capacityFuture.get() == 1) {
//			responseEntity = new ResponseEntity<AvailabilityResponse>(HttpStatus.NO_CONTENT);
//		}
//		if (availabilityFuture.get() == 0 && capacityFuture.get() == 0) {
//			responseEntity = new ResponseEntity<AvailabilityResponse>(HttpStatus.NO_CONTENT);
//		}
		
		return responseEntity;
		
	}
}
