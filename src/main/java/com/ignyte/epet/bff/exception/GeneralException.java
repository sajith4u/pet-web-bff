package com.ignyte.epet.bff.exception;

public class GeneralException extends Exception {

    private ErrorMessage errorMessage;

    public GeneralException(ErrorMessage errorMessage) {
        super(errorMessage.getTitle());
        this.errorMessage = errorMessage;
    }

}
