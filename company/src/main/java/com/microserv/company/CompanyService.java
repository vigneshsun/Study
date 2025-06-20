package com.microserv.company;

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

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository repository;
	
	public List<Company> findAll() {
		return repository.findAll();
	}
	
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		Company c=repository.save(company);
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
