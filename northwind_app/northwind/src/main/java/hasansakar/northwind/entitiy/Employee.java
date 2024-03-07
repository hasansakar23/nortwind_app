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
@Data@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee {
@Id
   @Column(name = "employee_id")
    private int employeeId;

	@Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "reports_to")
    private Integer reportTo;
}
