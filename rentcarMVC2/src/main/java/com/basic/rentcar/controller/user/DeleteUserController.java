package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.MemberDAO;
import com.basic.rentcar.frontController.Controller;

public class DeleteUserController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		int cnt = MemberDAO.getInstance().userDelete(request.getParameter("id"));
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		if (cnt > 0) {
			return "redirect:" + ctx + "/main.do";
		} else {
			throw new ServletException("not delete");
		}
	}
}