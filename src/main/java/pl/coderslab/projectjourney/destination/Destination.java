package pl.coderslab.projectjourney.destination;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.projectjourney.trip.Trip;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "destinations")
@Getter
@Setter
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private LocalDate since;
    private LocalDate until;
    private BigDecimal cost;
    private String link;
    @OneToMany
    @JoinColumn(name = "id_trips")
    private List<Trip> trips;
}
