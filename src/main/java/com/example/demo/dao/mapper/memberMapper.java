package com.example.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.dataentity.member;

@Mapper
public interface memberMapper {
	
	/** create :  by menber*/
	@Insert("insert into member(memberno,name,username,password,email) "
			+ "values(#{memberno},#{name},#{username},#{password},#{email})")
	void add(member m);
	
	/** query :  by id*/
	@Select("select * from member where username=#{username} and password=#{password}")
	member query(String username,String password);
	
	@Select("select * from member where id=#{id}")
	member queryById(Integer id);
	
	@Select("")
	member queryByName(String username);
	
	/** query :  all*/
	@Select("select * from member")
	List<member> queryAll();
	
	//update
	@Update("update member set name=#{name},password=#{password},email=#{email} where id=#{id}")
	void update(member m);
	
	/** delete :  by id*/
	@Delete("delete from member where id=#{id}")
	void delete(int id);
	
	@Delete("delete from member where id=#{id}")
	void deleteById(Integer id);
}
