package hasansakar.northwind.core.dtos.requests.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteSupplierRequest {
	private int supplierId;
}
