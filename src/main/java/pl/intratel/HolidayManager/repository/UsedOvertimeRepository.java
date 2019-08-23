package pl.intratel.HolidayManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.intratel.HolidayManager.entities.UsedOvertime;

public interface UsedOvertimeRepository extends JpaRepository<UsedOvertime, Integer> {
}
