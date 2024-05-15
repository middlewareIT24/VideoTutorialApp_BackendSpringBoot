package com.app.videoTutorial.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.videoTutorial.model.Instructors;
import com.app.videoTutorial.model.ResponseInfo;
import com.app.videoTutorial.services.InstructorsService;

@RestController
@RequestMapping("instructors")
public class InstructorsController {
	@Autowired
	InstructorsService instructorsService;

	@GetMapping("all")
	public ResponseInfo<List<Instructors>> getAllMethod() {
		return instructorsService.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<Instructors>> getMethod(@PathVariable Integer id) {
		return instructorsService.getInfo(id);
	}

	@PostMapping("add")
	public ResponseInfo<String> postMethod(@RequestBody Instructors instructorsCrud) {
		return instructorsService.saveInfo(instructorsCrud);
	}

	@DeleteMapping("delete/{id}")
	public ResponseInfo<String> deleteMethod(@PathVariable Integer id) {
		return instructorsService.deleteInfo(id);
	}

	@DeleteMapping("delete/all")
	public ResponseInfo<String> deleteAllMethod() {
		return instructorsService.deleteAllInfos();
	}

	@PutMapping("update")
	public ResponseInfo<String> updateMethod(@RequestBody Instructors instructorsCrud) {
		return instructorsService.updateInfo(instructorsCrud);
	}

}
