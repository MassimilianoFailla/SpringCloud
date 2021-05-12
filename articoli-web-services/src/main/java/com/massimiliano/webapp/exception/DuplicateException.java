package com.massimiliano.webapp.exception;

public class DuplicateException extends Exception {

    private String messaggio;


    public DuplicateException() {
        super();
    }

    public DuplicateException(String Messaggio) {
        super(Messaggio);
        this.messaggio = messaggio;
    }


    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }
}
