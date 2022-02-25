package bootcamp.pretest.prob2;

public class AvailabilityResponse {
	private String storeNo;
	private String productId;
	private Double reqQty;
	private String reqDate;
	private String status;

	public AvailabilityResponse() {
	}

	public AvailabilityResponse(String storeNo, String productId, Double reqQty, String reqDate, String status) {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.reqQty = reqQty;
		this.reqDate = reqDate;
		this.status = status;
	}
	
	public AvailabilityResponse(AvailabilityRequest availabilityRequest) {
		this.setStoreNo(availabilityRequest.getStoreNo());
		this.setProductId(availabilityRequest.getProductId());
		this.setReqQty(availabilityRequest.getReqQty());
		this.setReqDate(availabilityRequest.getReqDate());
		
	}

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getReqQty() {
		return reqQty;
	}

	public void setReqQty(Double reqQty) {
		this.reqQty = reqQty;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("AvailabilityResponse [storeNo=%s, productId=%s, reqQty=%s, reqDate=%s, status=%s]",
				storeNo, productId, reqQty, reqDate, status);
	}

	

}
