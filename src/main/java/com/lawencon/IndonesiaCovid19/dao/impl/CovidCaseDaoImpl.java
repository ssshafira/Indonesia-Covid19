package com.lawencon.IndonesiaCovid19.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.IndonesiaCovid19.dao.CovidCaseDao;
import com.lawencon.IndonesiaCovid19.model.CovidCase;

@Repository
public class CovidCaseDaoImpl extends CustomRepo implements CovidCaseDao {

	@Override
	public void insert(CovidCase cocas) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CovidCase> findAll() throws Exception {
		Query q = em.createQuery (" select c from CovidCase c inner join c.covid");
		return q.getResultList();
	}

	@Override
	public void update(CovidCase cocas) throws Exception {
		CovidCase cek = new CovidCase();
		cek = findById(cocas.getId());
		cek.setCovid(cek.getCovid());
		cek.setDate(cocas.getDate());
		cek.setDeath(cocas.getDeath());
		cek.setProvinsi(cocas.getProvinsi());
		cek.setValue(cocas.getValue());
		em.merge(cek);
	}

	@Override
	public void delete(CovidCase cocas) throws Exception {
		em.remove(findById(cocas.getId()));
	}

	@Override
	public CovidCase findById(Long id) throws Exception {
		Query q = em.createQuery(" FROM CovidCase WHERE id =:idParam");
		q.setParameter("idParam", id);
		return (CovidCase) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CovidCase> getByCovidId(Long id) throws Exception {
		Query q = em.createQuery (" FROM CovidCase WHERE covid.covidId = :param");
		q.setParameter ("param", id);
		q.executeUpdate ();
		return q.getResultList();
	}

	
}
