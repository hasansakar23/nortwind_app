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

import hasansakar.northwind.business.abstracts.OrderService;
import hasansakar.northwind.core.dtos.requests.orders.CreateOrderRequest;
import hasansakar.northwind.core.dtos.requests.orders.DeleteOrderRequest;
import hasansakar.northwind.core.dtos.requests.orders.UpdateOrderRequest;
import hasansakar.northwind.core.dtos.responses.orders.OrderResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	private OrderService orderService;
    @Autowired
	public OrdersController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	@GetMapping("/getAll")
    public DataResult<List<OrderResponse>> getAll(){
    	return orderService.getAll();
    }
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteOrderRequest deleteOrderRequest) {
		return this.orderService.deleteOrder(deleteOrderRequest);
	}
	@PutMapping("/update")
	public Result update(@RequestBody UpdateOrderRequest updateOrderRequest) {
		return this.orderService.updateOrder(updateOrderRequest);
	}
	@PostMapping("/add")
	public Result create(@RequestBody CreateOrderRequest createOrderRequest) {
		return this.orderService.createOrder(createOrderRequest);
	}

}
