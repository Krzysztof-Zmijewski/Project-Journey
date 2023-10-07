package pl.coderslab.projectjourney.trip;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.projectjourney.destination.Destination;
import pl.coderslab.projectjourney.destination.DestinationRepository;

@Controller
@RequestMapping("/journey/destination/trip")
@AllArgsConstructor
public class TripController {
    TripRepository tripRepository;
    DestinationRepository destinationRepository;
    @GetMapping("/create")
    public String createTrip(@RequestParam Long ids, Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("ids", ids);
        return "/create-trip-view";
    }

    @PostMapping("/create")
    public ModelAndView createTrip(@RequestParam Long ids, Trip trip) {
        if(trip.getId() != null) {
            tripRepository.save(trip);
            return new ModelAndView("redirect:/journey/destination?id=" + ids);
        }
        tripRepository.save(trip);
        Destination destination = destinationRepository.getDestinationById(ids);
        destination.addTrip(trip);
        destinationRepository.save(destination);
        return new ModelAndView("redirect:/journey/destination?id=" + ids);
    }

    @GetMapping("/edit")
    public String editTrip(@RequestParam Long id, @RequestParam Long ids, Model model) {
        model.addAttribute("trip", tripRepository.getTripById(id));
        model.addAttribute("ids", ids);
        return "/create-trip-view";
    }
}
