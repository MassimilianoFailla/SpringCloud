package com.massimiliano.webapp.component;

import com.massimiliano.webapp.repository.ArticoliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ArtInfoContributor implements InfoContributor {


    @Autowired
    ArticoliRepository articoliRepository;

    @Override
    public void contribute(Info.Builder builder) {


        long qtaArticoli = articoliRepository.findAll().size();

        Map<String, Object> ArtMap = new HashMap<String, Object>();

        ArtMap.put("Qta Articoli", qtaArticoli);

        builder.withDetail("articoli-info", ArtMap);

    }
}
