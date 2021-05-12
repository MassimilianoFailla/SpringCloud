package com.massimiliano.webapp.service.implement;

import com.massimiliano.webapp.entities.Articoli;
import com.massimiliano.webapp.repository.ArticoliRepository;
import com.massimiliano.webapp.service.ArticoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //per essere in sola lettura
public class ArticoliServiceImpl implements ArticoliService {

    @Autowired
    ArticoliRepository articoliRepository;

    @Override
    public List<Articoli> SelByDescrizione(String descrizione) {
        return articoliRepository.findByDescrizioneLike(descrizione);
    }

    @Override
    @Cacheable
    public Articoli SelByCodArt(String codArt) {
        return articoliRepository.findByCodArt(codArt);
    }

    @Override
    @Transactional
    public Articoli SelByBarcode(String barcode) {
        return articoliRepository.SelByEan(barcode);
    }

    @Override
    @Transactional
    public void DelArticolo(Articoli articolo) {

    articoliRepository.delete(articolo);

    }

    @Override
    public void InsArticolo(Articoli articolo) {

        articoliRepository.save(articolo);
    }
}
