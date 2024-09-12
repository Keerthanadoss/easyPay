package com.payroll_app.project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payroll_app.project.exception.InputValidationException;
import com.payroll_app.project.model.JobSeeker;
import com.payroll_app.project.model.Resume;
import com.payroll_app.project.model.User;
import com.payroll_app.project.repository.JobSeekerRepository;
import com.payroll_app.project.repository.ResumeRepository;
import com.payroll_app.project.repository.UserRepository;

@Service
public class JobSeekerService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ResumeRepository resumeRepository;
	
	public JobSeeker addJobSeeker(JobSeeker jobSeeker) {
		Resume resume=jobSeeker.getResume();
		resume=resumeRepository.save(resume);
		jobSeeker.setResume(resume);
		User user=jobSeeker.getUser();
		user.setRole("ROLE_JOBSEEKER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user=userRepository.save(user);
		jobSeeker.setUser(user);
		return jobSeekerRepository.save(jobSeeker);
	}
	
	public void validateJobSeeker(JobSeeker jobSeeker) throws InputValidationException {
		if(jobSeeker==null) 
			throw new InputValidationException("Object cannot be null");
		if(jobSeeker.getName()==null|| jobSeeker.getName().equals(""))
			throw new InputValidationException("JobSeeker name given is NULL or blank, InputValidationException Thrown");
		if(jobSeeker.getContact()==null|| jobSeeker.getContact().equals(""))
			throw new InputValidationException("JobSeeker contact given is NULL or blank, InputValidationException Thrown");
		if(jobSeeker.getDateOfBirth()==null)
			throw new InputValidationException("JobSeeker dob given is NULL or blank, InputValidationException Thrown");	
	}

		
}


