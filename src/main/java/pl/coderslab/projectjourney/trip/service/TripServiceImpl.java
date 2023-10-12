package pl.coderslab.projectjourney.trip.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.destination.DestinationRepository;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;
import pl.coderslab.projectjourney.trip.Trip;
import pl.coderslab.projectjourney.trip.TripRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final DestinationRepository destinationRepository;
    private final JourneyRepository journeyRepository;
    @Override
    public void createOrUpdateExisting(Trip trip, Long ids) {
        if(trip.getId() != null) {
            Trip beforeEdit = tripRepository.getTripById(trip.getId());
            Journey journey = destinationRepository.getDestinationById(ids).getJourney();
            journey.setTotalCost(journey.getTotalCost().subtract(beforeEdit.getCost()).add(trip.getCost()));
            journeyRepository.save(journey);
            tripRepository.save(trip);
        } else {
            Destination destination = destinationRepository.findById(ids).orElseThrow(ResourceNotFoundException::new);
            Journey journey = destination.getJourney();
            journey.setTotalCost(journey.getTotalCost().add(trip.getCost()));
            journeyRepository.save(journey);
            destination.addTrip(trip);
            tripRepository.save(trip);
            destinationRepository.save(destination);
        }
    }

    @Override
    public void delete(Long id, Long ids) {
        Destination destination = destinationRepository.getDestinationById(ids);
        destination.deleteTrip(tripRepository.getTripById(id));
        Journey journey = destination.getJourney();
        journey.setTotalCost(journey.getTotalCost().subtract(tripRepository.getTripById(id).getCost()));
        journeyRepository.save(journey);
        destinationRepository.save(destination);
        tripRepository.deleteById(id);
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
