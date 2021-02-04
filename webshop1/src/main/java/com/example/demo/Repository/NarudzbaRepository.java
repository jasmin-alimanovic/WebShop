package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Narudzba;

public interface NarudzbaRepository extends JpaRepository<Narudzba,Integer> {

	Narudzba findByDtm(String dtm_narudzbe);
}
