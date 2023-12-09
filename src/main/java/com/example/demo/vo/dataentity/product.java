package com.example.demo.vo.dataentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String productno;
	private String productname;
	private int price;
	
	/**
	 * @param id
	 * @param productno
	 * @param productname
	 * @param price
	 */
	public product(int id, String productno, String productname, Integer price) {
		super();
		this.id = id;
		this.productno = productno;
		this.productname = productname;
		this.price = price;
	}
	/**
	 * @param productno
	 * @param productname
	 * @param price
	 */
	public product(String productno, String productname, Integer price) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.price = price;
	}	
}
