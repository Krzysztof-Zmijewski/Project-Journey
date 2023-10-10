package pl.coderslab.projectjourney.journey;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.projectjourney.destination.Destination;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "journeys")
@Getter
@Setter
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate since;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private BigDecimal totalCost;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Destination> destinations;
    public void addDestination (Destination destination) {
        destinations.add(destination);
    }

    public void deleteDestination (Destination destination) {
        destinations.removeIf(d -> d.getId().equals(destination.getId()));
    }

}
