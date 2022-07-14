package com.knoldus.webflux.repository;

import com.knoldus.webflux.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
}
