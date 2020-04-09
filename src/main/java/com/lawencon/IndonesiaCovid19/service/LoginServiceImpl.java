package com.lawencon.IndonesiaCovid19.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.IndonesiaCovid19.dao.LoginDao;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Long cekValid(String uname, String pwd) {
		// TODO Auto-generated method stub
		return loginDao.cekValid(uname, pwd);
	}

}
