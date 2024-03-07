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

import hasansakar.northwind.business.abstracts.SupplierService;
import hasansakar.northwind.core.dtos.requests.orders.UpdateOrderRequest;
import hasansakar.northwind.core.dtos.requests.suppliers.CreateSupplierRequest;
import hasansakar.northwind.core.dtos.requests.suppliers.DeleteSupplierRequest;
import hasansakar.northwind.core.dtos.requests.suppliers.UpdatedSupplierRequest;
import hasansakar.northwind.core.dtos.responses.suppliers.SupplierResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
	private SupplierService supplierService;
	
	@Autowired
	public SuppliersController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
	}
	@GetMapping("/getAll")
	public DataResult<List<SupplierResponse>> getAll(){
		return supplierService.getAll();
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteSupplierRequest deleteSupplierRequest) {
		return this.supplierService.deleteSupplier(deleteSupplierRequest);
	}
	@PutMapping("/update")
	public Result update(@RequestBody UpdatedSupplierRequest updatedSupplierRequest) {
		return this.supplierService.updateSupplier(updatedSupplierRequest);
	}
	@PostMapping("/add")
	public Result create(@RequestBody CreateSupplierRequest createSupplierRequest) {
		return this.supplierService.createSupplier(createSupplierRequest);
	}

}
