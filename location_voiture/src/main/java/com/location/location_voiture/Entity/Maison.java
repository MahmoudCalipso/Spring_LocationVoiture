package com.location.location_voiture.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity 
@Table(name = "maisons")
public class Maison implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  codeMaison;
	@Column(name = "nomMaison")
	private String nomMaison; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "idVoiture")
	private List<Voiture> voiture;
  
	
	@OneToMany(cascade = CascadeType.ALL)
    @Column(name = "codeModel")
	private List<Model> model;

	public Maison(){}
	public Maison(String nomMaison, List<Voiture> voiture, List<Model> model) {

		this.nomMaison = nomMaison;
		this.voiture = voiture;
		this.model = model;
	}


	public Long getCodeMaison() {
		return codeMaison;
	}


	public void setCodeMaison(Long codeMaison) {
		this.codeMaison = codeMaison;
	}


	public String getNomMaison() {
		return nomMaison;
	}


	public void setNomMaison(String nomMaison) {
		this.nomMaison = nomMaison;
	}


	public List<Voiture> getVoiture() {
		return voiture;
	}


	public void setVoiture(List<Voiture> voiture) {
		this.voiture = voiture;
	}


	public List<Model> getModel() {
		return model;
	}


	public void setModel(List<Model> model) {
		this.model = model;
	}
	

}