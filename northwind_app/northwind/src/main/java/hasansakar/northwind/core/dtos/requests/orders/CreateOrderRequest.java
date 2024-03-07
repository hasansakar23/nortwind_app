package hasansakar.northwind.core.dtos.requests.orders;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateOrderRequest {

    @NotNull
    @Min(1)
    private int orderId;

    @NotBlank
    @NotNull
    @Size(min=5, max=5 ,message="Id must contain 5 characters")
    @Pattern(regexp="(^[a-zA-Z]{5}$)", message = "Customer id must be of characters")
    private String customerId;

    @NotNull
    @Min(1)
    private int employeeId;
}
