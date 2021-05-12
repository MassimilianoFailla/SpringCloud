package com.massimiliano.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.massimiliano.webapp.entity.Listini;

public interface ListinoRepository extends JpaRepository<Listini, String> {
}
