package com.emp.service;

import java.util.List;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.Employee;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDto);
	
	EmployeeDTO getEmployeeById(Long id);
	
	List<EmployeeDTO> getAllEmployee();
	
	EmployeeDTO updateEmployee(Long id,EmployeeDTO empDto);
	
	void deleteById(Long id);
}
