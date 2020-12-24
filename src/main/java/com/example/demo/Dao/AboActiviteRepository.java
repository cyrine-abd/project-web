package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AboActivite;


@Repository
public interface AboActiviteRepository extends JpaRepository<AboActivite,Integer>{

}
