package com.lawencon.IndonesiaCovid19.dao;

import java.util.List;

import com.lawencon.IndonesiaCovid19.model.CoCocas;
import com.lawencon.IndonesiaCovid19.model.Covid;
import com.lawencon.IndonesiaCovid19.model.CovidCase;

public interface CovidDao {

	abstract void insert(Covid co) throws Exception;
	abstract List<Covid> findAll() throws Exception;
	abstract void update(Covid co) throws Exception;
	abstract void delete(Covid co) throws Exception;
	
	abstract Covid findById(Long id) throws Exception;
	abstract void insertToCocas(CovidCase cocas) throws Exception;
	abstract void saveAll(CoCocas coco) throws Exception;
}
