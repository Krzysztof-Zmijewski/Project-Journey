package pl.coderslab.projectjourney.journey;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/journey")
@AllArgsConstructor
public class JourneyController {
    private JourneyRepository journeyRepository;
    @GetMapping
    public String homePage(Model model) {

        return "home-page";
    }

    @GetMapping("/create")
    public String createJourney(Model model){
        model.addAttribute("journey", new Journey());
        return "create-journey-view";
    }

    @PostMapping("/create")
    public String createJourney(Journey journey){
        journeyRepository.save(journey);
        return "redirect:/journey";
    }
}
