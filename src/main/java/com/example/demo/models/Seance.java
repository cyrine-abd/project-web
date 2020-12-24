package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
@IdClass(compo_id_seance.class)
public class Seance implements Serializable {

	
	@Id
	private int id_seance;
	
	
    private Coach seance_coach;
	private Activite activite_seance;
	
	
	@Column (name= "debut_Gerer")
    private Date debut_Seance ;
	
    @Column (name= "fin_Gerer")
    private Date fin_Seance ;
    
    @Column (name= "presence")
	private boolean presence  ;

	public Seance(Coach seance_coach, Activite activite_seance, Date debut_Seance, Date fin_Seance, boolean presence) {
		super();
		this.debut_Seance = debut_Seance;
		this.fin_Seance = fin_Seance;
		this.presence = presence;
	}

	public Seance() {
		super();
	}

	

	public Date getDebut_Seance() {
		return debut_Seance;
	}
	public void setId_seance(int id_seance ) {
		this.id_seance = id_seance;
	}

	public int getId_seance() {
		return id_seance;
		
	}

	public void setDebut_Seance(Date debut_Seance) {
		this.debut_Seance = debut_Seance;
	}

	public Date getFin_Seance() {
		return fin_Seance;
	}

	public void setFin_Seance(Date fin_Seance) {
		this.fin_Seance = fin_Seance;
	}

	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}
    
    
    
    

}
