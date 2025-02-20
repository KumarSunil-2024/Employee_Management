package com.emp.mapper;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
		return new EmployeeDTO(
				employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
	}
	
	public static Employee mapToEmployee(EmployeeDTO employeeDto) {
		return new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail());
	}
}
