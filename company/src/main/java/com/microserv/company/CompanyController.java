package com.microserv.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.FlexibleHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microserv.company.FeignClient.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyService compService;
	
	ReviewClient reviewClient;
	
	public CompanyController(ReviewClient reviewClient) {
		// TODO Auto-generated constructor stub
		this.reviewClient=reviewClient;
	}
	
	@GetMapping("/findall")
	public List<Company> getCompanies() {
		List<Company> companyList = compService.findAll();
		System.out.println(companyList);
		return companyList;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		return compService.addCompany(company);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteCompany(@RequestParam Long companyId){
		return compService.deleteCompany(companyId);
	}
	
	@GetMapping("/reviews")
	public List<Review> getReviews(@RequestParam("companyId") Long companyId) {
		
		/*
		 * String url = "http://localhost:8081/review/findall?companyId="+companyId;
		 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<List<Review>>
		 * review= restTemplate.exchange(url,HttpMethod.GET, null,new
		 * ParameterizedTypeReference<List<Review>>() { });
		 */
		
		List<Review> review = reviewClient.getReviews(companyId);
		return review;
	}
}
