package hasansakar.northwind.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hasansakar.northwind.entitiy.Employee;

public interface EmplooyeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByReportTo(Integer reportId);
}
