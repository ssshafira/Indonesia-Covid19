package com.lawencon.IndonesiaCovid19.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.IndonesiaCovid19.dao.LoginDao;

@Repository
public class LoginDaoImpl extends CustomRepo implements LoginDao {

	@Override
	public Long cekValid(String uname, String pwd) {
		Query q = em.createQuery("SELECT COUNT(*) FROM Login WHERE uname =: uParam AND pwd =: pParam");
		q.setParameter("uParam", uname);
		q.setParameter("pParam", pwd);
		return (Long) q.getSingleResult();
	}

	
}
