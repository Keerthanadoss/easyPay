package com.payroll_app.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll_app.project.model.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
	
	

}
