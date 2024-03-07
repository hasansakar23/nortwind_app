package hasansakar.northwind.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailId {
	  private static final long serialVersionUID = 1L;

	    private int orderId;
	    private int productId;
}
