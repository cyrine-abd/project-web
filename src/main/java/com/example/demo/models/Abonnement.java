package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Abonnement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="date_Abonner")
	private Date date_Abonner ;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="membre_id")
	private Membre membre ;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="typeAbonnement_id")
	private TypeAbonnement typeAbonnement ;

	public Abonnement(Date date_Abonner, Membre membre, TypeAbonnement typeAbonnement) {
		super();
		this.date_Abonner = date_Abonner;
		this.membre = membre;
		this.typeAbonnement = typeAbonnement;
	}
	
	
	
	public Abonnement() {
		super();
	}



	public Date getDate_Abonner() {
		return date_Abonner;
	}

	public void setDate_Abonner(Date date_Abonner) {
		this.date_Abonner = date_Abonner;
	}

	

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public TypeAbonnement getTypeAbonnement() {
		return typeAbonnement;
	}

	public void setTypeAbonnement(TypeAbonnement typeAbonnement) {
		this.typeAbonnement = typeAbonnement;
	}
	
	
	
	
	
}
