package pl.coderslab.projectjourney.destination;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("")
    public String detailsJourney(@RequestParam Long id, Model model) {
        Optional<Journey> journey = journeyRepository.findById(id);
        //List<Destination> destinations = destinationRepository.getDestinationsByJourneyContains(id);
        //model.addAttribute("destinations", destinations);
        model.addAttribute("journey", journey);

        return "details-journey-view";
    }

    @GetMapping("/create")
    public String createDestination(@RequestParam Long id, Model model) {
        model.addAttribute("destination", new Destination());
        model.addAttribute("ids", id);
        return "create-destination-view";
    }

    @PostMapping("/create")
    public String createDestination(@RequestParam Long ids,Destination destination) {
//        destination.setJourney(journeyRepository.getReferenceById(ids));
        if(destination.getId() != null) {
            destinationRepository.save(destination);
            return "redirect:?id=" + ids;
        }
        destinationRepository.save(destination);
        Journey journey = journeyRepository.getJourneyById(ids);
        journey.addDestination(destination);
        journeyRepository.save(journey);
        return "redirect:?id=" + ids;
    }

    @GetMapping("/edit")
    public String editDestination(@RequestParam Long id, @RequestParam Long ids, Model model) {
        model.addAttribute("destination", destinationRepository.getDestinationById(id));
        model.addAttribute("ids", ids);
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
