package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="korisnik")
public class Korisnik {

	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	private int id;
	private String ime;
	private String prezime;
	private String email;
	private String username;
	private String password;
	private String adresa;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable=false)
	private Role role;
	
	@OneToMany(mappedBy="korisnik")
	private Set<Narudzba> narudzba;
	
	@OneToMany(mappedBy="korisnik")
	private Set<Proizvod> proizvod;
	
	@OneToMany(mappedBy="korisnik")
	private Set<Korpa> korpa;
	
	
	
	public Korisnik(String ime, String prezime, String email, String username, String adresa, Role role) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.username = username;
		this.adresa = adresa;
		this.role = role;
	}
	
	
	public Set<Narudzba> getNarudzba() {
		return narudzba;
	}


	public void setNarudzba(Set<Narudzba> narudzba) {
		this.narudzba = narudzba;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Set<Proizvod> getProizvod() {
		return proizvod;
	}


	public void setProizvod(Set<Proizvod> proizvod) {
		this.proizvod = proizvod;
	}


	public Set<Korpa> getKorpa() {
		return korpa;
	}


	public void setKorpa(Set<Korpa> korpa) {
		this.korpa = korpa;
	}
	
	
	
}
