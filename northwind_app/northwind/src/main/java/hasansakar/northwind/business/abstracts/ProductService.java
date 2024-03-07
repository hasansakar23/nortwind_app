package hasansakar.northwind.business.abstracts;

import java.util.List;

import hasansakar.northwind.core.dtos.requests.products.CreateProductRequest;
import hasansakar.northwind.core.dtos.requests.products.DeleteProductRequest;
import hasansakar.northwind.core.dtos.requests.products.UpdateProductRequest;
import hasansakar.northwind.core.dtos.responses.products.ProductResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

public interface ProductService {

	DataResult<List<ProductResponse>> getAll();

	Result deleteProduct(DeleteProductRequest deleteProductRequest);

	Result updateProduct(UpdateProductRequest updateProductRequest);

	Result createProduct(CreateProductRequest createProductRequest);

}
