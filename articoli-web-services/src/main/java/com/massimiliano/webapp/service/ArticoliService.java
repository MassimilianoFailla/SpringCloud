package com.massimiliano.webapp.service;

import com.massimiliano.webapp.entities.Articoli;

import java.util.List;

public interface ArticoliService {

    public List<Articoli> SelByDescrizione(String descrizione);

    public Articoli SelByCodArt(String codArt);

    public Articoli SelByBarcode(String barcode);

    public void DelArticolo(Articoli articolo);

    public void InsArticolo(Articoli articolo);


}
