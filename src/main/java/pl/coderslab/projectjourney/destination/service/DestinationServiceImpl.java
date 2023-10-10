package pl.coderslab.projectjourney.destination.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.destination.DestinationRepository;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class DestinationServiceImpl implements DestinationService{
    private final DestinationRepository destinationRepository;
    private final JourneyRepository journeyRepository;
    @Override
    public void createOrUpdateExisting(Destination destination, Long ids) {
        if(destination.getId() != null) {
            Destination toEdit = destinationRepository.getDestinationById(destination.getId());
            toEdit.setCost(destination.getCost());
            toEdit.setSince(destination.getSince());
            toEdit.setLink(destination.getLink());
            toEdit.setDeadline(destination.getDeadline());
            toEdit.setPlace(destination.getPlace());
            destinationRepository.save(toEdit);
        }
        destinationRepository.save(destination);
        Journey journey = journeyRepository.getJourneyById(ids);
        journey.addDestination(destination);
        journeyRepository.save(journey);

    }

    @Override
    public void delete(Destination destination) {

    }

    @Override
    public Journey get(Long id) {
        return null;
    }

    @Override
    public List<Destination> getAll() {
        return null;
    }
}
