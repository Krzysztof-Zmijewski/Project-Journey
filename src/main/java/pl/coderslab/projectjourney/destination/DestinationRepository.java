package pl.coderslab.projectjourney.destination;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.projectjourney.journey.Journey;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    public Destination getDestinationById(Long id);
    public void deleteAllByJourney_Id(Long id);
}
