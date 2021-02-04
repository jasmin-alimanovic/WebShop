package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy="role")
	Set<Korisnik> korisnik;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int id) {
		super();
		this.id = id;
	}
	public Role(String name) {
		super();
		this.name = name;
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
	
	
}
