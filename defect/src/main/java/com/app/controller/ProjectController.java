package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Project;
import com.app.repository.ProjectRepository;


@RestController
public class ProjectController {

	
	@Autowired
	ProjectRepository projectRepository;
	
	@PostMapping(value="/project")
	public ResponseEntity<?> saveProject(@RequestBody Project project){
		projectRepository.save(project);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value="/project")
	public List<Project> getProject(){
		return projectRepository.findAll();
	}
}
