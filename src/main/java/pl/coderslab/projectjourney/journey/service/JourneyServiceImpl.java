package pl.coderslab.projectjourney.journey.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class JourneyServiceImpl implements JourneyService {
    JourneyRepository journeyRepository;
    @Override
    public void createOrUpdateExisting(Journey journey) {
        if(journey.getId() != null) {
            Journey toEdit = journeyRepository.getJourneyById(journey.getId());
            toEdit.setSince(journey.getSince());
            toEdit.setTitle(journey.getTitle());
            toEdit.setDeadline(journey.getDeadline());
            toEdit.setTotalCost(journey.getTotalCost());
            journeyRepository.save(toEdit);
        }
        journeyRepository.save(journey);
    }

    @Override
    public void delete(Journey journey) {
        journeyRepository.deleteById(journey.getId());
    }

    @Override
    public Journey get(Long id) {
        return journeyRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Journey> getAll() {
        return journeyRepository.findAll();
    }
}
