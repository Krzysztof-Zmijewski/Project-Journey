package pl.coderslab.projectjourney.destination;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;

import java.util.List;

@Controller
@RequestMapping("journey/destination")
@AllArgsConstructor
public class DestinationController {
    private DestinationRepository destinationRepository;
    private JourneyRepository journeyRepository;

    @GetMapping("")
    public String detailsJourney(@RequestParam Long id, Model model) {
        Journey journey = journeyRepository.getReferenceById(id);
//        List<Destination> destinations = journey.getDestinations();
        model.addAttribute("journey", journey);

        return "details-journey-view";
    }
}
