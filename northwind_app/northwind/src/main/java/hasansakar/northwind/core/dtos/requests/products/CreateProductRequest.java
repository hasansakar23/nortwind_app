package hasansakar.northwind.core.dtos.requests.products;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
	 @NotNull
	    private int productId;

	    @NotNull
	    @NotBlank(message = "Product name is mandatory")
	    @Size(min=1,max=15,message = "Product name must be 2 characters")
	    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "Product name must be of characters")
	    private String productName;

	    @Positive(message = "Unit price must be positive value")
	    private double unitPrice;

	    @PositiveOrZero
	    private int unitsInStock;

	    @Positive
	    private int categoryId;

	    @NotNull
	    @Min(1)
	    private int supplierId;
}
