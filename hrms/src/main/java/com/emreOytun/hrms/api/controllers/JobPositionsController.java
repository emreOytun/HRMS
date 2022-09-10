package com.emreOytun.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.JobPositionService;
import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService positionService) {
		super();
		this.jobPositionService = positionService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosition>> getAll() {
		return jobPositionService.getAll();
	}
	
}
