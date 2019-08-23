package pl.intratel.HolidayManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.intratel.HolidayManager.entities.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}
