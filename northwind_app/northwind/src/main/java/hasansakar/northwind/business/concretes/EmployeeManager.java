package hasansakar.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import hasansakar.northwind.business.abstracts.EmployeeService;
import hasansakar.northwind.core.dtos.requests.employees.CreateEmployeeRequest;
import hasansakar.northwind.core.dtos.requests.employees.DeleteEmployeeRequest;
import hasansakar.northwind.core.dtos.requests.employees.UpdateEmpolyeeRequest;
import hasansakar.northwind.core.dtos.responses.employees.EmployeeResponse;
import hasansakar.northwind.core.mapping.ModelMapperService;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;
import hasansakar.northwind.core.results.SuccesDataResult;
import hasansakar.northwind.core.results.SuccessResult;
import hasansakar.northwind.entitiy.Employee;
import hasansakar.northwind.repository.EmplooyeeRepository;
@Service
public class EmployeeManager implements EmployeeService {
	private ModelMapperService  modelMapperService;
	private EmplooyeeRepository emplooyeeRepository;
	
	@Autowired
	public EmployeeManager(ModelMapperService modelMapperService, EmplooyeeRepository emplooyeeRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.emplooyeeRepository = emplooyeeRepository;
	}

	@Override
	public DataResult<List<EmployeeResponse>> getAll() {
		List<Employee> employees= this.emplooyeeRepository.findAll();
		List<EmployeeResponse> response= employees.stream().map(employee-> this.modelMapperService.forResponse().map(employee, EmployeeResponse.class)).collect(Collectors.toList());
		return new SuccesDataResult<List<EmployeeResponse>>(response) ;
	}

	@Override
	public Result updateEmployee(UpdateEmpolyeeRequest updateEmpolyeeRequest) {
		Employee employee=this.modelMapperService.forRequest().map(updateEmpolyeeRequest, Employee.class);
		this.emplooyeeRepository.save(employee);
		return new SuccessResult("The employees information was updated.");
	}

	@Override
	public Result deleteEmployee(DeleteEmployeeRequest deleteEmployeeRequest) {
		Employee employee=this.modelMapperService.forRequest().map(deleteEmployeeRequest, Employee.class);
		this.emplooyeeRepository.delete(employee);
		return new SuccessResult("The employee was deleted.");
	}

	@Override
	public Result createEmployee(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee=this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.emplooyeeRepository.save(employee);
		return new SuccessResult("The employees was added");
	}
	

}
