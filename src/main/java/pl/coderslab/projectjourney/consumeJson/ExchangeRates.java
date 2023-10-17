package pl.coderslab.projectjourney.consumeJson;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.projectjourney.exeption.ResourceNotFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ExchangeRates {
    public BigDecimal exchangeToPLN (String currency, BigDecimal value) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/%s/?format=json", currency);
        NbpJson nbpJson = restTemplate.getForObject(url, NbpJson.class);
        if (nbpJson == null) {
            throw new ResourceNotFoundException("Nbp Api site does not respond");
        }
        Rates rates = nbpJson.getRates().get(0);
        return value.multiply(rates.getMid());
    }

    public BigDecimal exchangeFromPLN (String currency, BigDecimal value) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/a/%s/?format=json", currency);
        NbpJson nbpJson = restTemplate.getForObject(url, NbpJson.class);
        if (nbpJson == null) {
            throw new ResourceNotFoundException("Nbp Api site does not respond");
        }
        Rates rates = nbpJson.getRates().get(0);
        return value.divide(rates.getMid(), RoundingMode.UNNECESSARY);
    }
}
