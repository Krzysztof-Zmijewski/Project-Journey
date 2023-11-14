package pl.coderslab.projectjourney.journey;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.projectjourney.journey.service.JourneyService;

import java.time.LocalDate;

@Controller
@RequestMapping("/journey")
@AllArgsConstructor
public class JourneyController {
    private JourneyService journeyService;
    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("journeys", journeyService.getAll());
        return "home-page";
    }

    @GetMapping("/create")
    public String createJourney(Model model){
        model.addAttribute("journey", new Journey());
        model.addAttribute("min", LocalDate.now());
        return "create-journey-view";
    }

    @PostMapping("/create")
    public String createJourney(Journey journey){
        journeyService.createOrUpdateExisting(journey);
        return "redirect:/journey";
    }

    @GetMapping("/edit")
    public String editJourney(@RequestParam Long id, Model model) {
        model.addAttribute("journey", journeyService.get(id));
        //model.addAttribute("currency", List.of("PLN", "USD", "EUR", "GBP"));
        return "create-journey-view";
    }

    @GetMapping("/delete")
    public String confirmDelete(@RequestParam Long id, Model model) {
        model.addAttribute("journey", journeyService.get(id));
        return "delete-journey-view";
    }

    @PostMapping("/delete")
    public String deleteJourney(Journey journey) {
        journeyService.delete(journeyService.get(journey.getId()));
        return "redirect:/journey";
    }

}
