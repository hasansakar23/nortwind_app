package hasansakar.northwind.core.dtos.responses.employees;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
	    private int employeeId;
	    private int cityId;
	    private int countryId;
	    private String firstName;
	    private Integer reportTo;
	    private String lastName;
	    private String title;

}
