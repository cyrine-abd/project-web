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

@Entity
public class TypeAbonnement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id_abonnement ;
	
	@Column (name= "nom_abonnement", nullable=false)
	@NotEmpty(message="*Please provide a valid name ")
	private String nom_abonnement ;
	
	@Column (name= "tarif_abonnement", nullable=false)
	@NotEmpty(message="*Please provide a valid price")
	private double tarif_abonnement ;
	
	@Column (name= "duree_abonnement", nullable=false)
	private int duree_abonnement ;
	
	@OneToMany(mappedBy = "typeAbonnement")
	@NotEmpty(message="*Please provide a valid period ")
	Set<Abonnement> listeAbonnement =new HashSet<>();

	@OneToMany(mappedBy = "typeAbonnement")
	Set<AboActivite> listeAboActivite =new HashSet<>();

	
	
	public TypeAbonnement() {
		super();
	}

	public TypeAbonnement(int id_abonnement, @NotEmpty(message = "*Please provide a valid name ") String nom_abonnement,
			@NotEmpty(message = "*Please provide a valid price") double tarif_abonnement, int duree_abonnement,
			@NotEmpty(message = "*Please provide a valid period ") Set<Abonnement> listeAbonnement,
			Set<AboActivite> listeAboActivite) {
		super();
		this.id_abonnement = id_abonnement;
		this.nom_abonnement = nom_abonnement;
		this.tarif_abonnement = tarif_abonnement;
		this.duree_abonnement = duree_abonnement;
		this.listeAbonnement = listeAbonnement;
		this.listeAboActivite = listeAboActivite;
	}

	public int getId_abonnement() {
		return id_abonnement;
	}

	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement = id_abonnement;
	}

	public String getNom_abonnement() {
		return nom_abonnement;
	}

	public void setNom_abonnement(String nom_abonnement) {
		this.nom_abonnement = nom_abonnement;
	}

	public double getTarif_abonnement() {
		return tarif_abonnement;
	}

	public void setTarif_abonnement(double tarif_abonnement) {
		this.tarif_abonnement = tarif_abonnement;
	}

	public int getDuree_abonnement() {
		return duree_abonnement;
	}

	public void setDuree_abonnement(int duree_abonnement) {
		this.duree_abonnement = duree_abonnement;
	}

	public Set<Abonnement> getListeAbonnement() {
		return listeAbonnement;
	}

	public void setListeAbonnement(Set<Abonnement> listeAbonnement) {
		this.listeAbonnement = listeAbonnement;
	}

	public Set<AboActivite> getListeAboActivite() {
		return listeAboActivite;
	}

	public void setListeAboActivite(Set<AboActivite> listeAboActivite) {
		this.listeAboActivite = listeAboActivite;
	}
	
	
}
