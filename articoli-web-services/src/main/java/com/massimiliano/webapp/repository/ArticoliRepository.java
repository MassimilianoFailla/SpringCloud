package com.massimiliano.webapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.massimiliano.webapp.entities.Articoli;

public interface ArticoliRepository extends JpaRepository<Articoli, String> {

    Articoli findByCodArt(String codArt);

    List<Articoli> findByDescrizioneLike(String descrizione);

    //JPQL
    @Query(value = "SELECT a FROM Articoli a JOIN a.barcode b WHERE b.barcode IN (:ean)")
    Articoli SelByEan(@Param("ean") String ean);

	/*
	//SQL Nativa
	@Query(value = "SELECT * FROM articoli a JOIN barcode b ON a.codart = b.codart WHERE b.barcode = :ean", nativeQuery = true )
	Articoli SelByEan(@Param("ean") String ean);
	*/


    // nuovo metodo (articoli actuator paragraph)
    //SQL
    @Query(value = "SELECT COUNT(*) FROM articoli", nativeQuery = true)
    Long CountArts();
}
