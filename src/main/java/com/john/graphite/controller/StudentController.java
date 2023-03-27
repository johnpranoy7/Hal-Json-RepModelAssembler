package com.john.graphite.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.john.graphite.StudentAssembler;
import com.john.graphite.model.Student;
import com.john.graphite.model.StudentModel;
import com.john.graphite.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentAssembler studentAssembler;

	@GetMapping(path = "/my-objects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Student> getMyObject(@PathVariable Long id) {
		Student myObject = new Student("John", 0);

		return studentAssembler.toModel(myObject);
	}

	@GetMapping(path = "/my-objects", produces = MediaType.APPLICATION_JSON_VALUE)
	public CollectionModel<EntityModel<Student>> getMyObjects() {
		List<Student> myObjects = studentService.getAllStudents();

		List<EntityModel<Student>> myObjectModels = myObjects.stream().map(studentAssembler::toModel)
				.collect(Collectors.toList());

		CollectionModel<EntityModel<Student>> collectionModel = CollectionModel.of(myObjectModels);

		collectionModel.add(Link.of("/api/my-objects").withSelfRel());

		return collectionModel;
	}

	@GetMapping(path = "/lolv2", produces = { MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE })
	public ResponseEntity<?> getMyObjectsV2() {
		List<Student> myObjects = studentService.getAllStudents();

		List<StudentModel> myObjectModels = myObjects.stream().map(StudentModel::new).collect(Collectors.toList());

		CollectionModel<StudentModel> studentResources = CollectionModel.of(myObjectModels);
		studentResources.add(linkTo(methodOn(StudentController.class).getMyObjectsV2()).withSelfRel());
		return ResponseEntity.ok(studentResources);

	}

	@GetMapping(path = "/lolv3", produces = { MediaType.APPLICATION_JSON_VALUE, MediaTypes.HAL_JSON_VALUE })
	public ResponseEntity<?> getMyObjectsV3(@RequestHeader(value = "Accept") String accept) {
		List<Student> myObjects = studentService.getAllStudents();

//		List<EntityModel<Student>> studentsModel = myObjects.stream().map(i -> studentAssembler.toModel(i,true)).collect(Collectors.toList());
//		if (accept != null && accept.contains("hal")) {
//			CollectionModel<EntityModel<Student>> studentResources = CollectionModel.of(studentsModel);
//			studentResources.add(linkTo(methodOn(StudentController.class).getMyObjectsV3(null)).withSelfRel());
//			return ResponseEntity.ok(studentResources);
//		} else {
//			return ResponseEntity.ok(myObjects);
//		}

		boolean showLinks = accept != null && accept.contains("hal") ? true : false;
		List<EntityModel<Student>> studentsModel = myObjects.stream().map(i -> studentAssembler.toModel(i, showLinks))
				.collect(Collectors.toList());
		CollectionModel<EntityModel<Student>> studentResources = CollectionModel.of(studentsModel);
		studentResources.add(linkTo(methodOn(StudentController.class).getMyObjectsV3(null)).withSelfRel());
		return ResponseEntity.ok(studentResources);

	}

}
