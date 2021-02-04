package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Entity.Korpa;

@EnableJpaRepositories
public interface KorpaRepository extends JpaRepository<Korpa,Integer> {

	//@Query("select k.id, k.proizvod_id, k.korisnik.id from korpa k where k.korisnik.id = :korisnik_id")
	List<Korpa> findByKorisnik_id(int korisnik_id);
}
