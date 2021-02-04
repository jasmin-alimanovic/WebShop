package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Entity.NarudzbaStavke;
@EnableJpaRepositories
public interface NarudzbeStavkeRepository extends JpaRepository<NarudzbaStavke,Integer> {

}
