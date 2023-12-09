package com.example.demo.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.dataentity.product;

@Mapper
public interface productMapper {
	/** create :  by product*/
	@Insert("insert into product(String productno, String productname, Integer price) "
			+ "values(#{productno},#{productname},#{price})")
	void add(product m);
	
	/** query :  by id or name*/
	@Select("select * from product where productno=#{productno} and productname=#{productname}")
	product query(String productno, String productname);
	
	@Select("select * from product where productno=#{productno}")
	product queryByProductno(String productno);

	@Select("select * from product where productname=#{productname}")
	product queryByProductname(String productname);
	
	@Select("select * from product where productname=#{productname}")
	product queryByName(String productname);
	
	@Select("select * from product where price=#{price}")
	product queryByPrice(Integer price);
	
	@Select("select * from product where id=#{id}")
	product queryById(Integer id);
	
	/** query :  all*/
	@Select("select * from product")
	List queryAll();
	
	//update
	@Update("update product set productno=#{productno},productname=#{productname},price=#{price} where id=#{id}")
	void update(product m);
	
	/** delete :  by id*/
	@Delete("delete from product where id=#{id}")
	void delete(int id);
	
	@Delete("delete from product where id=#{id}")
	void deleteById(Integer id);
}
