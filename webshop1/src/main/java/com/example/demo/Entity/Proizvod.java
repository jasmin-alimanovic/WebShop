package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity(name="proiz")
@Table(name="proizvod")
public class Proizvod {

	
	@Id
	private int id;
	private String name;
	private String opis;
	private double cijena;
	private Integer kolicina;
	private String ime_autora;
	private String prezime_autora;
	
	@ManyToOne
	@JoinColumn(name = "korisnik_id")
	private Korisnik korisnik;
	
	private Integer korpa_id;
	
	
	
	@ManyToOne
	@JoinColumn(name="kategorija_id", nullable=false)
	private Kategorija kategorija;
	
	@OneToMany(mappedBy="proizvod")
	private Set<NarudzbaStavke> narudzba_stavke;
	
	
	public Proizvod() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proizvod(int id) {
		super();
		this.id = id;
	}
	
	public int getKorpa_id() {
		return korpa_id;
	}
	public void setKorpa_id(Integer korpa) {
		this.korpa_id = korpa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	public Set<NarudzbaStavke> getNarudzbaStavke() {
		return narudzba_stavke;
	}
	public void setNarudzbaStavke(Set<NarudzbaStavke> narudzba_stavke) {
		this.narudzba_stavke = narudzba_stavke;
	}
	public String getIme_autora() {
		return ime_autora;
	}
	public void setIme_autora(String ime_autora) {
		this.ime_autora = ime_autora;
	}
	public String getPrezime_autora() {
		return prezime_autora;
	}
	public void setPrezime_autora(String prezime_autora) {
		this.prezime_autora = prezime_autora;
	}
	public Set<NarudzbaStavke> getNarudzba_stavke() {
		return narudzba_stavke;
	}
	public void setNarudzba_stavke(Set<NarudzbaStavke> narudzba_stavke) {
		this.narudzba_stavke = narudzba_stavke;
	}
	
	
	
}
