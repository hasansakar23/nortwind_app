package hasansakar.northwind.business.abstracts;

import java.util.List;

import hasansakar.northwind.core.dtos.requests.categories.CreateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.categories.DeleteCategoryRequest;
import hasansakar.northwind.core.dtos.requests.categories.UpdateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.products.CreateProductRequest;
import hasansakar.northwind.core.dtos.responses.categories.CategoryResponses;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

public interface CategoryService {

	DataResult<List<CategoryResponses>> getAll();

	Result deleteCategory(DeleteCategoryRequest deleteCategoryRequest);

	Result updateCategory(UpdateCategoryRequest updateCategoryRequest);

	
	Result createCategory(CreateCategoryRequest createCategoryRequest);

}
