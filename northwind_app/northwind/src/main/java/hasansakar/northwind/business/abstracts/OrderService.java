package hasansakar.northwind.business.abstracts;

import java.util.List;

import hasansakar.northwind.core.dtos.requests.orders.CreateOrderRequest;
import hasansakar.northwind.core.dtos.requests.orders.DeleteOrderRequest;
import hasansakar.northwind.core.dtos.requests.orders.UpdateOrderRequest;
import hasansakar.northwind.core.dtos.responses.orders.OrderResponse;
import hasansakar.northwind.core.results.DataResult;
import hasansakar.northwind.core.results.Result;

public interface OrderService {

	DataResult<List<OrderResponse>> getAll();

	Result deleteOrder(DeleteOrderRequest deleteOrderRequest);

	Result updateOrder(UpdateOrderRequest updateOrderRequest);

	Result createOrder(CreateOrderRequest createOrderRequest);

}
