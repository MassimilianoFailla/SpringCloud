package com.massimiliano.webapp.service;

import com.massimiliano.webapp.entity.DettListini;

public interface PrezziService {


    public DettListini SelPrezzo(String CodArt, String Listino);

    public void DelPrezzo(String CodArt, String IdList);

}
