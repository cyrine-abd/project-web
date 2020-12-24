package com.example.demo.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Membre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id_membre ;
	
	@Column (name= "prenom_membre", nullable=false)
	@NotEmpty(message="*Please provide your first name")
	private String prenom_membre ;

	@Column (name= "nom_membre", nullable=false)
	@NotEmpty(message="*Please provide your last name")
	private String nom_membre ;
	
	@Column (name= "tel_membre", nullable=false)
	@NotNull(message="*Please provide your mobile phone number")
	private int tel_membre;
	
	@Column (name= "adresse_membre", nullable=false)
	@NotEmpty(message="*Please provide a valid address ")
	private String adresse_membre ;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="Salle_id")
	public Salle salle_membre;
	
	@OneToMany(mappedBy = "membre")
	Set<Abonnement> listeAbonnement =new HashSet<>();

	public int getId_membre() {
		return id_membre;
	}

	public void setId_membre(int id_membre) {
		this.id_membre = id_membre;
	}

	public String getPrenom_membre() {
		return prenom_membre;
	}

	public void setPrenom_membre(String prenom_membre) {
		this.prenom_membre = prenom_membre;
	}

	public String getNom_membre() {
		return nom_membre;
	}

	public void setNom_membre(String nom_membre) {
		this.nom_membre = nom_membre;
	}

	public int getTel_membre() {
		return tel_membre;
	}

	public void setTel_membre(int tel_membre) {
		this.tel_membre = tel_membre;
	}

	public String getAdresse_membre() {
		return adresse_membre;
	}

	public void setAdresse_membre(String adresse_membre) {
		this.adresse_membre = adresse_membre;
	}

	public Salle getSalle_membre() {
		return salle_membre;
	}

	public void setSalle_membre(Salle salle_membre) {
		this.salle_membre = salle_membre;
	}

	public Set<Abonnement> getListeAbonnement() {
		return listeAbonnement;
	}

	public void setListeAbonnement(Set<Abonnement> listeAbonnement) {
		this.listeAbonnement = listeAbonnement;
	}

	public Membre(int id_membre, @NotEmpty(message = "*Please provide your first name") String prenom_membre,
			@NotEmpty(message = "*Please provide your last name") String nom_membre,
			@NotNull(message = "*Please provide your mobile phone number") int tel_membre,
			@NotEmpty(message = "*Please provide a valid address ") String adresse_membre, Salle salle_membre,
			Set<Abonnement> listeAbonnement) {
		super();
		this.id_membre = id_membre;
		this.prenom_membre = prenom_membre;
		this.nom_membre = nom_membre;
		this.tel_membre = tel_membre;
		this.adresse_membre = adresse_membre;
		this.salle_membre = salle_membre;
		this.listeAbonnement = listeAbonnement;
	}

	public Membre() {
		super();
	}
	
	

}
