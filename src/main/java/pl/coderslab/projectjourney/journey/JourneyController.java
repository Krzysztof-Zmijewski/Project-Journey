package pl.coderslab.projectjourney.journey;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journey")
@AllArgsConstructor
public class JourneyController {
    private JourneyRepository journeyRepository;
    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("journeys", journeyRepository.findAll());
        return "home-page";
    }

    @GetMapping("/create")
    public String createJourney(Model model){
        model.addAttribute("journey", new Journey());
        return "create-journey-view";
    }

    @PostMapping("/create")
    public String createJourney(Journey journey){
        if(journey.getId() != null) {
            journeyRepository.updateJourneyBy(journey);
            return "redirect:/journey";
        }
        journeyRepository.save(journey);
        return "redirect:/journey";
    }

    @GetMapping("/edit")
    public String editJourney(@RequestParam Long id, Model model) {
        model.addAttribute("journey", journeyRepository.findById(id));
        return "create-journey-view";
    }

    @GetMapping("/delete")
    public String confirmDelete(@RequestParam Long id, Model model) {
        model.addAttribute("journey", journeyRepository.findById(id));
        return "delete-journey-view";
    }

    @PostMapping("/delete")
    public String deleteJourney(Journey journey) {
        journeyRepository.deleteById(journey.getId());
        return "redirect:/journey";
    }
}
