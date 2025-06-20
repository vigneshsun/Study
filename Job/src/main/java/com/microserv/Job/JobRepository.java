package com.microserv.Job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface JobRepository extends JpaRepository<Jobs, Long>{
	
	@Query("select j from Jobs j where j.companyId = :companyId")
	List<Jobs> findJobsByCompanyId(@Param("companyId") Long companyId);
}
