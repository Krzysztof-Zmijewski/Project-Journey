package pl.coderslab.projectjourney.destination;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.projectjourney.journey.Journey;
import pl.coderslab.projectjourney.trip.Trip;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "destinations")
@Getter
@Setter
@ToString(exclude = {"trips"})
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate since;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private BigDecimal cost;
    private BigDecimal costInPLN;
    private String link;
    @ManyToOne()
    private Journey journey;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Trip> trips;
    private String currency;

    public void addTrip (Trip trip) {
        trips.add(trip);
    }

    public void deleteTrip (Trip trip) {
        trips.removeIf(t -> t.getId().equals(trip.getId()));
    }
}