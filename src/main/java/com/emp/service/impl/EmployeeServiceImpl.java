package com.emp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.Employee;
import com.emp.exception.ResourceNotFoundException;
import com.emp.mapper.EmployeeMapper;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee emp=employeeRepo.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(emp);
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found "+id));
		return EmployeeMapper.mapToEmployeeDTO(emp);
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> empList=employeeRepo.findAll();
		return empList.stream()
	              .map(emp -> EmployeeMapper.mapToEmployeeDTO(emp)) 
	              .collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(Long id, EmployeeDTO empDto) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not exist "+id));
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
	    emp.setEmail(empDto.getEmail());
	    employeeRepo.save(emp);
		return EmployeeMapper.mapToEmployeeDTO(emp);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not exit "+id));
		employeeRepo.deleteById(id);	
	}
	

}
