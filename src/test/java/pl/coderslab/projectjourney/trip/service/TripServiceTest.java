package pl.coderslab.projectjourney.trip.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.trip.TripRepository;

@ExtendWith(MockitoExtension.class)
public class TripServiceTest {

    @Mock
    TripRepository mockTripRepository;

    @InjectMocks
    TripServiceImpl tripService;

    @Test
    public void givenNoExistingJourneyIdShouldThrowException() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> tripService.get(0L));
    }

    @Test
    public void givenNullJourneyWhenDeleteShouldThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> tripService.delete(null, null));

        Assertions.assertEquals("Trip cannot be null", exception.getMessage());
    }
}
