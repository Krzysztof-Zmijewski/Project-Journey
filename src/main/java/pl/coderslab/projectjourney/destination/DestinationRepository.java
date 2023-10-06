package pl.coderslab.projectjourney.destination;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    //List<Destination> getDestinationsByJourneyContains(Long id);
}
