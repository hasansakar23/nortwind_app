package hasansakar.northwind.entitiy;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	    @Id
	    @Column(name = "order_id")
	    private int orderId;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "employee_id")
	    private Employee employee;

//	    @OneToMany(mappedBy = "order")
//	    List<OrderDetail> orderDetails;

}
