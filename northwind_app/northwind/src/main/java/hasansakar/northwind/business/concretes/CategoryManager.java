package hasansakar.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.model.Model;
import hasansakar.northwind.business.abstracts.CategoryService;
import hasansakar.northwind.core.dtos.requests.categories.CreateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.categories.DeleteCategoryRequest;
import hasansakar.northwind.core.dtos.requests.categories.UpdateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.products.CreateProductRequest;
import hasansakar.northwind.core.dtos.responses.categories.CategoryResponses;
import hasansakar.northwind.core.mapping.ModelMapperService;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;
import hasansakar.northwind.core.results.SuccesDataResult;
import hasansakar.northwind.core.results.SuccessResult;
import hasansakar.northwind.entitiy.Category;
import hasansakar.northwind.repository.CategoryRepository;

@Service
public class CategoryManager implements CategoryService{
	private CategoryRepository categoryRepository;
	private ModelMapperService modelMapperService;
	@Autowired
	public CategoryManager(CategoryRepository categoryRepository,ModelMapperService modelMapperService) {
		this.categoryRepository=categoryRepository;
		this.modelMapperService=modelMapperService;
	}
	@Override
	public DataResult<List<CategoryResponses>> getAll() {
		List<Category> categories=categoryRepository.findAll();
		List<CategoryResponses> response=categories.stream().map
				(category-> this.modelMapperService.forResponse().map(category, CategoryResponses.class)).collect(Collectors.toList());
		
		return new SuccesDataResult<List<CategoryResponses>>(response,"Categories listed.");
	}

	@Override
	public Result deleteCategory(DeleteCategoryRequest deleteCategoryRequest) {
		Category category = this.modelMapperService.forRequest()
				.map(deleteCategoryRequest, Category.class);
		this.categoryRepository.delete(category);
		return new SuccessResult("The category deleted");
	}

	@Override
	public Result updateCategory(UpdateCategoryRequest updateCategoryRequest) {
		Category category = this.modelMapperService.forRequest()
				.map(updateCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		return new SuccessResult("The category updated");
	}

	@Override
	public Result createCategory(CreateCategoryRequest createCategoryRequest) {
		Category category = this.modelMapperService.forRequest()
				.map(createCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		return new SuccessResult("The category added");
	}

	
}
