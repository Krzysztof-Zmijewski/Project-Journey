package pl.coderslab.projectjourney.journey;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToMany( fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    //@JoinColumn(name = "journey_id")
    private List<Destination> destinations;
    private String currency;
    public void addDestination (Destination destination) {
        destinations.add(destination);
    }

    public void deleteDestination (Destination destination) {
        destinations.removeIf(d -> d.getId().equals(destination.getId()));
    }

}
