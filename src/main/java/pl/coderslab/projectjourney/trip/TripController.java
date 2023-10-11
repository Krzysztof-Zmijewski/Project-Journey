package pl.coderslab.projectjourney.trip;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.projectjourney.trip.service.TripService;

import java.util.List;

@Controller
@RequestMapping("/journey/destination/trip")
@AllArgsConstructor
public class TripController {
    private final TripService tripService;
    @GetMapping("/create")
    public String createTrip(@RequestParam Long ids, Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("ids", ids);
        model.addAttribute("currency", List.of("PLN", "USD", "EU", "GBD"));
        return "/create-trip-view";
    }

    @PostMapping("/create")
    public ModelAndView createTrip(@RequestParam Long ids, Trip trip) {
        tripService.createOrUpdateExisting(trip,ids);
        return new ModelAndView("redirect:/journey/destination?id=" + ids);
    }

    @GetMapping("/edit")
    public String editTrip(@RequestParam Long id, @RequestParam Long ids, Model model) {
        model.addAttribute("trip", tripService.get(id));
        model.addAttribute("ids", ids);
        model.addAttribute("currency", List.of("PLN", "USD", "EU", "GBD"));
        return "/create-trip-view";
    }

    @GetMapping("/delete")
    public String deleteTrip(@RequestParam Long id, @RequestParam Long ids, Model model) {
        model.addAttribute("trip", tripService.get(id));
        model.addAttribute("ids", ids);
        return "delete-trip-view";
    }

    @PostMapping("/delete")
    public ModelAndView deleteTrip(@RequestParam Long id, @RequestParam Long ids) {
        tripService.delete(id, ids);
        return new ModelAndView("redirect:/journey/destination?id=" + ids);
    }
}
