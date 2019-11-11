package com.example.employee.controller;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author apa
 */
@Controller
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

     @Autowired
     ModelMapper modelMapper;

    @GetMapping(value = "/employees", produces = "application/json")
    public @ResponseBody List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PutMapping(value = "/employee")
    public @ResponseBody Employee addEmployee(@RequestBody EmployeeDto newEmployeeDto) {

        Employee newEmployee = modelMapper.map(newEmployeeDto, Employee.class);
        return employeeRepository.save(newEmployee);
    }

    @DeleteMapping(value = "/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void removeEmployee(@PathVariable long id) {
        employeeRepository.deleteById(id);
        logger.info("Employee with id " + id + " has been removed");
    }
}
