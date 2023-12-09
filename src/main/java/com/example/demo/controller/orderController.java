package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.mapper.orderMapper;
import com.example.demo.vo.dataentity.member;
import com.example.demo.vo.dataentity.order1;

import jakarta.servlet.http.HttpSession;


//@RestController

@Controller
@RequestMapping("order")
public class orderController {
	@Autowired
	private orderMapper ordermapper;
	
	@Autowired
	private HttpSession session;
	
//	@RequestMapping("addOrder")
//	public void add(String deskno,String memberno, String ordertime)
//	{
//		/*
//		 * 1 ordertime-->String
//		 * 2.String 轉 java.util.Date
//		 * 3.java.util.Date-->java.sql.Date
//		 */		
//		//java.sql.Date d=new java.sql.Date(new java.util.Date(ordertime).getTime()); //java.lang.reflect.InvocationTargetException
//		long millis=System.currentTimeMillis();  
//		java.sql.Date d = new Date(millis);
//		order1 m=new order1(deskno, memberno, d);
//		ordermapper.add(m);
//	}
	

	
	@RequestMapping("order")
	public String gettoPorder()
	{
		return "/order/order";
	}
	
	@RequestMapping("confirm")
	public String gotoConfirm(String deskno,Date ordertime)
	{
		/*
		 * 1.new porder()-->p
		 * 2.session-->p
		 * 3.confirm
		 */
		System.out.println(deskno+"\t"+ordertime);
		
		member m=(member) session.getAttribute("M");
		
		order1 p= new order1(deskno, m.getMemberno(), ordertime);
		
		session.setAttribute("P", p);
		return "/order/confirm";
	}
	
	@RequestMapping("finish")
	public String gotoFinish()
	{
		/*
		 * 1.擷取-->session-->p
		 * 2.add-->資料庫
		 * 3.切換到-->finish.jsp
		 * 
		 */
		order1 p=(order1) session.getAttribute("P");
		System.out.println("p:"+p);
		
		ordermapper.add(p);
		
		return "/order/finish";
	}
	
	@RequestMapping("logout")
	public String gotoLogout() {
		
		session.removeAttribute("M");
		session.removeAttribute("P");
		
		return "/order/logout";
	}
	
	
	@RequestMapping("addOrder")
	public void add(String deskno,String memberno, Date ordertime)
	{
		order1 m=new order1(deskno, memberno, ordertime);
		ordermapper.add(m);
	}	
	
	@RequestMapping("queryOrder")
	//@RequestMapping(value="queryUser", produces="application/json")
	public order1 query(String orderno, String memberno, Date ordername)
	{
		return ordermapper.query(orderno, memberno, ordername);
	}
	
	@RequestMapping("queryOrderAll")
	public List<order1> queryAll()
	{
		return ordermapper.queryAll();
	}
	
	@RequestMapping("queryPorderById")
	public order1 queryId(int id)
	{
		return ordermapper.queryById(id);
	}
	
	@RequestMapping("updatOrder")
	public void update(order1 m)
	{
		ordermapper.update(m);
	}
	
	@RequestMapping("deletOrder")
	public void deleteByid(int id)
	{
		ordermapper.delete(id);
	}
}
