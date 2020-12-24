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
public class Seance implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="coach_id")
	public Coach seance_coach;

	
    @Id
    @ManyToOne
    @JoinColumn(name = "id_activite", referencedColumnName = "id_activite")
    private Activite activite_seance;
	
    @Id
	@Column (name= "debut_Gerer")
    private Date debut_Seance ;
	
    @Column (name= "fin_Gerer")
    private Date fin_Seance ;
    
    @Column (name= "presence")
	private boolean presence  ;

	public Seance(Coach seance_coach, Activite activite_seance, Date debut_Seance, Date fin_Seance, boolean presence) {
		super();
		this.seance_coach = seance_coach;
		this.activite_seance = activite_seance;
		this.debut_Seance = debut_Seance;
		this.fin_Seance = fin_Seance;
		this.presence = presence;
	}

	public Seance() {
		super();
	}

	public Coach getSeance_coach() {
		return seance_coach;
	}

	public void setSeance_coach(Coach seance_coach) {
		this.seance_coach = seance_coach;
	}

	public Activite getActivite_seance() {
		return activite_seance;
	}

	public void setActivite_seance(Activite activite_seance) {
		this.activite_seance = activite_seance;
	}

	public Date getDebut_Seance() {
		return debut_Seance;
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
