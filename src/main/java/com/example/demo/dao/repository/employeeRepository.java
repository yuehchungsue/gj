package com.example.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.dataentity.employee;

public interface employeeRepository extends JpaRepository<employee,Integer> {

}
