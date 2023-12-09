package com.example.demo.vo.dataentity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="order1")
// @TableName("`order1`")
public class order1 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String deskno;
	private String memberno;
	private Date ordertime;
	
	/**
	 * @param id
	 * @param deskno
	 * @param ordertime
	 */
	public order1(Integer id, String deskno,String memberno, Date ordertime) {
		super();
		this.id = id;
		this.deskno = deskno;
		this.memberno = memberno;
		this.ordertime = ordertime;
	}
	
	/**
	 * @param deskno
	 * @param ordertime
	 */
	public order1(String deskno,String memberno, Date ordertime) {
		super();
		this.deskno = deskno;
		this.memberno = memberno;
		this.ordertime = ordertime;
	}

	public String getDeskno() {
		return deskno;
	}

	public void setDeskno(String deskno) {
		this.deskno = deskno;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}	
	
}

