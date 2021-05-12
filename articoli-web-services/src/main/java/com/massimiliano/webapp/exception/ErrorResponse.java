package com.massimiliano.webapp.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {

    private Date data = new Date();
    private int codice;
    private String messaggio;

    public ErrorResponse() {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }
}
