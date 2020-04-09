package com.lawencon.IndonesiaCovid19.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class CustomRepo {

	@PersistenceContext
	protected EntityManager em;
}
