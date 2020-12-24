package com.example.demo.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class compo_id_Abonnement implements Serializable{
	private Membre membre ;
	private TypeAbonnement typeAbonnement ;
	public compo_id_Abonnement(Membre membre, TypeAbonnement typeAbonnement) {
		super();
		this.membre = membre;
		this.typeAbonnement = typeAbonnement;
	}
	@Override
	 public boolean equals(Object obj) {
	  if (obj == null) {
	   return false;
	  }
	  if (getClass() != obj.getClass()) {
	   return false;
	  }
	  final compo_id_Abonnement other = (compo_id_Abonnement) obj;
	  return true;
	 } 
}
