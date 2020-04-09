package com.lawencon.IndonesiaCovid19.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.IndonesiaCovid19.model.CovidCase;

@Repository
public interface CovidCaseRepo extends JpaRepository<CovidCase, Long> {

	@Query("select sum(c.value) from CovidCase c where c.covid.covidId =?1")
	public Integer getTotalCase(Long covidId);
	
	@Query("select sum(c.death) from CovidCase c where c.covid.covidId =?1")
	public Integer getTotalDeath(Long covidId);
	
	@Query("delete from CovidCase c where c.covid.covidId =?1")
	public void deleteByCovidId(Long covidId);
}
