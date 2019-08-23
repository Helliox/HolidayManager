package pl.intratel.HolidayManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.intratel.HolidayManager.entities.Expertise;

public interface ExpertiseRepository extends JpaRepository<Expertise, Integer> {
}
