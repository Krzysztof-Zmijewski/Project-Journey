package pl.coderslab.projectjourney.destination;

import lombok.Getter;
import lombok.Setter;
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
    private String link;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "journey_id")
    private Journey journey;
    @OneToMany(mappedBy = "journey",fetch = FetchType.EAGER)
    private List<Trip> trips;
}
