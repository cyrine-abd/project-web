package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Membre;


@Repository
public interface MembreRepository extends JpaRepository<Membre,Integer>{

}
