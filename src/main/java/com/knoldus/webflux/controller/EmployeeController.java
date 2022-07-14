package com.knoldus.webflux.controller;

import com.knoldus.webflux.repository.EmployeeRepository;
import com.knoldus.webflux.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
     Mono<Employee> createEmployee(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

    @GetMapping("/getEmployees")
    Flux<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PutMapping("/updateEmployee/{id}")
    private Mono<Employee> updateEmployee(@PathVariable("id") Long id,
                                  @RequestBody Employee emp) {
        return employeeRepository.findById(id).flatMap(emp1 -> {
            emp.setId(id);
            return employeeRepository.save(emp);
        }).switchIfEmpty(Mono.empty());
    }

    @DeleteMapping("/deleteEmployee/{id}")
    Mono<Void> deleteById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id).flatMap(p ->
                employeeRepository.deleteById(p.getId()));
    }
}
