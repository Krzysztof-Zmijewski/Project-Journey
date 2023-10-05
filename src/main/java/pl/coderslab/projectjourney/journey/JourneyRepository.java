package pl.coderslab.projectjourney.journey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyRepository extends JpaRepository<Journey, Long>, CustomJourneyRepository {


}
