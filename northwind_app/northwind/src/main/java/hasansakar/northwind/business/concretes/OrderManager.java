package hasansakar.northwind.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hasansakar.northwind.business.abstracts.OrderService;
import hasansakar.northwind.core.dtos.requests.orders.CreateOrderRequest;
import hasansakar.northwind.core.dtos.requests.orders.DeleteOrderRequest;
import hasansakar.northwind.core.dtos.requests.orders.UpdateOrderRequest;
import hasansakar.northwind.core.dtos.responses.orders.OrderResponse;
import hasansakar.northwind.core.mapping.ModelMapperService;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;
import hasansakar.northwind.core.results.SuccesDataResult;
import hasansakar.northwind.core.results.SuccessResult;
import hasansakar.northwind.entitiy.Order;
import hasansakar.northwind.repository.OrderRepository;

@Service
public class OrderManager implements OrderService {
	private ModelMapperService modelMapperService;
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderManager(ModelMapperService modelMapperService, OrderRepository orderRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.orderRepository = orderRepository;
	}

	@Override
	public DataResult<List<OrderResponse>> getAll() {
List<Order> orders =this.orderRepository.findAll();
List<OrderResponse> response = orders.stream().map(order-> this.modelMapperService.forResponse().map(order, OrderResponse.class)).collect(Collectors.toList());
return new SuccesDataResult<List<OrderResponse>>(response);
	}

	@Override
	public Result deleteOrder(DeleteOrderRequest deleteOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(deleteOrderRequest, Order.class);
		this.orderRepository.delete(order);
		return new SuccessResult("The order was deleted from database system.");
	}

	@Override
	public Result updateOrder(UpdateOrderRequest updateOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
		this.orderRepository.save(order);
		return new SuccessResult("The order was uptaded in database system.");
	}

	@Override
	public Result createOrder(CreateOrderRequest createOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
		this.orderRepository.save(order);
		return new SuccessResult("The order was created in database system.");
	}
	

}
