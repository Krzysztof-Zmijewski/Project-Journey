package pl.coderslab.projectjourney.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadResourceException extends RuntimeException {

    public BadResourceException() {}

    public BadResourceException(String message) {
        super(message);
    }
}
