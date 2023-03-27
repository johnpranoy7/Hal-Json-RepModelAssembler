package com.john.graphite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.john.graphite.model.Student;

@Service
public class StudentService {

	public List<Student> getAllStudents() {
		List<Student> res = new ArrayList<>();
		Student s1 = new Student("John", 2);
		Student s2 = new Student("John", 2);
		res.add(s1);
		res.add(s2);
		return res;
	}
}
