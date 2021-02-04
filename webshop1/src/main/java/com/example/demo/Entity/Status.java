package com.example.demo.Entity;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="status")
public class Status {

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="status")
	Set<Narudzba> narudzba;
	
	public Status(int id) {
		super();
		this.id = id;
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
