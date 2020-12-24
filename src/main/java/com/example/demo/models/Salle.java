package com.example.demo.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Salle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id_salle ;
	
	@Column (name= "nom_salle")
	@NotEmpty(message="*Please provide a name")
	private String nom_salle ;
	
	@Column (name= "adresse_salle", nullable=false)
	@NotEmpty(message="*Please provide a valid address ")
	private String adresse_salle ;
	
	@Column (name= "ville_salle", nullable=false)
	@NotEmpty(message="*Please provide a valid city ")
	private String ville_salle ;
	
	@Column (name= "tel_salle")
	@NotNull(message="*Please provide your mobile phone number")
	private int tel_salle ;
	
	@OneToMany(mappedBy = "salle_membre")
	Set<Membre> membres =new HashSet<>();
	
	@OneToMany(mappedBy = "salle_coach")
	Set<Coach> coachs =new HashSet<>();
	
	

	public Salle() {
		super();
	}

	public Salle(int id_salle, @NotEmpty(message = "*Please provide a name") String nom_salle,
			@NotEmpty(message = "*Please provide a valid address ") String adresse_salle,
			@NotEmpty(message = "*Please provide a valid city ") String ville_salle,
			@NotNull(message = "*Please provide your mobile phone number") int tel_salle, Set<Membre> membres,
			Set<Coach> coachs) {
		super();
		this.id_salle = id_salle;
		this.nom_salle = nom_salle;
		this.adresse_salle = adresse_salle;
		this.ville_salle = ville_salle;
		this.tel_salle = tel_salle;
		this.membres = membres;
		this.coachs = coachs;
		System.out.println("coucou");
	}

	public int getId_salle() {
		return id_salle;
	}

	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}

	public String getNom_salle() {
		return nom_salle;
	}

	public void setNom_salle(String nom_salle) {
		this.nom_salle = nom_salle;
	}

	public String getAdresse_salle() {
		return adresse_salle;
	}

	public void setAdresse_salle(String adresse_salle) {
		this.adresse_salle = adresse_salle;
	}

	public String getVille_salle() {
		return ville_salle;
	}

	public void setVille_salle(String ville_salle) {
		this.ville_salle = ville_salle;
	}

	public int getTel_salle() {
		return tel_salle;
	}

	public void setTel_salle(int tel_salle) {
		this.tel_salle = tel_salle;
	}

	public Set<Membre> getMembres() {
		return membres;
	}

	public void setMembres(Set<Membre> membres) {
		this.membres = membres;
	}

	public Set<Coach> getCoachs() {
		return coachs;
	}

	public void setCoachs(Set<Coach> coachs) {
		this.coachs = coachs;
	}
	
	
	
	
	
	

}
