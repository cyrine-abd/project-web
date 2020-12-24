package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class TypeActivite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id_typeActivite ;
	
	@Column (name= "description_typeActivite", nullable=false)
	@NotEmpty(message="*Please provide your description")
	private String description_typeActivite ;

	@OneToMany(mappedBy = "t_acivite")
    private List<Activite> activites =new ArrayList<>() ;

	
	
	public TypeActivite() {
		super();
	}

	public TypeActivite(int id_typeActivite,
			@NotEmpty(message = "*Please provide your description") String description_typeActivite,
			List<Activite> activites) {
		super();
		this.id_typeActivite = id_typeActivite;
		this.description_typeActivite = description_typeActivite;
		this.activites = activites;
	}

	public int getId_typeActivite() {
		return id_typeActivite;
	}

	public void setId_typeActivite(int id_typeActivite) {
		this.id_typeActivite = id_typeActivite;
	}

	public String getDescription_typeActivite() {
		return description_typeActivite;
	}

	public void setDescription_typeActivite(String description_typeActivite) {
		this.description_typeActivite = description_typeActivite;
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}
	
	
	
}
