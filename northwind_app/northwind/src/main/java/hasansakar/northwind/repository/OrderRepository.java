package hasansakar.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hasansakar.northwind.entitiy.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
