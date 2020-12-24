package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class Activite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id_activite ;
	
	@Column (name= "description_activite", nullable=false)
	@NotEmpty(message="*Please provide your description")
	private String description_activite ;
	
	
	@OneToMany(mappedBy = "activite_seance")
	private List<Seance> activites_Gerer =new ArrayList<>() ;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="typeActivite_id")
	private TypeActivite t_acivite ;
	
	@OneToMany(mappedBy = "activite_id")
	Set<AboActivite> listeAboActivite =new HashSet<>();

	
	
	public Activite() {
		super();
	}

	public Activite(int id_activite,
			@NotEmpty(message = "*Please provide your description") String description_activite,
			List<Seance> activites_Gerer, TypeActivite t_acivite, Set<AboActivite> listeAboActivite) {
		super();
		this.id_activite = id_activite;
		this.description_activite = description_activite;
		this.activites_Gerer = activites_Gerer;
		this.t_acivite = t_acivite;
		this.listeAboActivite = listeAboActivite;
	}

	public int getId_activite() {
		return id_activite;
	}

	public void setId_activite(int id_activite) {
		this.id_activite = id_activite;
	}

	public String getDescription_activite() {
		return description_activite;
	}

	public void setDescription_activite(String description_activite) {
		this.description_activite = description_activite;
	}

	public List<Seance> getActivites_Gerer() {
		return activites_Gerer;
	}

	public void setActivites_Gerer(List<Seance> activites_Gerer) {
		this.activites_Gerer = activites_Gerer;
	}

	public TypeActivite getT_acivite() {
		return t_acivite;
	}

	public void setT_acivite(TypeActivite t_acivite) {
		this.t_acivite = t_acivite;
	}

	public Set<AboActivite> getListeAboActivite() {
		return listeAboActivite;
	}

	public void setListeAboActivite(Set<AboActivite> listeAboActivite) {
		this.listeAboActivite = listeAboActivite;
	}
	
	
	
}
