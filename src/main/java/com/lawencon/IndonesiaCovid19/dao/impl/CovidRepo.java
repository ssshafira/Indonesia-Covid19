package com.lawencon.IndonesiaCovid19.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.IndonesiaCovid19.model.Covid;

@Repository
public interface CovidRepo extends JpaRepository<Covid, Long>{

}
