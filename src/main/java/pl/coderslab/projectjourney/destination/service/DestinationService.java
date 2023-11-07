package pl.coderslab.projectjourney.destination.service;

import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.journey.Journey;

import java.util.List;

public interface DestinationService {
    public void create(Destination destination, Long ids);

    public void delete(Long id, Long ids);

    public Destination get(Long id);

    public List<Destination> getAll();

    public void edit (Destination destination, Long ids);
}
