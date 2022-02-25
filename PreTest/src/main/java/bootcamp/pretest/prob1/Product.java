package bootcamp.pretest.prob1;

import java.util.Date;

public class Product {
	private String productId;
	private String productName;
	private String unitOfMeasure;
	private Date launchDate;
	
	public Product() {
	}

	public Product(String productId, String productName, String unitOfMeasure, Date launchDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitOfMeasure = unitOfMeasure;
		this.launchDate = launchDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	@Override
	public String toString() {
		return String.format("Product [productId=%s, productName=%s, unitOfMeasure=%s, launchDate=%s]", productId,
				productName, unitOfMeasure, launchDate);
	}
	
	
}
