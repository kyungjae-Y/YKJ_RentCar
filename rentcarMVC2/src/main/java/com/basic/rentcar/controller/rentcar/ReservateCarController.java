package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.JoinCarView;

public class ReservateCarController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RentCarDAO rdao = RentCarDAO.getInstance();
		HttpSession session = request.getSession();
		ArrayList<JoinCarView> list = rdao.getAllReserve((String) session.getAttribute("id"));
		session.setAttribute("list", list);
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		return "main";
	}
}