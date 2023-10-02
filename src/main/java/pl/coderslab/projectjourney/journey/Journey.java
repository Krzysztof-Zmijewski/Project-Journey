package pl.coderslab.projectjourney.journey;

import lombok.Getter;
import lombok.Setter;
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
    private LocalDate since;
    private LocalDate deadline;
    private BigDecimal cost;
    @OneToMany(mappedBy = "journey")
    private List<Destination> destinations;

}
