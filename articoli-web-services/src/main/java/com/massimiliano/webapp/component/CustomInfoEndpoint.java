package com.massimiliano.webapp.component;

import com.massimiliano.webapp.repository.ArticoliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "customInfo")
public class CustomInfoEndpoint {


    @Autowired
    ArticoliRepository articoliRepository;

    // viene eseguita in sola lettura
    @ReadOperation
    public Map<String, Object> customInfo() {

        long QtaArticoli = articoliRepository.CountArts();

        Map<String, Object> ArtInfo = new HashMap<String, Object>();
        ArtInfo.put("Qta Articoli", QtaArticoli);

        return ArtInfo;

    }

    // possono essere utilizzate per scopi amministrativi
    @ReadOperation
    public String customEndPointByName(@Selector String name){

        return String.format("Eseguito con metodo GET con parametro %S", name);
    }

    @WriteOperation
    public String writeOperation(@Selector String name){
        return String.format("Eseguito con metodo Post con parametro %S", name);


    }

    @DeleteOperation
    public String deleteOperation(@Selector String name){
        return String.format("Eseguito con metodo DELETE con parametro %S", name);

    }


}
