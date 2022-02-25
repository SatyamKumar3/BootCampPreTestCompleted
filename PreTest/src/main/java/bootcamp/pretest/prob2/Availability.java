package bootcamp.pretest.prob2;

import java.text.ParseException;
import java.util.Date;

import bootcamp.pretest.util.DateTimeUtil;


public class Availability {
	private String storeNo;
	private String productId;
	private Date date;
	private Double availQty;
	
	public Availability() {
	}

	public Availability(String storeNo, String productId, Date date, Double availQty) {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.date = date;
		this.availQty = availQty;
	}

	public Availability(String storeNo, String productId, String date, Double availQty) throws ParseException {
		super();
		this.storeNo = storeNo;
		this.productId = productId;
		this.date = DateTimeUtil.parseISOLocalDate(date);
		this.availQty = availQty;
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

	public Double getAvailQty() {
		return availQty;
	}

	public void setAvailQty(Double availQty) {
		this.availQty = availQty;
	}

	@Override
	public String toString() {
		return String.format("Availability [storeNo=%s, productId=%s, date=%s, availQty=%s]", storeNo, productId, date,
				availQty);
	}

	
}
