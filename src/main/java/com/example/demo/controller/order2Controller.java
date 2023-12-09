package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.mapper.order2Mapper;
import com.example.demo.vo.dataentity.member;
import com.example.demo.vo.dataentity.order2;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//@RestController

@Controller
@RequestMapping("order2")
public class order2Controller {
	@Autowired
	private order2Mapper order2mapper;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("/order2")
	public ModelAndView gotoThis()
	{
		return new ModelAndView("/order2/order2");
	}
	
	@RequestMapping("/confirm")
	public ModelAndView gotoConfirm()
	{
		return new ModelAndView("/order2/confirm");
	}
	
	@RequestMapping("/finish")
	public ModelAndView gotoFinish()
	{
		/*
		 * 1.擷取session-->order2
		 * 2.ps-->add
		 * 3.切換-->finish頁
		 * 
		 */
		order2 order2=(order2) session.getAttribute("order2");		
		order2mapper.add(order2);
		
		
		return new ModelAndView("/order2/finish");
	}
	
	@RequestMapping("/add")
	public ModelAndView add(int a, int b, int c) {
		member member = (member) session.getAttribute("member");
		order2 order2 = new order2(member.getName(), a, b, c);
		session.setAttribute("order2", order2);
		
		return new ModelAndView("/order2/confirm");
	}
	
	@GetMapping("/logout")
	public void logout() {
		session.removeAttribute("member");
		session.removeAttribute("order2");
		try {
			response.sendRedirect("/index4.html");
			//response.sendRedirect("http://localhost:8080/login3.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
