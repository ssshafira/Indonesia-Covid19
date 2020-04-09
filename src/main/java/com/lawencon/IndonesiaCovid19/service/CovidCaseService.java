package com.lawencon.IndonesiaCovid19.service;

import java.util.List;

import com.lawencon.IndonesiaCovid19.model.CovidCase;

public interface CovidCaseService {

	abstract List<CovidCase> findAll(String au0, String au1) throws Exception;
	abstract void update(CovidCase cocas, String au0, String au1) throws Exception;
	abstract void delete(CovidCase cocas, String au0, String au1) throws Exception;
}
