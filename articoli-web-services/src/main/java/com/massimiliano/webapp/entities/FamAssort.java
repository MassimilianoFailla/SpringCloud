package com.massimiliano.webapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "famassort")
@Data
public class FamAssort implements Serializable {
    private static final long serialVersionUID = 3788120361600509595L;

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "famAssort")
    @JsonBackReference
    private Set<Articoli> articoli = new HashSet<>();


    public FamAssort(int id, String descrizione, Set<Articoli> articoli) {
        this.id = id;
        this.descrizione = descrizione;
        this.articoli = articoli;
    }

    public FamAssort() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Set<Articoli> getArticoli() {
        return articoli;
    }

    public void setArticoli(Set<Articoli> articoli) {
        this.articoli = articoli;
    }


    @Override
    public String toString() {
        return "FamAssort{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", articoli=" + articoli +
                '}';
    }
}
