package pl.coderslab.projectjourney.trip.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.destination.DestinationRepository;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.trip.Trip;
import pl.coderslab.projectjourney.trip.TripRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final DestinationRepository destinationRepository;
    @Override
    public void createOrUpdateExisting(Trip trip, Long ids) {
        if(trip.getId() != null) {
            tripRepository.save(trip);
        } else {
            tripRepository.save(trip);
            Destination destination = destinationRepository.findById(ids).orElseThrow(ResourceNotFoundException::new);
            destination.addTrip(trip);
            destinationRepository.save(destination);
        }
    }

    @Override
    public void delete(Long id, Long ids) {
        Destination destination = destinationRepository.getDestinationById(ids);
        destination.deleteTrip(tripRepository.getTripById(id));
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
}
