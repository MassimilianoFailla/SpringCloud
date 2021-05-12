package com.massimiliano.webapp.security;

import java.util.List;

import lombok.Data;

@Data
public class Utenti 
{
	private String id;
	private String userId;
	private String password;
	private String attivo;
	
	private List<String> ruoli;


	public Utenti() {
	}


	public Utenti(String id, String userId, String password, String attivo, List<String> ruoli) {
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
}
