package br.com.pedroanhezini.api.exception;

public class PersonNotFoundException extends Exception {

    private final String message;

    public PersonNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
