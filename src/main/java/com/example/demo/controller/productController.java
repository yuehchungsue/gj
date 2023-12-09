package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.mapper.productMapper;
import com.example.demo.vo.dataentity.product;

//@RestController

@Controller
@RequestMapping("product")
public class productController {
	@Autowired
	private productMapper productmapper;
	
	@RequestMapping("addProduct")
	public void add(String productno, String productname, Integer price)
	{
		product m=new product(productno, productname, price);
		productmapper.add(m);
	}
	
	@RequestMapping("queryProduct")
	//@RequestMapping(value="queryUser", produces="application/json")
	public product query(String productno, String productname)
	{
		return productmapper.query(productno, productname);
	}
	
	@RequestMapping("queryProductAll")
	public List<product> queryAll()
	{
		return productmapper.queryAll();
	}
	
	@RequestMapping("queryPproductById")
	public product queryId(int id)
	{
		return productmapper.queryById(id);
	}
	
	@RequestMapping("updatProduct")
	public void update(product m)
	{
		productmapper.update(m);
	}
	
	@RequestMapping("deletEProduct")
	public void deleteByid(int id)
	{
		productmapper.delete(id);
	}
}
