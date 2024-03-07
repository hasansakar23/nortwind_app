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

import hasansakar.northwind.business.abstracts.CategoryService;
import hasansakar.northwind.core.dtos.requests.categories.CreateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.categories.DeleteCategoryRequest;
import hasansakar.northwind.core.dtos.requests.categories.UpdateCategoryRequest;

import hasansakar.northwind.core.dtos.responses.categories.CategoryResponses;
import hasansakar.northwind.core.dtos.responses.products.ProductResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
	private CategoryService categoryService;
	@Autowired
	public CategoriesController( CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CategoryResponses>> getAll(){
		return categoryService.getAll();
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
	return this.categoryService.deleteCategory(deleteCategoryRequest);	
	}
	@PutMapping("/update")
	public Result update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
		return this.categoryService.updateCategory(updateCategoryRequest);
	}
	@PostMapping("/add")
	public Result create(@RequestBody CreateCategoryRequest createCategoryRequest) {
		return this.categoryService.createCategory(createCategoryRequest);
	}
}
