package com.example.demo.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quadres")
public class Quadre {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nomautor;
	
	@Column(name="nomquadre", nullable=false)
	private String nomquadre;
	
	private int preu;
	//private Timestamp dataentrada;
	
	@Column(name="botigaid", nullable=false, length=30)
	private int botigaid;
	
	
	public Quadre(int id, String nomautor, String nomquadre, int preu, int botigaid) {
		super();
		this.id = id;
		this.nomautor = nomautor;
		this.nomquadre = nomquadre;
		this.preu = preu;
		//this.dataentrada = new Timestamp(System.currentTimeMillis());
		
		this.botigaid = botigaid;
	}
	
	//Constructor sense botigaID
	public Quadre(int id, String nomautor, String nomquadre, int preu) {
		super();
		this.id = id;
		this.nomautor = nomautor;
		this.nomquadre = nomquadre;
		this.preu = preu;
		//this.dataentrada = new Timestamp(System.currentTimeMillis());
	}
	
	public Quadre() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomautor() {
		return nomautor;
	}
	public void setNomautor(String nomautor) {
		this.nomautor = nomautor;
	}
	public String getNomquadre() {
		return nomquadre;
	}
	public void setNomquadre(String nomquadre) {
		this.nomquadre = nomquadre;
	}
	public int getPreu() {
		return preu;
	}
	public void setPreu(int preu) {
		this.preu = preu;
	}
	/*public Timestamp getDataentrada() {
		return dataentrada;
	}
	public void setDataentrada(Timestamp dataentrada) {
		this.dataentrada = dataentrada;
	}*/

	public int getBotigaid() {
		return botigaid;
	}

	public void setBotigaid(int botigaid) {
		this.botigaid = botigaid;
	}
	
	

}
