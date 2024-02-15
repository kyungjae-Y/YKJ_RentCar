package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.MemberDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.User;

public class JoinUserController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		String job = request.getParameter("job");
		String age = request.getParameter("age");
		String info = request.getParameter("info");
		System.out.println(id);
		User vo = null;
		vo = new User(id, pw, email, tel, hobby, job, age, info);
		String ctx = request.getContextPath();
		int cnt = MemberDAO.getInstance().userInsert(vo);
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		if (cnt > 0) {
			return "redirect:" + ctx + "/main.do";
		} else {
			throw new ServletException("not add");
		}
	}
}