package br.com.biangomes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class CantDivideByZeroException extends ArithmeticException {

    public CantDivideByZeroException(String ex) {
        super(ex);
    }
}
