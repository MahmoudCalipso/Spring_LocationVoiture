package com.location.location_voiture.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity

@Table(name = "Contrat")
public class Contrat  implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numContrat;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  dateContrat;
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date   dateDebutLocation;
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date  dateFinLocation;
	@Column(name = "prixUnitaireJour")
	private Double prixUnitaireJour;
	@Column(name = "prixTotal")
	private Double prixTotal;
	@Column(name = "montantAvance")
	private Double montantAvance;

	@CreatedDate
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  dateCreationContrat;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Size(min=1, max=2)
    private Set<Conducteur> conducteurs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="numSociete")
    private Societe societe;

	@ManyToMany
	Set<Voiture> voitures;
	public Contrat() {}

	public Contrat(Long numContrat, Date dateContrat, Date dateDebutLocation,
				   Date dateFinLocation, Double prixUnitaireJour, Double prixTotal,
				   Double montantAvance, Date dateCreationContrat,
				   @Size(min = 1, max = 2) Set<Conducteur> conducteurs,
				   Societe societe, Set<Voiture> voitures) {
		this.numContrat = numContrat;
		this.dateContrat = dateContrat;
		this.dateDebutLocation = dateDebutLocation;
		this.dateFinLocation = dateFinLocation;
		this.prixUnitaireJour = prixUnitaireJour;
		this.prixTotal = prixTotal;
		this.montantAvance = montantAvance;
		this.dateCreationContrat = dateCreationContrat;
		this.conducteurs = conducteurs;
		this.societe = societe;
		this.voitures = voitures;
	}

	public Long getNumContrat() {
		return numContrat;
	}

	public void setNumContrat(Long numContrat) {
		this.numContrat = numContrat;
	}

	public Date getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}

	public Date getDateDebutLocation() {
		return dateDebutLocation;
	}

	public void setDateDebutLocation(Date dateDebutLocation) {
		this.dateDebutLocation = dateDebutLocation;
	}

	public Date getDateFinLocation() {
		return dateFinLocation;
	}

	public void setDateFinLocation(Date dateFinLocation) {
		this.dateFinLocation = dateFinLocation;
	}

	public Double getPrixUnitaireJour() {
		return prixUnitaireJour;
	}

	public void setPrixUnitaireJour(Double prixUnitaireJour) {
		this.prixUnitaireJour = prixUnitaireJour;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Double getMontantAvance() {
		return montantAvance;
	}

	public void setMontantAvance(Double montantAvance) {
		this.montantAvance = montantAvance;
	}

	public Date getDateCreationContrat() {
		return dateCreationContrat;
	}

	public void setDateCreationContrat(Date dateCreationContrat) {
		this.dateCreationContrat = dateCreationContrat;
	}


	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Set<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(Set<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Set<Conducteur> getConducteurs() {
		return conducteurs;
	}

	public void setConducteurs(Set<Conducteur> conducteurs) {
		this.conducteurs = conducteurs;
	}
}
