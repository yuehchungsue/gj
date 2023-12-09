package com.example.demo.vo.dataentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="member")
public class member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String memberno;
	private String name;
	private String username;
	private String password;
	private String email;
	
	/**
	 * default
	 */
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param memberno
	 * @param name
	 * @param username
	 * @param password
	 * @param email
	 */
	public member(Integer id, String memberno, String name, String username, String password, String email) {
		super();
		this.id = id;
		this.memberno = memberno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}	
	
	/**
	 * @param memberno
	 * @param name
	 * @param username
	 * @param password
	 * @param email
	 */
	public member(String memberno, String name, String username, String password, String email) {
		super();
		this.memberno = memberno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
