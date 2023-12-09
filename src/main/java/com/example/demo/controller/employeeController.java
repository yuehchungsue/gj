package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.mapper.employeeMapper;
import com.example.demo.vo.dataentity.employee;

import jakarta.servlet.http.HttpSession;

//@RestController

@Controller
@RequestMapping("employee")
public class employeeController {
	
	@Autowired
	private employeeMapper employeemapper;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("Employee")
	public String login()
	{
		return "/employee/Employ";
	}
	
	
	@RequestMapping("login")
	public String login(String username,String password)
	{
		employee e=employeemapper.queryUser(username, password);
		if(e!=null)
		{
			if(e.getType()==1)
			{
				return "/employee/manager/manager";
			}
			else
			{
				return "/employee/employee/employee";
			}
			
			
		}
		else
		{
			return "/employee/loginError";
		}
	}
	
	@RequestMapping("addEmployee")
	public void add(String employeeno, String name, String username, String password, Integer type)
	{
		employee m=new employee(employeeno, name, username, password, type);
		employeemapper.add(m);
	}
	
	@RequestMapping("queryEmployee")
	//@RequestMapping(value="queryUser", produces="application/json")
	public employee query(String employeeno, String username)
	{
		return employeemapper.query(employeeno, username);
	}
	
	@RequestMapping("queryEmployeeAll")
	public List<employee> queryAll()
	{
		return employeemapper.queryAll();
	}
	
	@RequestMapping("queryEmployeeById")
	public employee queryId(int id)
	{
		return employeemapper.queryById(id);
	}
	
	@RequestMapping("updatEemployee")
	public void update(employee m)
	{
		employeemapper.update(m);
	}
	
	@RequestMapping("deletEemployee")
	public void deleteByid(int id)
	{
		employeemapper.delete(id);
	}
}
