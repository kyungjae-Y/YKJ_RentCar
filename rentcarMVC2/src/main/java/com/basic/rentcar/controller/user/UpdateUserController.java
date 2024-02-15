package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.MemberDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.User;

public class UpdateUserController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("pw") == null) {
			return "main";
		}
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		String job = request.getParameter("job");
		String age = request.getParameter("age");
		String info = request.getParameter("info");
		User vo = new User();
		vo.setId(id);
		vo.setPw(pw);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setHobby(hobby);
		vo.setJob(job);
		vo.setAge(age);
		vo.setInfo(info);
		String ctx = request.getContextPath();
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		int cnt = MemberDAO.getInstance().userUpdate(vo);
		if (cnt > 0) {
			return "redirect:" + ctx + "/main.do";
		} else {
			throw new ServletException("not update");
		}
	}
}