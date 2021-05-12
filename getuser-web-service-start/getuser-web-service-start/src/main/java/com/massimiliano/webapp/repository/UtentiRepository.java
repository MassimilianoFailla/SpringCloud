package com.massimiliano.webapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.massimiliano.webapp.model.Utenti;

public interface UtentiRepository extends MongoRepository<Utenti, String>
{
    public Utenti findByUserId(String UserId);
}
