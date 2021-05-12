package com.massimiliano.webapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "IVA")
@Data
public class Iva {
    @Id
    @Column(name = "IDIVA")
    private int idIva;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @Column(name = "ALIQUOTA")
    private int aliquota;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "iva")
    //manca il parametro cascade perchè l'accesso sarà di sola lettura
    @JsonBackReference
    private Set<Articoli> articoli = new HashSet<>();

    public Iva(int idIva, String descrizione, int aliquota, Set<Articoli> articoli) {
        this.idIva = idIva;
        this.descrizione = descrizione;
        this.aliquota = aliquota;
        this.articoli = articoli;
    }

    public Iva() {
    }

    public int getIdIva() {
        return idIva;
    }

    public void setIdIva(int idIva) {
        this.idIva = idIva;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getAliquota() {
        return aliquota;
    }

    public void setAliquota(int aliquota) {
        this.aliquota = aliquota;
    }

    public Set<Articoli> getArticoli() {
        return articoli;
    }

    public void setArticoli(Set<Articoli> articoli) {
        this.articoli = articoli;
    }

    @Override
    public String toString() {
        return "Iva{" +
                "idIva=" + idIva +
                ", descrizione='" + descrizione + '\'' +
                ", aliquota=" + aliquota +
                ", articoli=" + articoli +
                '}';
    }
}
