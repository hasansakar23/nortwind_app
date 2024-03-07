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
@Table(name="suppliers")
public class Supplier {
	@Id
    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
