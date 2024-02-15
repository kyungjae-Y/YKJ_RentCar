package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.MemberDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.User;

public class UserInfoController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("id");
		User vo = MemberDAO.getInstance().userInfo(id);
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		request.setAttribute("vo", vo);
		return "main";
	}
}