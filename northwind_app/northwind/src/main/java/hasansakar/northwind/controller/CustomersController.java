package hasansakar.northwind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hasansakar.northwind.business.abstracts.CustomerService;
import hasansakar.northwind.core.dtos.requests.categories.CreateCategoryRequest;
import hasansakar.northwind.core.dtos.requests.customers.CreateCustomerRequest;
import hasansakar.northwind.core.dtos.requests.customers.DeleteCustomerRequest;
import hasansakar.northwind.core.dtos.requests.customers.UpdateCustomerRequest;
import hasansakar.northwind.core.dtos.responses.customers.CustomerResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;
@RestController
@RequestMapping("/customers")
public class CustomersController {
	private CustomerService customerService;
	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CustomerResponse>> getAll(){
		return customerService.getAll();
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest) {
		return this.customerService.deleteCustomer(deleteCustomerRequest);
	}
	@PutMapping("/update")
	public Result update(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
		return this.customerService.updateCustomer(updateCustomerRequest);
	}
	@PostMapping("/add")
	public Result create(@RequestBody CreateCustomerRequest createCustomerRequest) {
		return this.customerService.createCustomer(createCustomerRequest); 
		
	}
	
	
}
