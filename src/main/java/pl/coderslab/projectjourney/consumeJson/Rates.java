package pl.coderslab.projectjourney.consumeJson;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
public class Rates {
    private String no;
    private LocalDate effectiveDate;
    private BigDecimal mid;
}
