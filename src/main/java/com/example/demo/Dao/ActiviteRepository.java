package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Activite;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite,Integer>{

}
