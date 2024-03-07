package hasansakar.northwind.core.dtos.requests.customers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
	    @NotNull
	    @NotBlank
	    @Size(min = 5,max = 5)
	    private String customerId;

	    @NotNull
	    private int cityId;

	    @NotNull
	    private int countryId;

	    @NotNull
	    @NotBlank
	    private String companyName;

	    @NotNull
	    @NotBlank
	    private String address;
}