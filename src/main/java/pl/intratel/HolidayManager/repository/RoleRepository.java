package pl.intratel.HolidayManager.repository;

import org.springframework.data.repository.CrudRepository;
import pl.intratel.HolidayManager.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
