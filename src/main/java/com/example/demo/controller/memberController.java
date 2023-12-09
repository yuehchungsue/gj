package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.mapper.memberMapper;
import com.example.demo.vo.dataentity.member;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@RestController

@Controller
@RequestMapping("member")
public class memberController {
	
	@Autowired
	private memberMapper membermapper;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("prelogin")
	public String prelogin()
	{
		return "/member/login";
	}
	
	@RequestMapping("login")
	public String login(String username,String password)
	{
		member m=membermapper.query(username, password);
		if(m!=null)
		{
			session.setAttribute("M", m);
			return "/loginSuccess";
		}
		else
		{
			return "/loginError";
		}
	}
	@RequestMapping("loginApi")
	public String loginApi(String username,String password)
	{
		member m=membermapper.query(username, password);
		if(m!=null)
		{
			session.setAttribute("M", m);
			return "/loginSuccessApi";
		}
		else
		{
			return "/loginError";
		}
	}
	
	@RequestMapping("login2")
	public String login2(String username,String password)
	{
		return "/member/login";
	}	
	
	@RequestMapping("reAddMember")
	public String readd(String memberno,String name,String username,String password,String email)
	{
		return "member/addMember";		
	}
	
	@RequestMapping("addMember")
	public void add(String memberno,String name,String username,String password,String email)
	{
		member m=new member(memberno,name,username,password,email);
		membermapper.add(m);
		try {
			response.sendRedirect("login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("addMember_html")
	public void add_html(String memberno,String name,String username,String password,String email)
	{
		member m=new member(memberno,name,username,password,email);
		membermapper.add(m);
		try {
			response.sendRedirect("login.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@RequestMapping("queryUser")
	//@RequestMapping(value="queryUser", produces="application/json")
	public member query(String username,String password)
	{
		
		return membermapper.query(username, password);
	}
	
	@RequestMapping("login_html")
	public void login_html(String username,String password)
	{
		/*
		 * 1.判斷帳號密碼
		 * 2!=null-->true-->登入-->porder.html
		 * 3.false-->註冊-->addMember.html
		 */
		member m=query(username, password);
		try {
		if(m!=null)
		{
			response.sendRedirect("order.html");
		}
		else
		{
			response.sendRedirect("addMember.html");
		}
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	@RequestMapping("queryMemberAll")
	public List<member> queryAll()
	{
		return membermapper.queryAll();
	}
	
	@RequestMapping("queryMemberById")
	public member queryId(int id)
	{
		return membermapper.queryById(id);
	}
	
	@RequestMapping("updateMember")
	public void update(member m)
	{
		membermapper.update(m);
	}
	
	@RequestMapping("deleteMember")
	public void deleteByid(int id)
	{
		membermapper.delete(id);
	}	
}