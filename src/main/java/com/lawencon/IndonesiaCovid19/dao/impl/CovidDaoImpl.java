package com.lawencon.IndonesiaCovid19.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.IndonesiaCovid19.dao.CovidDao;
import com.lawencon.IndonesiaCovid19.model.CoCocas;
import com.lawencon.IndonesiaCovid19.model.Covid;
import com.lawencon.IndonesiaCovid19.model.CovidCase;

@Repository
public class CovidDaoImpl extends CustomRepo implements CovidDao {
	
	@Autowired
	private CovidRepo covidRepo;
	
	@Autowired
	private CovidCaseRepo cocasRepo;

	@Override
	public void insert(Covid co) throws Exception {
		Covid cek = new Covid();
		cek.setId(co.getId());
		em.persist(co);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Covid> findAll() throws Exception {
		Query q = em.createQuery(" from Covid");
		return q.getResultList();
	}

	@Override
	public void update(Covid co) throws Exception {
		Covid temp = new Covid();
		temp = findById(co.getId());
		temp.setTotalCases(co.getTotalCases());
		temp.setTotalDeaths(co.getTotalDeaths());
		em.merge(temp);
	}

	@Override
	public void delete(Covid co) throws Exception {
		em.remove(co);
	}

	@Override
	public Covid findById(Long id) throws Exception {
		Query q = em.createQuery(" from Covid where covidId =:idParam");
		q.setParameter("idParam", id);
		return (Covid) q.getSingleResult();
	}

	@Override
	public void insertToCocas(CovidCase cocas) throws Exception {
		cocasRepo.save(cocas);
	}

	@Override
	public void saveAll(CoCocas coco) throws Exception {
		Covid header = covidRepo.save(new Covid());	// ngesave header tapi isinya masih ID doang
		List<CovidCase> listCc = coco.getListCocas();		
	
		listCc.forEach(val -> {		
			try {
				CovidCase detail = val;
				detail.setCovid(header);
				insertToCocas(detail);	// ngesave ke CovidCase
			} catch (Exception e) {
				e.printStackTrace();
			}		
		});	
		
		header.setTotalCases(cocasRepo.getTotalCase(header.getId()));
		header.setTotalDeaths(cocasRepo.getTotalDeath(header.getId()));
		covidRepo.save(header);	
	}
	
}
