package com.lawencon.IndonesiaCovid19.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Covid {
	
	/*** HEADER ***/

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long covidId;
	
	private int totalCases;
	private int totalDeaths;

	public Long getId() {
		return covidId;
	}

	public void setId(Long id) {
		this.covidId = id;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	
}
