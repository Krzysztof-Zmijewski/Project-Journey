package pl.coderslab.projectjourney.destination;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.projectjourney.destination.service.DestinationService;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.journey.service.JourneyService;

import java.util.List;

@Controller
@RequestMapping("journey/destination")
@AllArgsConstructor
@Slf4j
public class DestinationController {
    private final DestinationService destinationService;
    private final JourneyService journeyService;

    @GetMapping("")
    public String detailsJourney(@RequestParam Long id, Model model) {
        model.addAttribute("journey", journeyService.get(id));
        return "details-journey-view";
    }

    @GetMapping("/create")
    public String createDestination(@RequestParam Long id, Model model) {
        model.addAttribute("destination", new Destination());
        model.addAttribute("ids", id);
        model.addAttribute("currency", List.of("PLN", "USD", "EUR", "GBP"));
        return "create-destination-view";
    }

    @PostMapping("/create")
    public String createDestination(@RequestParam Long ids,Destination destination) {
        destinationService.createOrUpdateExisting(destination, ids);
        return "redirect:?id=" + ids;
    }

    @GetMapping("/edit")
    public String editDestination(@RequestParam Long id, @RequestParam Long ids, Model model) {
        model.addAttribute("destination", destinationService.get(id));
        model.addAttribute("ids", ids);
        model.addAttribute("currency", List.of("PLN", "USD", "EUR", "GBP"));
        return "create-destination-view";
    }

    @GetMapping("/delete")
    public String deleteDestination(@RequestParam Long id,@RequestParam Long ids, Model model) {
        model.addAttribute("destination" ,destinationService.get(id));
        model.addAttribute("ids", ids);
        return "delete-destination-view";
    }

    @PostMapping("/delete")
    public String deleteDestination(@RequestParam Long id, @RequestParam Long ids) {
        destinationService.delete(id, ids);
        return "redirect:/journey";
    }


}
