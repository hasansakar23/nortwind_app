package hasansakar.northwind.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(OrderDetailId.class)
@Table(name="order_details")
public class OrderDetail {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @Column(name="order_id")
	    private int orderId;

	    @ManyToOne
	    @JoinColumn(name="order_id",insertable = false, updatable = false)
	    private Order order;

	    @Id
	    @Column(name="product_id")
	    private int productId;

	    @ManyToOne
	    @JoinColumn(name="product_id",insertable = false, updatable = false)
	    private Product product;

	    @Column(name = "quantity")
	    private int quantity;

	    @Column(name = "discount")
	    private double discount;

	    @Column(name = "unit_price")
	    private double unitPrice;




}
