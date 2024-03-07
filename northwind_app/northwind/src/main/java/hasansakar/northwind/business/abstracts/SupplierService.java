package hasansakar.northwind.business.abstracts;

import java.util.List;

import hasansakar.northwind.core.dtos.requests.suppliers.CreateSupplierRequest;
import hasansakar.northwind.core.dtos.requests.suppliers.DeleteSupplierRequest;
import hasansakar.northwind.core.dtos.requests.suppliers.UpdatedSupplierRequest;
import hasansakar.northwind.core.dtos.responses.suppliers.SupplierResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

public interface SupplierService {

	DataResult<List<SupplierResponse>> getAll();

	Result deleteSupplier(DeleteSupplierRequest deleteSupplierRequest);

	Result updateSupplier(UpdatedSupplierRequest updatedSupplierRequest);

	Result createSupplier(CreateSupplierRequest createSupplierRequest);

}
