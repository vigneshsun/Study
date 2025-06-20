package com.microserv.Reviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/review")
public class ReviewController
{
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/findall")
	public List<Reviews> getReviews(@RequestParam Long companyId) {
		List<Reviews> reviewList = reviewService.findReviewsByCompanyId(companyId);
		System.out.println(reviewList);
		return reviewList;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Reviews> addReview(@RequestBody Reviews review) {
		return reviewService.addReview(review);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteCompany(@RequestParam Long reviewId){
		return reviewService.deleteCompany(reviewId);
	}
}
