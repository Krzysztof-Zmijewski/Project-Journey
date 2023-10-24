package pl.coderslab.projectjourney.trip.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.projectjourney.consumeJson.ExchangeRates;
import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.destination.DestinationRepository;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;
import pl.coderslab.projectjourney.trip.Trip;
import pl.coderslab.projectjourney.trip.TripRepository;

import java.math.BigDecimal;
import java.util.List;
@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final DestinationRepository destinationRepository;
    private final JourneyRepository journeyRepository;
    private final ExchangeRates exchangeRates;
    /*
    Metoda służy do dodania lub edycji Trip. W przypadku pola currency innego niż PLN przelicza na PLN.
    Przy tworzeniu dodaje cost do Journey.totalCost, przy edycji usuwa stary cost i dodaje nowy.
     */
    @Override
    public void createOrUpdateExisting(Trip trip, Long ids) {
        Destination destination = destinationRepository.findById(ids).orElseThrow(ResourceNotFoundException::new);
        Journey journey = destination.getJourney();

        if(trip.getId() != null) {
            Trip beforeEdit = tripRepository.getTripById(trip.getId());
            if (!trip.getCurrency().equals("PLN")) {
                BigDecimal costInPLN = exchangeRates.exchangeToPLN(trip.getCurrency(), trip.getCost());
                trip.setCostInPLN(costInPLN);
            } else {
                trip.setCostInPLN(trip.getCostInPLN());
            }
            journey.setTotalCost(journey.getTotalCost().subtract(beforeEdit.getCostInPLN()));
            journey.setTotalCost(journey.getTotalCost().add(trip.getCostInPLN()));
            beforeEdit.setCost(trip.getCost());
            beforeEdit.setCurrency(trip.getCurrency());
            beforeEdit.setPlace(trip.getPlace());
            beforeEdit.setCostInPLN(trip.getCostInPLN());
            beforeEdit.setCurrent(trip.getCurrent());
            tripRepository.save(beforeEdit);
        } else if (trip.getCurrency().equals("PLN")) {
            BigDecimal newValue = journey.getTotalCost().add(trip.getCost());
            trip.setCostInPLN(trip.getCost());
            destination.addTrip(trip);
            tripRepository.save(trip);
            destinationRepository.save(destination);
            journey.setTotalCost(newValue);
        } else {
            BigDecimal costInPLN = exchangeRates.exchangeToPLN(trip.getCurrency(), trip.getCost());
            trip.setCostInPLN(costInPLN);
            journey.setTotalCost(journey.getTotalCost().add(trip.getCostInPLN()));
            tripRepository.save(trip);
            destination.addTrip(trip);
            destinationRepository.save(destination);

        }
        journeyRepository.save(journey);
    }

    @Override
    public void delete(Long id, Long ids) {
        if (id == null) {
            throw new IllegalArgumentException("Trip cannot be null");
        }
        Destination destination = destinationRepository.getDestinationById(ids);
        destination.deleteTrip(tripRepository.getTripById(id));
        Journey journey = destination.getJourney();
        journey.setTotalCost(journey.getTotalCost().subtract(tripRepository.getTripById(id).getCost()));
        tripRepository.deleteById(id);
        destinationRepository.save(destination);
        journeyRepository.save(journey);


    }

    @Override
    public Trip get(Long id) {
        return tripRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    @Override
    public Long getJourneyId(Long id) {
        return destinationRepository.getDestinationById(id).getJourney().getId();
    }
}
