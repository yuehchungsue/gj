package com.example.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.dataentity.order2;


@Mapper
public interface order2Mapper {

	/** create :  by order2*/
	@Insert("insert into order2(name,a,b,c) values(#{name},#{a},#{b},#{c})")
	void add(order2 m);
	
	/** query :  by id or name, a*/
	@Select("select * from order2 where id=#{id} and name=#{name} and a=#{a}")
	order2 queryByIdAndNameAndA(int id, String name, int a);
	
	/** query :  by id or name, a, b*/
	@Select("select * from order2 where id=#{id} and name=#{name} and a=#{a} and b=#{b}")
	order2 queryByIdAndNameAndAAndB(int id, String name, int a, int b);

	/** query :  by id or name, a, b, c*/
	@Select("select * from order2 where id=#{id} and name=#{name} and a=#{a} and b=#{b} and c=#{c}")
	order2 queryByIdAndNameAndAAndBAndC(int id, String name, int a, int b, int c);
	
	@Select("select * from order2 where id=#{id}")
	order2 queryById(Integer id);
	
	/** query :  all*/
	@Select("select * from order2")
	List queryAll();
	
	/** query :  all*/
	@Select("select * from order2")
	List selectAll();	
	
	//** update :  all*/
	@Update("update order2 set name=#{name}, a=#{a}, b=#{b}, c=#{c} where id=#{id}")
	void update(order2 m);
	
	/** delete :  by id*/
	@Delete("delete from order2 where id=#{id}")
	void delete(int id);
	
	@Delete("delete from order2 where id=#{id}")
	void deleteById(Integer id);
}
