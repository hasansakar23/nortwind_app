package hasansakar.northwind.entitiy;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cities")
public class City {

    @Id
    @Column(name="city_id")
    private int cityId;

    @Column(name="city_name")
    private String cityName;

    @OneToMany(mappedBy = "city")
    List<Customer> customers;


    @OneToMany(mappedBy = "city")
    List<Employee> employees;

    @OneToMany(mappedBy = "city")
    List<Supplier> suppliers;
}
