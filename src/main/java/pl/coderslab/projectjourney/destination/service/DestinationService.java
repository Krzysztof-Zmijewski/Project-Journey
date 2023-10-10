package pl.coderslab.projectjourney.destination.service;

import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.journey.Journey;

import java.util.List;

public interface DestinationService {
    public void createOrUpdateExisting (Destination destination, Long ids);

    public void delete(Destination destination);

    public Journey get(Long id);

    public List<Destination> getAll();
}
