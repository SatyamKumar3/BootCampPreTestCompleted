package bootcamp.pretest.prob2;

import java.text.ParseException;
import java.util.Date;

import bootcamp.pretest.util.DateTimeUtil;


public class Capacity {
	private String storeNo;
	private String productId;
	private Date date;
	private Double noOfOrdersAccepted;

	public Capacity() {
	}

	public Capacity(String storeNo, String productId, Date date, Double noOfOrdersAccepted) {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.date = date;
		this.noOfOrdersAccepted = noOfOrdersAccepted;
	}
	
	public Capacity(String storeNo, String productId, String date, Double noOfOrdersAccepted) throws ParseException {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.date = DateTimeUtil.parseISOLocalDate(date);
		this.noOfOrdersAccepted = noOfOrdersAccepted;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getNoOfOrdersAccepted() {
		return noOfOrdersAccepted;
	}

	public void setNoOfOrdersAccepted(Double noOfOrdersAccepted) {
		this.noOfOrdersAccepted = noOfOrdersAccepted;
	}

	@Override
	public String toString() {
		return String.format("Capacity [storeNo=%s, productId=%s, date=%s, noOfOrdersAccepted=%s]", storeNo, productId,
				date, noOfOrdersAccepted);
	}

}
