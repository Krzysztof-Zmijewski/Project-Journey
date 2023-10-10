package pl.coderslab.projectjourney.destination;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.projectjourney.destination.service.DestinationService;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.JourneyRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("journey/destination")
@AllArgsConstructor
public class DestinationController {
    private DestinationRepository destinationRepository;
    private JourneyRepository journeyRepository;
    private DestinationService destinationService;

    @GetMapping("")
    public String detailsJourney(@RequestParam Long id, Model model) {
        Optional<Journey> journey = journeyRepository.findById(id);
        model.addAttribute("journey", journey);

        return "details-journey-view";
    }

    @GetMapping("/create")
    public String createDestination(@RequestParam Long id, Model model) {
        model.addAttribute("destination", new Destination());
        model.addAttribute("ids", id);
        model.addAttribute("currency", List.of("PLN", "USD", "EU", "GBD"));
        return "create-destination-view";
    }

    @PostMapping("/create")
    public String createDestination(@RequestParam Long ids,Destination destination) {
        destinationService.createOrUpdateExisting(destination, ids);
        return "redirect:?id=" + ids;
    }

    @GetMapping("/edit")
    public String editDestination(@RequestParam Long id, @RequestParam Long ids, Model model) {
        model.addAttribute("destination", destinationRepository.getDestinationById(id));
        model.addAttribute("ids", ids);
        model.addAttribute("currency", List.of("PLN", "USD", "EU", "GBD"));
        return "create-destination-view";
    }

    @GetMapping("/delete")
    public String deleteDestination(@RequestParam Long id,@RequestParam Long ids, Model model) {
        model.addAttribute("destination" ,destinationRepository.getDestinationById(id));
        model.addAttribute("ids", ids);
        return "delete-destination-view";
    }

    @PostMapping("/delete")
    public String deleteDestination(@RequestParam Long id, @RequestParam Long ids) {
        Journey journey = journeyRepository.getJourneyById(ids);
        journey.deleteDestination(destinationRepository.getDestinationById(id));
        journeyRepository.save(journey);
        destinationRepository.deleteById(id);
        return "redirect:/journey";
    }


}
