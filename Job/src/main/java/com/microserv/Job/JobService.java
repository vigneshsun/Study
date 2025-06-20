package com.microserv.Job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import jakarta.persistence.EntityManager;

@Service
public class JobService {
	
	@Autowired
	JobRepository repository;
	
	/*
	 * @Autowired EntityManager em;
	 */
	
	
	public List<Jobs> findAll() {
		return repository.findAll();
	}
	
	public List<Jobs> findJobsByCompanyId(Long companyId){
		return repository.findJobsByCompanyId(companyId);
	}
	
	public ResponseEntity<Jobs> addJob(Jobs job) {
		Jobs c=repository.save(job);
		if(c==null)
		{
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(c);
	}
	
	public ResponseEntity deleteJob(@RequestParam Long companyId){
		repository.deleteById(companyId);
		return new ResponseEntity(HttpStatus.OK);
	}
}

