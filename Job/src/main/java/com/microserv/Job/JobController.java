package com.microserv.Job;

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
@RequestMapping("/job")
public class JobController
{
	
	@Autowired
	JobService jobService;
	
	@GetMapping("/findall")
	public List<Jobs> getJobs(@RequestParam Long companyId) {
		List<Jobs> reviewList = jobService.findJobsByCompanyId(companyId);
		System.out.println(reviewList);
		return reviewList;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Jobs> addReview(@RequestBody Jobs review) {
		return jobService.addJob(review);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteJob(@RequestParam Long jobId){
		return jobService.deleteJob(jobId);
	}
}
