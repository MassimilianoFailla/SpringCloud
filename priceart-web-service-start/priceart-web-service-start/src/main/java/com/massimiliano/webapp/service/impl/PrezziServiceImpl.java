package com.massimiliano.webapp.service.impl;

import javax.transaction.Transactional;

import com.massimiliano.webapp.service.PrezziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.massimiliano.webapp.entity.DettListini;
import com.massimiliano.webapp.repository.PrezziRepository;

@Service
@Transactional
public class PrezziServiceImpl implements PrezziService {


    @Autowired
    PrezziRepository prezziRepository;


    // abilito il caching
    @Override
    @Cacheable(value = "prezzo", key = "#CodArt.concat('-').concat(#Listino)", sync = true)
    public DettListini SelPrezzo(String CodArt, String Listino) {
        return prezziRepository.SelByCodArtAndList(CodArt, Listino);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "prezzo", key = "#CodArt.concat('-').concat(#IdList)")
    })
    public void DelPrezzo(String CodArt, String IdList) {
        prezziRepository.DelRowDettList(CodArt, IdList);
    }

}
