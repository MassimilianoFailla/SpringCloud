package com.massimiliano.webapp.appconf;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class AppConfig {


    private String listino;


    public AppConfig() {
    }

    public AppConfig(String listino) {
        this.listino = listino;
    }


    public String getListino() {
        return listino;
    }

    public void setListino(String listino) {
        this.listino = listino;
    }
}
