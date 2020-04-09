package com.lawencon.IndonesiaCovid19.dao;

public interface LoginDao {

	abstract Long cekValid(String uname, String pwd);
	
}
