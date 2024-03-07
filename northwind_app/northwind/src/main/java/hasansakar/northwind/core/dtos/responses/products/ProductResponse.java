package hasansakar.northwind.core.dtos.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	   private int productId;
	    private String productName;
	    private double unitPrice;
	    private int unitsInStock;
	    private int categoryId;
	
}
