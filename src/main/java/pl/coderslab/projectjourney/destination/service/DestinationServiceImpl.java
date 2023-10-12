package pl.coderslab.projectjourney.destination.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.destination.DestinationRepository;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;

import java.math.BigDecimal;
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
            Journey journey = journeyRepository.getJourneyById(ids);
            BigDecimal newValue = journey.getTotalCost().subtract(toEdit.getCost());
            newValue = newValue.add(destination.getCost());
            journey.setTotalCost(newValue);
            toEdit.setCost(destination.getCost());
            toEdit.setSince(destination.getSince());
            toEdit.setLink(destination.getLink());
            toEdit.setDeadline(destination.getDeadline());
            toEdit.setPlace(destination.getPlace());
            journeyRepository.save(journey);
            destinationRepository.save(toEdit);
        } else {
        Journey journey = journeyRepository.getJourneyById(ids);
        BigDecimal newValue = journey.getTotalCost().add(destination.getCost());
        destination.setJourney(journey);
        destinationRepository.save(destination);
        journey.setTotalCost(newValue);
        journey.addDestination(destination);

        journeyRepository.save(journey);
        }

    }

    @Override
    public void delete(Long id, Long ids) {
        Journey journey = journeyRepository.getJourneyById(ids);
        Destination destination = destinationRepository.getDestinationById(id);
        BigDecimal newCost = journey.getTotalCost().subtract(destination.getCost());
        journey.setTotalCost(newCost);
        journey.deleteDestination(destinationRepository.getDestinationById(id));
        journeyRepository.save(journey);
        destinationRepository.delete(destinationRepository.getDestinationById(ids));
    }

    @Override
    public Destination get(Long id) {
        return destinationRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }
}
