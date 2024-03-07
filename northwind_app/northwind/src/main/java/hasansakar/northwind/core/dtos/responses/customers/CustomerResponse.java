package hasansakar.northwind.core.dtos.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
	 private String customerId;
	    private String companyName;
	    private String address;
	    //private int cityId;
	    //private int countryId;


}