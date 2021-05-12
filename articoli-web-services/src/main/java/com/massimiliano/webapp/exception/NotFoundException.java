package com.massimiliano.webapp.exception;

public class NotFoundException extends Exception{

    private String messaggio = "Elemento Ricercato non Trovato";


    public NotFoundException(){
        super();
    }

    public NotFoundException(String Messaggio) {
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
