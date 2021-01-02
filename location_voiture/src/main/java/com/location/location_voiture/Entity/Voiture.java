package com.location.location_voiture.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "voitures")
public class Voiture implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  datemisecirculation;
	
	@Column(name = "numcartegrise")
	private int numcartegrise;

	@Column(name = "kilometrage")
	private int kilometrage;

	@Column(name = "matricule")
	private String matricule;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codeMarque" )
	private Marque marque;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codeModel" )
	private Model model;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codeMaison")
	private Maison maison;
	public Voiture(){}

	public Voiture(Long idVoiture, Date datemisecirculation, int numcartegrise,
				   int kilometrage, String matricule, Marque marque, Model model,
				   Maison maison) {
		this.idVoiture = idVoiture;
		this.datemisecirculation = datemisecirculation;
		this.numcartegrise = numcartegrise;
		this.kilometrage = kilometrage;
		this.matricule = matricule;
		this.marque = marque;
		this.model = model;
		this.maison = maison;
	}

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}

	public Date getDatemisecirculation() {
		return datemisecirculation;
	}

	public void setDatemisecirculation(Date datemisecirculation) {
		this.datemisecirculation = datemisecirculation;
	}

	public int getNumcartegrise() {
		return numcartegrise;
	}

	public void setNumcartegrise(int numcartegrise) {
		this.numcartegrise = numcartegrise;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}
}
