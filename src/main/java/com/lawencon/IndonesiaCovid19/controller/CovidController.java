package com.lawencon.IndonesiaCovid19.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.IndonesiaCovid19.model.CoCocas;
import com.lawencon.IndonesiaCovid19.model.Covid;
import com.lawencon.IndonesiaCovid19.model.CovidCase;
import com.lawencon.IndonesiaCovid19.service.CovidCaseService;
import com.lawencon.IndonesiaCovid19.service.CovidService;

@RestController
public class CovidController extends BaseController<Object> {

	@Autowired
	private CovidService coService;
	
	@Autowired
	private CovidCaseService cocasService;
	
	/*** CRUD HEADER ***/
	@GetMapping("/covid")
	public ResponseEntity<List<Covid>> getAllCovid(@RequestHeader("Authorization") String uname) {
		List<Covid> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = coService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/covid/insert")
	public ResponseEntity<?> insertCovid(@RequestBody CoCocas coco, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			coService.saveAll(coco, auth[0], auth[1]);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/covid/delete")
	public ResponseEntity<?> deleteCovid(@RequestBody Covid co, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			coService.delete(co, auth[0], auth[1]);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*** CRUD DETAIL ***/
	
	@GetMapping("/covidcase")
	public ResponseEntity<?> getAllCovidAndCase(@RequestHeader("Authorization") String uname) {
		List<CovidCase> listData = new ArrayList<>();
		try {
			String[] auth = super.authUser(uname);
			listData = cocasService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listData, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/covid/update/detail")
	public ResponseEntity<?> updateCovidCase(@RequestBody CovidCase coca, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			cocasService.update(coca, auth[0], auth[1]);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/covid/delete/detail")
	public ResponseEntity<?> deleteCovidCase(@RequestBody CovidCase coca, @RequestHeader("Authorization") String uname) {
		try {
			String[] auth = super.authUser(uname);
			cocasService.delete(coca, auth[0], auth[1]);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
