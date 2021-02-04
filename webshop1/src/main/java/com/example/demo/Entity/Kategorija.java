package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="kategorija")
public class Kategorija {

	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="kategorija")
	Set<Proizvod> proizvod;
	
	public Kategorija() {
		super();
		// TODO Auto-generated constructor stub
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
	public Set<Proizvod> getProizvodi() {
		return proizvod;
	}
	public void setProizvodi(Set<Proizvod> proizvod) {
		this.proizvod = proizvod;
	}
	
	
}
