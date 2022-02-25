package bootcamp.pretest.prob3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreAvailabilityController {

	@Autowired
	StoreAvailabilityService storeAvailabilityService;

	@PostMapping("/findStoreAvailability")
	public ResponseEntity<StoreAvailabilityRequest> findStoreAvailability(
			@RequestBody StoreAvailabilityRequest request) {
		ResponseEntity<StoreAvailabilityRequest> response = null;

		List<Calendar> calendars = storeAvailabilityService.checkAvailability(request);

		if (calendars.size() > 0) {
			request.setStatus("Available");
			response = new ResponseEntity<StoreAvailabilityRequest>(request, HttpStatus.OK);
		} else {
			request.setStatus("Not Available");
			response = new ResponseEntity<StoreAvailabilityRequest>(request, HttpStatus.OK);
		}

		return response;
	}

}
