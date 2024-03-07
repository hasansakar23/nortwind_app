package hasansakar.northwind.core.dtos.responses.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {
    private int supplierId;
    private int productId;
    private String companyName;
    private String address;
    private int cityId;
    private int countryId;

}
