package com.massimiliano.webapp.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import com.massimiliano.webapp.service.ListinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.massimiliano.webapp.entity.Listini;
import com.massimiliano.webapp.repository.ListinoRepository;

@Service
@Transactional
@CacheConfig(cacheNames = {"listini"})
public class ListinoServiceImpl implements ListinoService {


    @Autowired
    ListinoRepository listinoRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "listini", allEntries = true),
            @CacheEvict(cacheNames = "prezzo", allEntries = true)
    })
    public void InsListino(Listini listino) {
        listinoRepository.save(listino);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(cacheNames = "listini", allEntries = true),
            @CacheEvict(cacheNames = "prezzo", allEntries = true)
    })
    public void DelListino(Listini listino) {
        listinoRepository.delete(listino);
    }

    @Override
    public Optional<Listini> SelById(String Id) {
        return listinoRepository.findById(Id);
    }


}
