package com.example.demo.vo.dataentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String employeeno;
	private String name;
	private String username;
	private String password;
	private int type;
	
	/**
	 * @param id
	 * @param employeeno
	 * @param name
	 * @param username
	 * @param password
	 * @param type
	 */
	public employee(Integer id, String employeeno, String name, String username, String password, int type) {
		super();
		this.id = id;
		this.employeeno = employeeno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	/**
	 * @param employeeno
	 * @param name
	 * @param username
	 * @param password
	 * @param type
	 */
	public employee(String employeeno, String name, String username, String password, int type) {
		super();
		this.employeeno = employeeno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public String getEmployeeno() {
		return employeeno;
	}

	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}	
}
