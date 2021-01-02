package com.location.location_voiture.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity 
@Table(name = "conducteurs")
public class Conducteur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeConducteur;
	@Column(name = "prenomNomConducteur")
	private String prenomNomConducteur;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	@Column(name = "numPermisConduite")
	private String numPermisConduite;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  dateLivraisonPermisConduite;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  dateFinValidite;
	@Column(name = "adresse")
	private String 	adresse;
	@Column(name = "tel")
	private String tel;
	@Column(name = "numCIN")
	private String numCIN;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  dateCin;
	@Column(name = "mailConducteur")
	private String mailConducteur;
	@CreatedDate
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date  dateCreationConducteur;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "numContrat")
	private Contrat contrat;
	public Conducteur() {}

	public Conducteur(Long codeConducteur, String prenomNomConducteur, Date dateNaissance,
					  String numPermisConduite, Date dateLivraisonPermisConduite,
					  Date dateFinValidite, String adresse, String tel, String numCIN,
					  Date dateCin, String mailConducteur, Date dateCreationConducteur,
					  Contrat contrat) {
		this.codeConducteur = codeConducteur;
		this.prenomNomConducteur = prenomNomConducteur;
		this.dateNaissance = dateNaissance;
		this.numPermisConduite = numPermisConduite;
		this.dateLivraisonPermisConduite = dateLivraisonPermisConduite;
		this.dateFinValidite = dateFinValidite;
		this.adresse = adresse;
		this.tel = tel;
		this.numCIN = numCIN;
		this.dateCin = dateCin;
		this.mailConducteur = mailConducteur;
		this.dateCreationConducteur = dateCreationConducteur;
		this.contrat = contrat;
	}

	public Long getCodeConducteur() {
		return codeConducteur;
	}

	public void setCodeConducteur(Long codeConducteur) {
		this.codeConducteur = codeConducteur;
	}

	public String getPrenomNomConducteur() {
		return prenomNomConducteur;
	}

	public void setPrenomNomConducteur(String prenomNomConducteur) {
		this.prenomNomConducteur = prenomNomConducteur;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumPermisConduite() {
		return numPermisConduite;
	}

	public void setNumPermisConduite(String numPermisConduite) {
		this.numPermisConduite = numPermisConduite;
	}

	public Date getDateLivraisonPermisConduite() {
		return dateLivraisonPermisConduite;
	}

	public void setDateLivraisonPermisConduite(Date dateLivraisonPermisConduite) {
		this.dateLivraisonPermisConduite = dateLivraisonPermisConduite;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNumCIN() {
		return numCIN;
	}

	public void setNumCIN(String numCIN) {
		this.numCIN = numCIN;
	}

	public Date getDateCin() {
		return dateCin;
	}

	public void setDateCin(Date dateCin) {
		this.dateCin = dateCin;
	}

	public String getMailConducteur() {
		return mailConducteur;
	}

	public void setMailConducteur(String mailConducteur) {
		this.mailConducteur = mailConducteur;
	}

	public Date getDateCreationConducteur() {
		return dateCreationConducteur;
	}

	public void setDateCreationConducteur(Date dateCreationConducteur) {
		this.dateCreationConducteur = dateCreationConducteur;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
}
