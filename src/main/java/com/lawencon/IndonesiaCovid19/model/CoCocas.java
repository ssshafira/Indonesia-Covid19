package com.lawencon.IndonesiaCovid19.model;

import java.util.List;

public class CoCocas {

	private Covid covid;
	private List<CovidCase> listCocas;

	public Covid getCovid() {
		return covid;
	}

	public void setCovid(Covid covid) {
		this.covid = covid;
	}

	public List<CovidCase> getListCocas() {
		return listCocas;
	}

	public void setListCocas(List<CovidCase> listCocas) {
		this.listCocas = listCocas;
	}

}
