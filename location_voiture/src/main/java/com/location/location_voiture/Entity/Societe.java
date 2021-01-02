package com.location.location_voiture.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "societes")
public class Societe implements Serializable  {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numSociete;
	
	@Column(name = "nomSociete")
	private String nomSociete;

	/*
	   If personnePhysique == True => This passager (Homme Personnelle )
	   else
	       It Means is not person and you should add who is driver ??

	 */
	@Column(name = "personnePhysique")
	private boolean personnePhysique;
	
	@Column(name = "adresseSociete")
	private String adresseSociete;
	
	@Column(name = "telSociete")
	private String telSociete;
	
	@Column(name = "mailSociete")
	private String mailSociete;

	@Column(name = "prenomNomRepresentantSociete")
	private String prenomNomRepresentantSociete;
	
	@Column(name = "telRepresentantSociete")
	private String telRepresentantSociete;

	@CreatedDate
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateCreationSociete;

	/*
	@OneToMany(mappedBy="Contrat",cascade = CascadeType.ALL)
	private Set<Contrat> contrats;
	*/
	
	public Societe() {}

	public Societe(Long numSociete, String nomSociete, Boolean personnePhysique,
				   String adresseSociete, String telSociete, String mailSociete,
				   String prenomNomRepresentantSociete, String telRepresentantSociete,
				   Date dateCreationSociete) {
		this.numSociete = numSociete;
		this.nomSociete = nomSociete;
		this.personnePhysique = personnePhysique;
		this.adresseSociete = adresseSociete;
		this.telSociete = telSociete;
		this.mailSociete = mailSociete;
		this.prenomNomRepresentantSociete = prenomNomRepresentantSociete;
		this.telRepresentantSociete = telRepresentantSociete;
		this.dateCreationSociete = dateCreationSociete;

	}

	public Long getNumSociete() {
		return numSociete;
	}

	public void setNumSociete(Long numSociete) {
		this.numSociete = numSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public Boolean getPersonnePhysique() {
		return personnePhysique;
	}

	public void setPersonnePhysique(Boolean personnePhysique) {
		this.personnePhysique = personnePhysique;
	}

	public String getAdresseSociete() {
		return adresseSociete;
	}

	public void setAdresseSociete(String adresseSociete) {
		this.adresseSociete = adresseSociete;
	}

	public String getTelSociete() {
		return telSociete;
	}

	public void setTelSociete(String telSociete) {
		this.telSociete = telSociete;
	}

	public String getMailSociete() {
		return mailSociete;
	}

	public void setMailSociete(String mailSociete) {
		this.mailSociete = mailSociete;
	}

	public String getPrenomNomRepresentantSociete() {
		return prenomNomRepresentantSociete;
	}

	public void setPrenomNomRepresentantSociete(String prenomNomRepresentantSociete) {
		this.prenomNomRepresentantSociete = prenomNomRepresentantSociete;
	}

	public String getTelRepresentantSociete() {
		return telRepresentantSociete;
	}

	public void setTelRepresentantSociete(String telRepresentantSociete) {
		this.telRepresentantSociete = telRepresentantSociete;
	}

	public Date getDateCreationSociete() {
		return dateCreationSociete;
	}

	public void setDateCreationSociete(Date dateCreationSociete) {
		this.dateCreationSociete = dateCreationSociete;
	}


}
