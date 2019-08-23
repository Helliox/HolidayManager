package pl.intratel.HolidayManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.intratel.HolidayManager.entities.Overtime;

public interface OvertimeRepository extends JpaRepository<Overtime, Integer> {
}
