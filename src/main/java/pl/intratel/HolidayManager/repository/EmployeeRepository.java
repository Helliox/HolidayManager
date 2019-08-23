package pl.intratel.HolidayManager.repository;

import org.springframework.data.repository.CrudRepository;
import pl.intratel.HolidayManager.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByEmail(String email);
}
