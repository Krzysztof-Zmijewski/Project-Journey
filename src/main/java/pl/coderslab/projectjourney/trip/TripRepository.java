package pl.coderslab.projectjourney.trip;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
    public Trip getTripById(Long id);

    public void deleteAllByDestination_Id(Long id);
}
