package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

public class ProductCreationDto {

	private List<Proizvod> proizvodi;
	
	

	public ProductCreationDto() {
		super();
		this.proizvodi = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}
	
	public void addProduct(Proizvod p)
	{
		this.proizvodi.add(p);
	}
}
