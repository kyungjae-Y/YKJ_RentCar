package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.basic.rentcar.dao.MemberDAO;
import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;

public class LoginCheckController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String ctx = request.getContextPath();
		//		if (!MemberDAO.getInstance().checkLogin(id, pw)) {
		//			return "redirect:" + ctx + "/main.do?center=user/login.jsp";
		//		} else {
		//			HttpSession session = request.getSession();
		//			session.setAttribute("id", MemberDAO.getInstance().getUserNo(id));
		//			return "redirect:" + ctx + "/main.do";
		//		}
		int check = RentCarDAO.getInstance().getUser(id, pw);
		if (check == 0) {
			return "redirect:" + ctx + "/main.do?center=user/login.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			return "main";
		}
	}
}