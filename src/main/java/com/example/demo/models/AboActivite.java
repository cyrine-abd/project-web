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
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="activite_id")
	private Activite activite ;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="typeAbonnement_id")
	private TypeAbonnement typeAbonnement ;

	//Getters & Setters
	
	public AboActivite(Activite activite, TypeAbonnement typeAbonnement) {
		super();
		this.activite = activite;
		this.typeAbonnement = typeAbonnement;
	}
	
	
	
	public AboActivite() {
		super();
	}



	public Activite getActivite() {
		return activite;
	}

	

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public TypeAbonnement getTypeAbonnement() {
		return typeAbonnement;
	}

	public void setTypeAbonnement(TypeAbonnement typeAbonnement) {
		this.typeAbonnement = typeAbonnement;
	}
	
	
	
	
	

}
