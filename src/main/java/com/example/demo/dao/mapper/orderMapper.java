package com.example.demo.dao.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.dataentity.order1;


@Mapper
public interface orderMapper {

	/** create :  by order1*/
	@Insert("insert into order1(deskno,memberno,ordertime) values(#{deskno},#{memberno},#{ordertime})")
	void add(order1 m);
	
	/** query :  by id or name*/
	@Select("select * from order1 where deskno=#{deskno} and memberno=#{memberno} and ordertime=#{ordertime}")
	order1 query(String deskno, String memberno, Date ordertime);
	
	@Select("select * from order1 where deskno=#{deskno}")
	order1 queryByDeskno(String deskno);

	@Select("select * from order1 where ordertime=#{ordertime}")
	order1 queryByordertime(String ordertime);

	@Select("select * from order1 where id=#{id}")
	order1 queryById(Integer id);
	
	/** query :  all*/
	@Select("select * from order1")
	List queryAll();
	
	//update
	@Update("update order1 set deskno=#{deskno},ordertime=#{ordertime} where id=#{id}")
	void update(order1 m);
	
	/** delete :  by id*/
	@Delete("delete from order1 where id=#{id}")
	void delete(int id);
	
	@Delete("delete from order1 where id=#{id}")
	void deleteById(Integer id);
}
