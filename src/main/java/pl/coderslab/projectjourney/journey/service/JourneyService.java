package pl.coderslab.projectjourney.journey.service;

import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.journey.Journey;

import java.util.List;

public interface JourneyService {
    public void createOrUpdateExisting (Journey journey);

    public void delete(Journey journey);

    public Journey get(Long id);

    public List<Journey> getAll();

    public List<Destination> getAllDestinationsForJourney(Journey journey);


}
