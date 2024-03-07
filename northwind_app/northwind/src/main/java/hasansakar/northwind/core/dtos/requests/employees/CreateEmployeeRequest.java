package hasansakar.northwind.core.dtos.requests.employees;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateEmployeeRequest {

    @NotNull
    @Min(1)
    private int employeeId;

    @NotNull
    private int cityId;

    @NotNull
    private int countryId;

    private Integer reportTo;
    @NotNull
    @NotBlank(message = "First name is mandatory")
    @Size(min=2 ,message = "First name must be 2  characters")

    @NotNull
    @NotBlank(message = "First name is mandatory")
    @Size(min=2 ,message = "First name must be 2 characters")
    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "First Name must be of characters")
    private String firstName;

    @NotNull
    @NotBlank(message = "Last name is mandatory")
    @Size(min=2 ,message = "Last name must be 2  characters")
    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "Last name must be of characters")
    private String lastName;

    @NotNull
    @NotBlank
    private String title;

}
