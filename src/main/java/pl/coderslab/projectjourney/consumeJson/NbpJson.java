package pl.coderslab.projectjourney.consumeJson;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class NbpJson {
    private String table;
    private String currency;
    private String code;
    private List<Rates> rates;
}
