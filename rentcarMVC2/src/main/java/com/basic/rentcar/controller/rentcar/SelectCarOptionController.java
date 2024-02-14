package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontController.Controller;

public class SelectCarOptionController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		String img = request.getParameter("img");
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		request.setAttribute("no", no);
		request.setAttribute("qty", qty);
		request.setAttribute("img", img);
		return "main";
	}
}