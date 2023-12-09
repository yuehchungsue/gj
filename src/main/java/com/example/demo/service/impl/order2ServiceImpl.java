package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.mapper.order2Mapper;
import com.example.demo.service.order2Service;
import com.example.demo.vo.dataentity.order2;

@Service
public class order2ServiceImpl implements order2Service {
	@Autowired
	order2Mapper pm;
	

	@Override
	public List<order2> findAll() {
		
		return pm.selectAll();
	}

	@Override
	public void addPorder2(order2 p) {
		pm.add(p);
		
	}
}
