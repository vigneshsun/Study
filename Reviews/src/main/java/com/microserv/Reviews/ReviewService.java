package com.microserv.Reviews;

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
public class ReviewService {
	
	@Autowired
	ReviewRepository repository;
	
	/*
	 * @Autowired EntityManager em;
	 */
	
	
	public List<Reviews> findAll() {
		return repository.findAll();
	}
	
	public List<Reviews> findReviewsByCompanyId(Long companyId){
		return repository.findByCompanyId(companyId);
	}
	
	public ResponseEntity<Reviews> addReview(Reviews reviews) {
		Reviews c=repository.save(reviews);
		if(c==null)
		{
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(c);
	}
	
	public ResponseEntity deleteCompany(@RequestParam Long companyId){
		repository.deleteById(companyId);
		return new ResponseEntity(HttpStatus.OK);
	}
}

