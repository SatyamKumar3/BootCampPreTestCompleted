package bootcamp.pretest.prob2;

import org.springframework.stereotype.Component;

@Component
public class AvailabilityRequest {
	private String storeNo;
	private String productId;
	private Double reqQty;
	private String reqDate;
	
	public AvailabilityRequest() {
	}

	public AvailabilityRequest(String storeNo, String productId, Double reqQty, String reqDate) {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.reqQty = reqQty;
		this.reqDate = reqDate;
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

	@Override
	public String toString() {
		return String.format("AvailabilityRequest [storeNo=%s, productId=%s, reqQty=%s, reqDate=%s]", storeNo,
				productId, reqQty, reqDate);
	}

	
	
	
}
