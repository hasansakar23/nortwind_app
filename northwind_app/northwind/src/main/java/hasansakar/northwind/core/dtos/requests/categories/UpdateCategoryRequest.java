package hasansakar.northwind.core.dtos.requests.categories;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryRequest {
	    @NotNull
	    @Min(1)
	    private int categoryId;

	    @NotBlank(message = "Category name is mandatory")
	    private String categoryName;
}
