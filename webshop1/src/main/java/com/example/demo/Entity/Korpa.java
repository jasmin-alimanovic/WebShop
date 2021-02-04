package com.example.demo.Entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="korpa")
@Table(name="korpa")
public class Korpa {

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "korisnik_id")
	private Korisnik korisnik;
	private Integer proizvod_id;
	
	
	
	public Korpa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public int getProizvod_id() {
		return proizvod_id;
	}
	public void setProizvod_id(Integer proizvod) {
		this.proizvod_id = proizvod;
	}
	
	
}
