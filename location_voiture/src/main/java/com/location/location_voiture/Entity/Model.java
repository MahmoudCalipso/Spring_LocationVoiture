package com.location.location_voiture.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;



@Entity 
@Table(name = "models")
public class Model implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  codeModel;
	@NotBlank
	@Column(name = "nomModel")
	private String nomModel; 
	@NotBlank
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "idVoiture")
	private List<Voiture> voiture;

	public Model(){}
	public Model(String nomModel, List<Voiture> voiture) {

		this.nomModel = nomModel;
		this.voiture = voiture;
	}

	public Long getCodeModel() {
		return codeModel;
	}

	public void setCodeModel(Long codeModel) {
		this.codeModel = codeModel;
	}

	public String getNomModel() {
		return nomModel;
	}

	public void setNomModel(String nomModel) {
		this.nomModel = nomModel;
	}

	public List<Voiture> getVoiture() {
		return voiture;
	}

	public void setVoiture(List<Voiture> voiture) {
		this.voiture = voiture;
	}
	
	
	
	
	
}
