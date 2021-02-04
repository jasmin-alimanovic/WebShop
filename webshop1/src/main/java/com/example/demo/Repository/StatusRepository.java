package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.Entity.Status;

@EnableJpaRepositories
public interface StatusRepository extends JpaRepository<Status,Integer> {

}
