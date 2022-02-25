package bootcamp.pretest.prob1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.POST, path = "/sortProducts")
	public ProductList sortProducts(@RequestBody ProductList productList) {

		ProductList sortedProductList = productService.sortProducts(productList);
		
		return sortedProductList;
	}

}
