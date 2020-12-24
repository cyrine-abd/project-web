package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Integer>{

}
