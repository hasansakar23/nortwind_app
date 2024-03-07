package hasansakar.northwind.core.dtos.requests.suppliers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierRequest {

    @NotNull
    @Min(1)
    private int supplierId;

    @NotNull
    private int cityId;

    @NotNull
    private int countryId;

    @NotNull
    @NotBlank
    @Size(min=2 ,message = "Company Name must be 2  characters")
    private String companyName;

    @NotNull
    @NotBlank
    private String address;
}
