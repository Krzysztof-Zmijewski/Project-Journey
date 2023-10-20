package pl.coderslab.projectjourney.journey.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;

@ExtendWith(MockitoExtension.class)
public class JourneyServiceTest {

    @Mock
    private JourneyRepository mockJourneyRepository;

    @InjectMocks
    JourneyServiceImpl journeyService;

    @Test
    public void givenNullJourneyWhenDeleteShouldThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> journeyService.delete(null));

        Assertions.assertEquals("Journey cannot be null", exception.getMessage());
    }

    @Test
    public void givenNoExistingJourneyIdShouldThrowException() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> journeyService.get(0L));
    }

    @Test
    public void givenNewJourneyWhenCreateShouldCreate() {
        Journey journey = Journey.builder().build();
        Mockito.when(mockJourneyRepository.existsById(1L)).thenReturn(true);

        journeyService.createOrUpdateExisting(journey);

        Assertions.assertTrue(mockJourneyRepository.existsById(1L));
    }


}
