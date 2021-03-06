package com.exaple.springboot.swagger.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exaple.springboot.swagger.bean.Student;
import com.exaple.springboot.swagger.config.RecordNotFoundException;
import com.exaple.springboot.swagger.config.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value = "api", description = "Rest API for Student Details", tags = "Student API")
public class StudentDetailsController {

	List<Student> studentList = new ArrayList<>();

	{
		studentList.add(new Student("Mark", 36789, "878 - 345 - 1234"));
		studentList.add(new Student("Lara", 32145, "234 - 345 - 1234"));
		studentList.add(new Student("Stonis", 67890, "567 - 345 - 1234"));
		studentList.add(new Student("Boom", 12345, "765 - 345 - 1234"));
		studentList.add(new Student("Stonis", 65323, "123 - 345 - 1234"));
	}

	@GetMapping("/details/{name}")
	@ApiOperation(value = "Dispaly the Student Details based on Given Name", response = Student.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK Developer. You are awesome"),
			@ApiResponse(code = 404, message = "Oops. The resource not found") })
	public List<Student> getStudentDetails(@PathVariable("name") String name) throws RecordNotFoundException {
		System.out.println(name);
		List<Student> list = studentList.stream().filter(s -> s.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		System.out.println(list);
		if (list == null || list.size() == 0) {
			throw new RecordNotFoundException("Student REcord Not Found");
		}
		return list;
	}

	@GetMapping("/testexception")
	@ApiOperation(value = "Testing Exception")
	public void testException() throws ResourceNotFoundException {
		throw new ResourceNotFoundException("Test : Exceptions thrown");
	}

	@PostMapping("/addDetails")
	@ResponseStatus(value = HttpStatus.CREATED, reason = "Student Entry Created")
	@ApiOperation(value = "Add Student Details based on Given Details", response = Student.class)
	public List<Student> addStudentDetails(@RequestBody List<Student> studList) {
		studentList.addAll(studList);
		return studentList;
	}

}
