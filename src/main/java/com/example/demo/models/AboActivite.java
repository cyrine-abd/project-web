package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AboActivite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_AboActivite;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="activite_id")
	public Activite activite_id ;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="typeAbonnement_id")
	public TypeAbonnement typeAbonnement ;

	//Getters & Setters
	
	public AboActivite(Activite activite, TypeAbonnement typeAbonnement) {
		super();
		this.activite_id = activite;
		this.typeAbonnement = typeAbonnement;
	}
	
	
	
	public AboActivite() {
		super();
	}



	public Activite getActivite() {
		return activite_id;
	}

	

	public void setActivite(Activite activite) {
		this.activite_id = activite;
	}

	public TypeAbonnement getTypeAbonnement() {
		return typeAbonnement;
	}

	public void setTypeAbonnement(TypeAbonnement typeAbonnement) {
		this.typeAbonnement = typeAbonnement;
	}



	public int getId_AboActivite() {
		return id_AboActivite;
	}



	public void setId_AboActivite(int id_AboActivite) {
		this.id_AboActivite = id_AboActivite;
	}
	
	
	
	
	

}
