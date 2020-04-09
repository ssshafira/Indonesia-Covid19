package com.lawencon.IndonesiaCovid19.dao;

import java.util.List;

import com.lawencon.IndonesiaCovid19.model.CovidCase;

public interface CovidCaseDao {

	abstract void insert(CovidCase cocas) throws Exception;
	abstract List<CovidCase> findAll() throws Exception;
	abstract void update(CovidCase cocas) throws Exception;
	abstract void delete(CovidCase cocas) throws Exception;
	
	abstract CovidCase findById(Long id) throws Exception;
	abstract List<CovidCase> getByCovidId(Long id) throws Exception;
}
