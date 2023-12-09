package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.repository.memberRepository;
import com.example.demo.vo.dataentity.member;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class member3Controller {
	@Autowired
	memberRepository mr;
	@Autowired
	HttpSession session;

	@GetMapping("queryAll")
	public List<member> queryAll() {
		return mr.findAll();
	}

	@PostMapping("queryid")
	public member queryId(int id) {
		return mr.findById(id);
	}

	@PostMapping("queryMemberno")
	public member queryMemberno(String memberno) {
		return mr.findByMemberno(memberno);
	}

	@RequestMapping("login3")
	public ModelAndView gotLogin() {

		ModelAndView mav = null;

		mav = new ModelAndView("/loginSuccess3");

		return mav;
	}

	@PostMapping("login3")
	public ModelAndView gotLogin(String username, String password) {

		member m = mr.queryMember2(username, password);

		ModelAndView mav = null;

		if (m != null) {
			session.setAttribute("member", m);
			mav = new ModelAndView("/loginSuccess3");
		} else {
			mav = new ModelAndView("/loginError3");
		}

		return mav;
	}

	@GetMapping("addMember")
	public ModelAndView gotoAddmember() {
		ModelAndView mav = new ModelAndView("/member/addMember");
		return mav;
	}

	@PostMapping("add")
	public ModelAndView add(String memberno, String name, String username, String password, String email) {
		member m = mr.findByUsername(username);
		ModelAndView mav = null;
		if (m != null) {
			mav = new ModelAndView("/member/addMemberError");

		} else {
			member m2 = new member(memberno, name, username, password, email);

			mr.save(m2);
			mav = new ModelAndView("/member/addMemberSuccess");
		}

		return mav;
	}

}