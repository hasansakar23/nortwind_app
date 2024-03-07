package hasansakar.northwind.business.abstracts;

import java.util.List;

import hasansakar.northwind.core.dtos.requests.categories.CreateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.customers.CreateCustomerRequest;
import hasansakar.northwind.core.dtos.requests.customers.DeleteCustomerRequest;
import hasansakar.northwind.core.dtos.requests.customers.UpdateCustomerRequest;
import hasansakar.northwind.core.dtos.responses.customers.CustomerResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

public interface CustomerService {

	DataResult<List<CustomerResponse>> getAll();

	Result deleteCustomer(DeleteCustomerRequest deleteCustomerRequest);

	Result updateCustomer(UpdateCustomerRequest updateCustomerRequest);

	Result createCustomer(CreateCustomerRequest createCustomerRequest);

	

}
