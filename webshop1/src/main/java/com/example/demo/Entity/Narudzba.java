package com.example.demo.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="narudzba")
public class Narudzba {

	@Id
	private int id;
	@Column(name="dtm_narudzbe")
	private String dtm;
	@ManyToOne
	@JoinColumn(name = "status_id", nullable=false)
	private Status status;
	@ManyToOne
	@JoinColumn(name = "korisnik_id")
	private Korisnik korisnik;
	@OneToMany(mappedBy="narudzba")
	private Set<NarudzbaStavke> narudzba_stavke;
	
	
	public Set<NarudzbaStavke> getStavke() {
		return narudzba_stavke;
	}
	public void setStavke(Set<NarudzbaStavke> narudzba_stavke) {
		this.narudzba_stavke = narudzba_stavke;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDtm() {
		return dtm;
	}
	public void setDtm(String dtm_narudzbe) {
		this.dtm = dtm_narudzbe;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
}
