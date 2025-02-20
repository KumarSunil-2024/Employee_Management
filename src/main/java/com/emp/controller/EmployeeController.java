package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.EmployeeDTO;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDto) {
	    EmployeeDTO empDto = empService.createEmployee(employeeDto);
	    return new ResponseEntity<>(empDto, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id){
		EmployeeDTO empDto=empService.getEmployeeById(id);
		return ResponseEntity.ok(empDto);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
		List<EmployeeDTO> empList=empService.getAllEmployee();
		return ResponseEntity.ok(empList);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> updateById(@PathVariable("id") Long id,@RequestBody EmployeeDTO empDto){
		
		EmployeeDTO empDt=empService.updateEmployee(id, empDto);
		
		return  ResponseEntity.ok(empDt);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
	empService.deleteById(id);
	return ResponseEntity.ok("delete Successfully");
	}
}
