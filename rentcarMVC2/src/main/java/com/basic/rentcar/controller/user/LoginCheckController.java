package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class LoginCheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (request.getParameter("id") == null) {
			return "userLogin";
		}
		String pw = request.getParameter("pw");
		String ctx = request.getContextPath();
		if (!UserDAO.getInstance().checkLogin(id, pw)) {
			return "redirect:" + ctx + "/userLogin.do";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("log", UserDAO.getInstance().getUserNo(id));
			return "redirect:" + ctx + "/userList.do";
		}
	}
}