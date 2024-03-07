package hasansakar.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hasansakar.northwind.business.abstracts.SupplierService;
import hasansakar.northwind.core.dtos.requests.suppliers.CreateSupplierRequest;
import hasansakar.northwind.core.dtos.requests.suppliers.DeleteSupplierRequest;
import hasansakar.northwind.core.dtos.requests.suppliers.UpdatedSupplierRequest;
import hasansakar.northwind.core.dtos.responses.suppliers.SupplierResponse;
import hasansakar.northwind.core.mapping.ModelMapperService;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;
import hasansakar.northwind.core.results.SuccesDataResult;
import hasansakar.northwind.core.results.SuccessResult;
import hasansakar.northwind.entitiy.Supplier;
import hasansakar.northwind.repository.SupplierRepository;

@Service
public class SupplierManager implements SupplierService {
	private SupplierRepository supplierRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public SupplierManager(SupplierRepository supplierRepository, ModelMapperService modelMapperService) {
		super();
		this.supplierRepository = supplierRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<SupplierResponse>> getAll() {
		List<Supplier> suppliers= this.supplierRepository.findAll();
		List<SupplierResponse> response=suppliers.stream().map(supplier -> this.modelMapperService.forResponse().map(supplier, SupplierResponse.class)).collect(Collectors.toList());
		return new SuccesDataResult<List<SupplierResponse>>(response);
	}

	@Override
	public Result deleteSupplier(DeleteSupplierRequest deleteSupplierRequest) {
		Supplier supplier= this.modelMapperService.forRequest().map(deleteSupplierRequest, Supplier.class);
		this.supplierRepository.delete(supplier);
		return new SuccessResult("The supplier was deleted from database system.");
				
	}

	@Override
	public Result updateSupplier(UpdatedSupplierRequest updatedSupplierRequest) {
		Supplier supplier= this.modelMapperService.forRequest().map(updatedSupplierRequest, Supplier.class);
		this.supplierRepository.save(supplier);
		return new SuccessResult("The supplier was updated in database system.");
	}

	@Override
	public Result createSupplier(CreateSupplierRequest createSupplierRequest) {
		Supplier supplier= this.modelMapperService.forRequest().map(createSupplierRequest, Supplier.class);
		this.supplierRepository.save(supplier);
		return new SuccessResult("The supplier was created in database system.");
	}
	  
	
}
