package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Proizvod;

@EnableJpaRepositories
public interface ProizvodRepository extends JpaRepository<Proizvod,Integer> {

	Proizvod findByName(String name);
	@Transactional
	@Modifying
	@Query("update proiz p set p.name=:name, p.opis=:opis, p.kategorija.id=:kategorija_id, p.kolicina=:kolicina, p.cijena=:cijena, p.ime_autora=:ime_autora, p.prezime_autora=:prezime_autora where p.id=:id")
	void updateProizvod(String name, String opis, int kategorija_id, int kolicina, double cijena, String ime_autora, String prezime_autora, int id);
	@Transactional
	@Modifying
	@Query("update proiz p set p.kolicina=:kolicina where p.id=:id")
	void updateKolicina(int kolicina, int id);
	
}
