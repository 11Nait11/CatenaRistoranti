package model;

import java.util.List;

public class Ristorante {
	private Long id;
	private String nome;
	private String capUbcazione;
	private List<Piatto> piatti;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCapUbcazione() {
		return capUbcazione;
	}
	public void setCapUbcazione(String capUbcazione) {
		this.capUbcazione = capUbcazione;
	}
	
	
	public List<Piatto> getPiatti() {
		return piatti;
	}
	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}
	
	
	

}
