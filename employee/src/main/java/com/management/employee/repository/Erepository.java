package com.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.employee.model.Employee;

@Repository
public interface Erepository extends JpaRepository<Employee,String>{

}
