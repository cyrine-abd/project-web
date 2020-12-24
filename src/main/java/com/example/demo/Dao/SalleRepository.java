package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Integer> {

}
