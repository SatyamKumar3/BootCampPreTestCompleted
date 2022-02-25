package bootcamp.pretest.prob1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProductService {
	public ProductList sortProducts(ProductList productList) {
		ProductList sortedProductList = new ProductList();
		
		List<Product> sortedProducts = productList.getProductList().stream()
				.sorted(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed())
				.collect(Collectors.toList());
		
		sortedProductList.setProductList(sortedProducts);
		
		return sortedProductList;
	}
}
