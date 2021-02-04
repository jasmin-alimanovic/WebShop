package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Entity.Korisnik;

@EnableJpaRepositories
public interface KorisnikRepository extends JpaRepository<Korisnik,Integer>{

	Korisnik findByEmailAndPassword(String email, String Password);
	
}
