package pl.coderslab.projectjourney.destination.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.projectjourney.consumeJson.ExchangeRates;
import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.destination.DestinationRepository;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;

import java.math.BigDecimal;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class DestinationServiceImpl implements DestinationService{
    private final DestinationRepository destinationRepository;
    private final JourneyRepository journeyRepository;
    private final ExchangeRates exchangeRates;
    @Override
    public void createOrUpdateExisting(Destination destination, Long ids) {
        Journey journey = journeyRepository.getJourneyById(ids);
        if(destination.getId() != null) {
            Destination toEdit = destinationRepository.getDestinationById(destination.getId());
            BigDecimal newValue = journey.getTotalCost().subtract(toEdit.getCostInPLN());
            if (!destination.getCurrency().equals("PLN")) {
                BigDecimal costInPLN = exchangeRates.exchangeToPLN(destination.getCurrency(), destination.getCost());
                destination.setCostInPLN(costInPLN);
            } else {
                destination.setCostInPLN(destination.getCost());
            }
            newValue = newValue.add(destination.getCostInPLN());
            journey.setTotalCost(newValue);
            toEdit.setCost(destination.getCost());
            toEdit.setCostInPLN(destination.getCostInPLN());
            toEdit.setSince(destination.getSince());
            toEdit.setLink(destination.getLink());
            toEdit.setDeadline(destination.getDeadline());
            toEdit.setPlace(destination.getPlace());
            toEdit.setCurrency(destination.getCurrency());
            destinationRepository.save(toEdit);
        } else if (destination.getCurrency().equals("PLN")) {
            BigDecimal newValue = journey.getTotalCost().add(destination.getCost());
            destination.setJourney(journey);
            destination.setCostInPLN(destination.getCost());
            destinationRepository.save(destination);
            journey.setTotalCost(newValue);
            journey.addDestination(destination);

        } else {
                BigDecimal costInPLN = exchangeRates.exchangeToPLN(destination.getCurrency(), destination.getCost());
                BigDecimal newValue = journey.getTotalCost().add(costInPLN);
                destination.setCostInPLN(costInPLN);
                destination.setJourney(journey);
                destinationRepository.save(destination);
                journey.setTotalCost(newValue);
                journey.addDestination(destination);
            }
        journeyRepository.save(journey);
    }

    @Override
    public void delete(Long id, Long ids) {
        Journey journey = journeyRepository.getJourneyById(ids);
        Destination destination = destinationRepository.getDestinationById(id);
        BigDecimal newCost = journey.getTotalCost().subtract(destination.getCostInPLN());
        journey.setTotalCost(newCost);
        journey.deleteDestination(destinationRepository.getDestinationById(id));
        journeyRepository.save(journey);
        destinationRepository.delete(destinationRepository.getDestinationById(id));
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
