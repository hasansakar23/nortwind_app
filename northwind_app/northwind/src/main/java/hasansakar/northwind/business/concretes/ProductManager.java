package hasansakar.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hasansakar.northwind.business.abstracts.ProductService;
import hasansakar.northwind.core.dtos.requests.products.CreateProductRequest;
import hasansakar.northwind.core.dtos.requests.products.DeleteProductRequest;
import hasansakar.northwind.core.dtos.requests.products.UpdateProductRequest;
import hasansakar.northwind.core.dtos.responses.products.ProductResponse;
import hasansakar.northwind.core.mapping.ModelMapperService;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;
import hasansakar.northwind.core.results.SuccesDataResult;
import hasansakar.northwind.core.results.SuccessResult;
import hasansakar.northwind.entitiy.Product;
import hasansakar.northwind.repository.ProductRepository;
@Service
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;
	@Autowired
	public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
		this.modelMapperService=modelMapperService;
		this.productRepository=productRepository;
		
	}
	@Override
	public DataResult<List<ProductResponse>> getAll() {
		List<Product> products= productRepository.findAll();
		List<ProductResponse> response =products.stream().map
				(product -> this.modelMapperService.forResponse().map(product, ProductResponse.class)).collect(Collectors.toList());
	
		
		return new SuccesDataResult<List<ProductResponse>>(response,"Products listed.");
	}
	@Override
	public Result deleteProduct(DeleteProductRequest deleteProductRequest) {
		Product product= this.modelMapperService.forRequest().map(deleteProductRequest, Product.class);
		this.productRepository.delete(product);
		return new SuccessResult("Product deleted from database.");
	}
	@Override
	public Result updateProduct(UpdateProductRequest updateProductRequest) {
		 Product product=this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productRepository.save(product);
		return new SuccessResult("The product updated.");
	}
	@Override
	public Result createProduct(CreateProductRequest createProductRequest) {
		Product product= this.modelMapperService.forRequest().map(createProductRequest, Product.class);
		this.productRepository.save(product);
		return new SuccessResult("The product added in the database.");
	}

}
