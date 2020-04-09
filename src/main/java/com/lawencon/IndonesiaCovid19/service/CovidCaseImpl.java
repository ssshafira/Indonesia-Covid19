package com.lawencon.IndonesiaCovid19.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.IndonesiaCovid19.dao.CovidCaseDao;
import com.lawencon.IndonesiaCovid19.dao.LoginDao;
import com.lawencon.IndonesiaCovid19.model.CovidCase;

@Service
@Transactional
public class CovidCaseImpl implements CovidCaseService {

	@Autowired
	private CovidCaseDao covidCaseDao;

	@Autowired
	private LoginDao loginDao;

	@Override
	public void delete(CovidCase cocas, String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1)
			covidCaseDao.delete(cocas);
	}

	@Override
	public void update(CovidCase cocas, String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1)
			covidCaseDao.update(cocas);
	}

	@Override
	public List<CovidCase> findAll(String au0, String au1) throws Exception {
		if (loginDao.cekValid(au0, au1) == 1)
			return covidCaseDao.findAll();
		else return null;
	}

}
