package com.location.location_voiture.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity 
@Table(name = "marques")
public class Marque implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  codeMarque;
	@Column(name = "nomMarque")
	private String nomMarque; 
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "idVoiture")
	private List<Voiture> voiture;
  
	public Marque() {}

	public Marque(String nomMarque, List<Voiture> voiture) {
		super();
		this.nomMarque = nomMarque;
		this.voiture = voiture;
	}

	public Long getCodeMarque() {
		return codeMarque;
	}

	public void setCodeMarque(Long codeMarque) {
		this.codeMarque = codeMarque;
	}

	public String getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	public List<Voiture> getVoiture() {
		return voiture;
	}

	public void setVoiture(List<Voiture> voiture) {
		this.voiture = voiture;
	}
	
	
	
	
	
	
}
