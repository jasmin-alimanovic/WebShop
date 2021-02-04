package com.example.demo.Entity;


import javax.persistence.*;

@Entity
@Table(name="narudzba_stavke")
public class NarudzbaStavke {

	@Id
	private int id;
	private double kolicina;
	
	@ManyToOne
	@JoinColumn(name = "narudzba_id", nullable=false)
	private Narudzba narudzba;
	
	@ManyToOne
	@JoinColumn(name = "proizvod_id", nullable=false)
	private Proizvod proizvod;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Narudzba getNarudzba() {
		return narudzba;
	}
	public void setNarudzba(Narudzba narudzba) {
		this.narudzba = narudzba;
	}
	public Proizvod getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	
	
}
