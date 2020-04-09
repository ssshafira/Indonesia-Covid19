package com.lawencon.IndonesiaCovid19.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.IndonesiaCovid19.dao.CovidDao;
import com.lawencon.IndonesiaCovid19.dao.LoginDao;
import com.lawencon.IndonesiaCovid19.model.CoCocas;
import com.lawencon.IndonesiaCovid19.model.Covid;
import com.lawencon.IndonesiaCovid19.model.CovidCase;

@Service
@Transactional
public class CovidServiceImpl implements CovidService {
	
	@Autowired
	private CovidDao covidDao;
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public void insert(Covid co, String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1)
			covidDao.insert(co);
	}

	@Override
	public List<Covid> findAll(String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1)
			return covidDao.findAll();
		else return null;
	}

	@Override
	public void update(Covid co, String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1)
			covidDao.update(co);
	}

	@Override
	public void delete(Covid co, String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1) {
			covidDao.delete(co);
		}
	}

	@Override
	public Covid findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return covidDao.findById(id);
	}

	@Override
	public void insertToCocas(CovidCase cocas) throws Exception {
		// TODO Auto-generated method stub
		covidDao.insertToCocas(cocas);
	}

	@Override
	public void saveAll(CoCocas coco, String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1)
			covidDao.saveAll(coco);
	}

	
}
