package bootcamp.pretest.prob1;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	List<Product> productList = new ArrayList<Product>();
	
	public ProductList() {
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return String.format("ProductList [productList=%s]", productList);
	}
	
	
}
