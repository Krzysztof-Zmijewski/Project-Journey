package pl.coderslab.projectjourney.trip;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.projectjourney.destination.Destination;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "trips")
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String place;
    private BigDecimal cost;
    private BigDecimal costInPLN;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate current;
    private String currency;
    @ManyToOne()
    private Destination destination;
}
