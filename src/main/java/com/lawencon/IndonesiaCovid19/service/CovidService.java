package com.lawencon.IndonesiaCovid19.service;

import java.util.List;

import com.lawencon.IndonesiaCovid19.model.CoCocas;
import com.lawencon.IndonesiaCovid19.model.Covid;
import com.lawencon.IndonesiaCovid19.model.CovidCase;

public interface CovidService {

	abstract void insert(Covid co, String au0, String au1) throws Exception;
	abstract List<Covid> findAll(String au0, String au1) throws Exception;
	abstract void update(Covid co, String au0, String au1) throws Exception;
	abstract void delete(Covid co, String au0, String au1) throws Exception;
	
	abstract Covid findById(Long id) throws Exception;
	abstract void insertToCocas(CovidCase cocas) throws Exception;
	abstract void saveAll(CoCocas coco, String au0, String au1) throws Exception;
}
