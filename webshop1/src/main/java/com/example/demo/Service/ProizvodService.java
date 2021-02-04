package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Proizvod;
import com.example.demo.Repository.ProizvodRepository;

@Service
public class ProizvodService {

	@Autowired
	private ProizvodRepository repo;
	
	public Proizvod saveProizvod(Proizvod p)
	{
		return repo.save(p);
	}
	
	public List<Proizvod> saveProizvode(List<Proizvod> p)
	{
		return repo.saveAll(p);
	}
	
	public List<Proizvod> getProizvode()
	{
		return repo.findAll();
	}
	public Proizvod saveProizvodeById(int id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public Proizvod getProizvodeByName(String name)
	{
		return repo.findByName(name);
	}
	
	public String deleteProizvod(int id)
	{
		repo.deleteById(id);
		return "Knjiga izbrisana";
	}
	
	public Proizvod getProizvodeById(int id)
	{
		return repo.findById(id).orElse(null);
	}
	public void updateProizvod(Proizvod p)
	{
		repo.updateProizvod(p.getName(), p.getOpis(), p.getKategorija().getId(), p.getKolicina(), p.getCijena(), p.getIme_autora(), p.getPrezime_autora(), p.getId());
	}
	public void UpdateKolicina(int kolicina, int id)
	{
		repo.updateKolicina(kolicina, id);
	}
}
