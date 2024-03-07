package hasansakar.northwind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hasansakar.northwind.business.abstracts.ProductService;
import hasansakar.northwind.core.dtos.requests.products.CreateProductRequest;
import hasansakar.northwind.core.dtos.requests.products.DeleteProductRequest;
import hasansakar.northwind.core.dtos.requests.products.UpdateProductRequest;
import hasansakar.northwind.core.dtos.responses.products.ProductResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

@RestController
@RequestMapping("/products")
public class ProductsController {
	private ProductService productService;
	@Autowired
	public ProductsController(ProductService productService ) {
		this.productService=productService;
	}

	@GetMapping("/getAll")
	public DataResult<List<ProductResponse>> getAll(){
		return productService.getAll();
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteProductRequest deleteProductRequest) {
		return this.productService.deleteProduct(deleteProductRequest);
	}
	@PutMapping("/update")
	public Result update(@RequestBody UpdateProductRequest updateProductRequest) {
		return this.productService.updateProduct(updateProductRequest);
	}
	@PostMapping("/add")
	public Result create(@RequestBody CreateProductRequest createProductRequest ) {
		return this.productService.createProduct(createProductRequest);
	}
}
