package com.john.graphite.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

import com.john.graphite.controller.StudentController;

public class StudentModel extends RepresentationModel<StudentModel> {

	private Student student;

	public StudentModel(Student student) {
		this.student = student;
		EntityModel<StudentModel> studentModel = EntityModel.of(this);
		studentModel.add(linkTo(methodOn(StudentController.class).getMyObject(Long.valueOf(this.getStudent().getId())))
				.withSelfRel());
		studentModel.add(linkTo(methodOn(StudentController.class).getMyObjectsV2()).withRel("students"));
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
