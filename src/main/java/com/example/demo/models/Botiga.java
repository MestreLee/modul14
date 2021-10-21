package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="botigues")
public class Botiga {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", nullable=false)
	private String nom;
	
	private int maxquadres;
	
	public Botiga(int id, String nom, int maxquadres) {
		super();
		this.id = id;
		this.nom = nom;
		this.maxquadres = maxquadres;
	}
	
	public Botiga() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getMaxquadres() {
		return maxquadres;
	}
	public void setMaxquadres(int maxquadres) {
		this.maxquadres = maxquadres;
	}

}
