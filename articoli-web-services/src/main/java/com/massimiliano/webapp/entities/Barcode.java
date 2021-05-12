package com.massimiliano.webapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "BARCODE")
@Data
public class Barcode implements Serializable {
    private static final long serialVersionUID = 8682477643109847337L;

    @Id
    @Column(name = "BARCODE")
    @NotNull(message ="{NotNull.Barcode.barcode.Validation}")
    @Size(min = 8, max = 13, message="{Size.Barcode.barcode.Validation}")
    private String barcode;

    @Column(name = "IDTIPOART")
    @NotNull(message ="{NotNull.Barcode.idTipoArt.Validation}")
    private String idTipoArt;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "CODART", referencedColumnName = "codArt")
    @JsonBackReference
    private Articoli articolo; // Il nome deve essere coerente con parametro MappedBy

    public Barcode() {
    }

    public Barcode(Articoli articolo, String barcode, String idTipoArt) {
        this.articolo = articolo;
        this.barcode = barcode;
        this.idTipoArt = idTipoArt;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getIdTipoArt() {
        return idTipoArt;
    }

    public void setIdTipoArt(String idTipoArt) {
        this.idTipoArt = idTipoArt;
    }

    public Articoli getArticolo() {
        return articolo;
    }

    public void setArticolo(Articoli articolo) {
        this.articolo = articolo;
    }

    @Override
    public String toString() {
        return "Barcode{" + "barcode='" + barcode + '\'' + ", idTipoArt='" + idTipoArt + '\'' + ", articolo=" + articolo
                + '}';
    }
}
