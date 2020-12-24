package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TypeActivite;


@Repository
public interface TypeActiviteRepository extends JpaRepository<TypeActivite,Integer>{

}
