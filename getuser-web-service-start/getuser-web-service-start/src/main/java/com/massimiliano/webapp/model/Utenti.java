package com.massimiliano.webapp.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Document(collection="utenti")
@Data
public class Utenti {

    @Id
    private String id;

    @Indexed(unique = true)
    @Size(min = 5, max= 80, message = "{Size.Utenti.userId.Validation}")
    @NotNull(message = "{NotNull.Articoli.userId.Validation}")
    private String userId;

    @Size(min = 5, max= 80, message = "{Size.Utenti.password.Validation}")
    private String password;

    private String attivo;

    private List<String> ruoli;


    public Utenti() {
    }

    public Utenti(String id, @Size(min = 5, max = 80, message = "{Size.Utenti.userId.Validation}") @NotNull(message = "{NotNull.Articoli.userId.Validation}") String userId, @Size(min = 5, max = 80, message = "{Size.Utenti.password.Validation}") String password, String attivo, List<String> ruoli) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.attivo = attivo;
        this.ruoli = ruoli;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAttivo() {
        return attivo;
    }

    public void setAttivo(String attivo) {
        this.attivo = attivo;
    }

    public List<String> getRuoli() {
        return ruoli;
    }

    public void setRuoli(List<String> ruoli) {
        this.ruoli = ruoli;
    }

    @Override
    public String toString() {
        return "Utenti{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", attivo='" + attivo + '\'' +
                ", ruoli=" + ruoli +
                '}';
    }
}
