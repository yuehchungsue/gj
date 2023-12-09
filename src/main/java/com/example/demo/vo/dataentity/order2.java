package com.example.demo.vo.dataentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="order2")
// @TableName("`order2`")
public class order2 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Integer a;
	private Integer b;
	private Integer c;
	
	/**
	 * order2
	 */
	public order2() {
		super();
	}
	
	/**
	 * @param name
	 * @param a
	 * @param b
	 * @param c
	 */
	public order2(String name, Integer a, Integer b, Integer c) {
		super();
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	public Integer getC() {
		return c;
	}

	public void setC(Integer c) {
		this.c = c;
	}

//	public Integer getSum() {
//		return sum;
//	}
//
//	public void setSum(Integer sum) {
//		this.sum = sum;
//	}

	
}

