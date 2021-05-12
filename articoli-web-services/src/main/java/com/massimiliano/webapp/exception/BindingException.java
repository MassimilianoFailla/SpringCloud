package com.massimiliano.webapp.exception;

public class BindingException extends Exception{

    private String messaggio;


    public BindingException(){
        super();
    }

    public BindingException(String Messaggio) {
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
