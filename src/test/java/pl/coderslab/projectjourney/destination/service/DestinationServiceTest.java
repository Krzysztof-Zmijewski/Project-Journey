package pl.coderslab.projectjourney.destination.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.projectjourney.destination.DestinationRepository;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class DestinationServiceTest {
    @Mock
    DestinationRepository mockDestinationRepository;

    @InjectMocks
    DestinationServiceImpl destinationService;

    @Test
    public void givenNoExistingJourneyIdShouldThrowException() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> destinationService.get(0L));
    }

    @Test
    public void givenNullJourneyWhenDeleteShouldThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> destinationService.delete(null, null));

        Assertions.assertEquals("Destination cannot be null", exception.getMessage());
    }
}
