package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance,Integer>{

}
