package com.example.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.dataentity.product;

public interface productRepository extends JpaRepository<product,Integer> {

}
