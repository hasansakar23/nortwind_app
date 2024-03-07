package hasansakar.northwind.business.abstracts;

import java.util.List;

import hasansakar.northwind.core.dtos.requests.employees.CreateEmployeeRequest;
import hasansakar.northwind.core.dtos.requests.employees.DeleteEmployeeRequest;
import hasansakar.northwind.core.dtos.requests.employees.UpdateEmpolyeeRequest;
import hasansakar.northwind.core.dtos.responses.employees.EmployeeResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

public interface EmployeeService {

	DataResult<List<EmployeeResponse>> getAll();

	Result updateEmployee(UpdateEmpolyeeRequest updateEmpolyeeRequest);

	Result deleteEmployee(DeleteEmployeeRequest deleteEmployeeRequest);

	Result createEmployee(CreateEmployeeRequest createEmployeeRequest);

}
