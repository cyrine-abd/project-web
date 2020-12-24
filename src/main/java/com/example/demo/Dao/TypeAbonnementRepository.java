package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TypeAbonnement;


@Repository
public interface TypeAbonnementRepository extends JpaRepository<TypeAbonnement,Integer>{

}
