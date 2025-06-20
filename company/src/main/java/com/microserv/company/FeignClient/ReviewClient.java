package com.microserv.company.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microserv.company.Review;

@FeignClient(name="Reviews")
public interface ReviewClient {
	
	@GetMapping("/review/findall")
	List<Review> getReviews(@RequestParam("companyId") Long companyId);

}
