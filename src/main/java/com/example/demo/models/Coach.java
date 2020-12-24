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


@Entity
public class Coach implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id_coach ;
	
	@Column (name= "prenom_coach", nullable=false)
	@NotEmpty(message="*Please provide your first name")
	private String prenom_coach ;

	@Column (name= "nom_coach", nullable=false)
	@NotEmpty(message="*Please provide your last name")
	private String nom_coach ;
	
	@Column (name= "tel_coach", nullable=false)
	private int tel_coach;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="salle_id")
	public Salle salle_coach;
	
	@OneToMany(mappedBy = "seance_coach")
	Set<Seance> coachs_gerer =new HashSet<>();

	
	
	public Coach() {
		super();
	}

	public Coach(int id_coach, @NotEmpty(message = "*Please provide your first name") String prenom_coach,
			@NotEmpty(message = "*Please provide your last name") String nom_coach, int tel_coach, Salle salle_coach,
			Set<Seance> coachs_gerer) {
		super();
		this.id_coach = id_coach;
		this.prenom_coach = prenom_coach;
		this.nom_coach = nom_coach;
		this.tel_coach = tel_coach;
		this.salle_coach = salle_coach;
		this.coachs_gerer = coachs_gerer;
	}

	public int getId_coach() {
		return id_coach;
	}

	public void setId_coach(int id_coach) {
		this.id_coach = id_coach;
	}

	public String getPrenom_coach() {
		return prenom_coach;
	}

	public void setPrenom_coach(String prenom_coach) {
		this.prenom_coach = prenom_coach;
	}

	public String getNom_coach() {
		return nom_coach;
	}

	public void setNom_coach(String nom_coach) {
		this.nom_coach = nom_coach;
	}

	public int getTel_coach() {
		return tel_coach;
	}

	public void setTel_coach(int tel_coach) {
		this.tel_coach = tel_coach;
	}

	public Salle getSalle_coach() {
		return salle_coach;
	}

	public void setSalle_coach(Salle salle_coach) {
		this.salle_coach = salle_coach;
	}

	public Set<Seance> getCoachs_gerer() {
		return coachs_gerer;
	}

	public void setCoachs_gerer(Set<Seance> coachs_gerer) {
		this.coachs_gerer = coachs_gerer;
	}
	
	

	
	
}
