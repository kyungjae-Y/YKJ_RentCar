package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.MemberDAO;
import com.basic.rentcar.frontController.Controller;

public class ValidateIdController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = MemberDAO.getInstance().isValidId(id) ? "not Valid" : "valid";
		response.getWriter().print(pw);
		return null;
	}
}