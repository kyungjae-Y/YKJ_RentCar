package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;

public class DeleteResController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resSeq = Integer.parseInt(request.getParameter("resSeq"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int no = Integer.parseInt(request.getParameter("no"));
		RentCarDAO rdao = RentCarDAO.getInstance();
		rdao.carRemoveReserve(resSeq, qty, no);

		String center = request.getParameter("center");
		request.setAttribute("center", center);

		response.sendRedirect("reservateCarView.do?center=rentcar/reserveCarView.jsp");
		return null;
	}
}