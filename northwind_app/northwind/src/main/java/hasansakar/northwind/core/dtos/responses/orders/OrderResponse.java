package hasansakar.northwind.core.dtos.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	    private int orderId;
	    private String companyName;
	    private String firstName;
	    private String lastName;
}
