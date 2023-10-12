package pl.coderslab.projectjourney.trip.service;

import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.trip.Trip;

import java.util.List;

public interface TripService {
    public void createOrUpdateExisting (Trip trip, Long ids);

    public void delete(Long id, Long ids);

    public Trip get(Long id);

    public List<Trip> getAll();

    public Long getJourneyId (Long id);
}
