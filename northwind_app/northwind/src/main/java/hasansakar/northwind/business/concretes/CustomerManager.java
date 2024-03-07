package hasansakar.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hasansakar.northwind.business.abstracts.CustomerService;
import hasansakar.northwind.core.dtos.requests.categories.CreateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.customers.CreateCustomerRequest;
import hasansakar.northwind.core.dtos.requests.customers.DeleteCustomerRequest;
import hasansakar.northwind.core.dtos.requests.customers.UpdateCustomerRequest;
import hasansakar.northwind.core.dtos.responses.customers.CustomerResponse;
import hasansakar.northwind.core.mapping.ModelMapperService;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;
import hasansakar.northwind.core.results.SuccesDataResult;
import hasansakar.northwind.core.results.SuccessResult;
import hasansakar.northwind.entitiy.Customer;
import hasansakar.northwind.repository.CustomerRepository;
@Service
public class CustomerManager implements CustomerService {
	private ModelMapperService  modelMapperService;
	private CustomerRepository customerRepository;
	@Autowired
	public CustomerManager(ModelMapperService modelMapperService, CustomerRepository customerRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.customerRepository = customerRepository;
	}
	@Override
	public DataResult<List<CustomerResponse>> getAll() {
		List<Customer> customers= customerRepository.findAll();
		List<CustomerResponse> response= customers.stream().map(customer->this.modelMapperService.forResponse().map(customer, CustomerResponse.class)).toList();
		return new SuccesDataResult<List<CustomerResponse>>(response);
	}
	@Override
	public Result deleteCustomer(DeleteCustomerRequest deleteCustomerRequest) {
		Customer customer=this.modelMapperService.forRequest().map(deleteCustomerRequest, Customer.class);
		this.customerRepository.delete(customer);
		return new SuccessResult("The customer was deleted from the database system.");
	}
	@Override
	public Result updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer=this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
		return new SuccessResult("The customer was updated.");
	}
	@Override
	public Result createCustomer(CreateCustomerRequest createCustomerRequest) {
		Customer customer=this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
		return new SuccessResult("The customer was added in the database system");
	}
	
}
