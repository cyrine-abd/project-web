package com.example.demo.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class compo_id_seance implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
    @Id
    @ManyToOne
	@JoinColumn(name="coach_id")
    public Coach seance_coach;

    @Id
    @ManyToOne
    @JoinColumn(name = "activite_id")
    public Activite activite_seance;
    
	public compo_id_seance(Coach seance_coach, Activite activite_seance) {
		super();
		this.seance_coach = seance_coach;
		this.activite_seance = activite_seance;
	}


	@Override
	 public boolean equals(Object obj) {
	  if (obj == null) {
	   return false;
	  }
	  if (getClass() != obj.getClass()) {
	   return false;
	  }
	  final compo_id_seance other = (compo_id_seance) obj;
	  return true;
	 } 
}
