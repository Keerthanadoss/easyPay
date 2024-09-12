package com.payroll_app.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.payroll_app.project.model.JobSeeker;
import com.payroll_app.project.service.JobSeekerService;
 

@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController {
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	@PostMapping("/add")
	public JobSeeker addJobSeeker(@RequestBody JobSeeker jobSeeker){
		return jobSeekerService.addJobSeeker(jobSeeker);
		
	}

}
