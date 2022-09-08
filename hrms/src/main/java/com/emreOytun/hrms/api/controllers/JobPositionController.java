package com.emreOytun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.JobPositionService;
import com.emreOytun.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService positionService) {
		super();
		this.jobPositionService = positionService;
	}
	
	@GetMapping("/getAll")
	public List<JobPosition> getAll() {
		return jobPositionService.getAll();
	}
	
}
