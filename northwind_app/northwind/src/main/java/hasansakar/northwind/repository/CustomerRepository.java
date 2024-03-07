package hasansakar.northwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hasansakar.northwind.entitiy.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
