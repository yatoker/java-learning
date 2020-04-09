package com.amadeus.epwr.controller;

import com.amadeus.epwr.exception.DuplicateCheckException;
import com.amadeus.epwr.model.Employee;
import com.amadeus.epwr.model.ErrorDetails;
import com.amadeus.epwr.service.validator.EmployeeValidator;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/employees", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EmployeeController {

    @Autowired
    EmployeeValidator ev;

    @GetMapping
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1L, "Name", "Surname", "abc@go.com"));
        list.add(new Employee(2L, "Name2", "Surname2", "absdadc@go.com"));

        return list;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Employee newEmployee){
        List<String> errorList = ev.validate(newEmployee);


        if (!errorList.isEmpty()) {
            return new ResponseEntity<Object>(new ErrorDetails("BAD_REQUEST", errorList), HttpStatus.BAD_REQUEST);
        }

        if ("a@a.com".equals(newEmployee.getEmail())) {
            throw new DuplicateCheckException("Employee email " + newEmployee.getEmail() + " already exists");
        }

        if ("b@b.com".equals(newEmployee.getEmail())) {
           int a = 5 / 0;
        }

        return new ResponseEntity<Object>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable Long id) {
        return new Employee(id + 6, "Name", "LastName", "adsa@asa.com");
    }

    @PutMapping("/{id}")
    Employee putById(@PathVariable Long id) {
        return new Employee(id + 6, "Name", "LastName", "adsa@asa.com");
    }





}
