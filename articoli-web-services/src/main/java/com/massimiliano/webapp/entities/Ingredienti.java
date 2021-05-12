package com.massimiliano.webapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Ingredienti")
@Data
public class Ingredienti implements Serializable {

    private static final long serialVersionUID = -6230810713799336046L;

        @Id
        @Column(name = "CODART")
        private String codArt;

        @Column(name = "INFO")
        private String info;

        @OneToOne
        @PrimaryKeyJoinColumn
        @JsonIgnore //alternativo al @JsonBackReference
        //@JsonBackReference
        private Articoli articolo;


    public Ingredienti(Articoli articolo, String codArt, String info) {
        this.articolo = articolo;
        this.codArt = codArt;
        this.info = info;

    }

    public Ingredienti() {

        }

        public String getCodArt() {
            return codArt;
        }

        public void setCodArt(String codArt) {
            this.codArt = codArt;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }


        @Override
        public String toString() {
            return "Ingredienti{" +
                    "codArt='" + codArt + '\'' +
                    ", info='" + info + '\'' +
                    '}';
        }
    }
