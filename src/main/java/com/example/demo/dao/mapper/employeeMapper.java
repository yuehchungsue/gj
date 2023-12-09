package com.example.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.dataentity.employee;

@Mapper
public interface employeeMapper {

	/** create :  by employee*/
	@Insert("insert into Employee(String employeeno, String name, String username, String password, Integer type) "
			+ "values(#{employeeno},#{name},#{username},#{password},#{type})")
	void add(employee m);
	
	/** query :  by id*/
	@Select("select * from Employee where employeeno=#{employeeno} and username=#{username}")
	employee query(String employeeno, String username);
	
	@Select("select * from Employee where employeeno=#{employeeno}")
	employee queryByEmployeeno(String employeeno);

	@Select("select * from Employee where username=#{username}")
	employee queryByUsername(String username);

	@Select("select * from Employee where username=#{username} and password=#{password}")
	employee queryUser(String username, String password);	
	
	@Select("select * from Employee where id=#{id}")
	employee queryById(Integer id);
	
	@Select("select * from Employee where name=#{name}")
	employee queryByName(String name);
	
	/** query :  all*/
	@Select("select * from Employee")
	List queryAll();
	
	//update
	@Update("update Employee set employeeno=#{employeeno},name=#{name},username=#{username},password=#{password},type=#{type} where id=#{id}")
	void update(employee m);
	
	/** delete :  by id*/
	@Delete("delete from Employee where id=#{id}")
	void delete(int id);
	
	@Delete("delete from Employee where id=#{id}")
	void deleteById(Integer id);
}
