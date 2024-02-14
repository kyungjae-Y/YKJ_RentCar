package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;

public class CarInfoController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		RentCarDAO rdao = RentCarDAO.getInstance();
		Rentcar rc = rdao.getOneCar(no);
		request.setAttribute("vo", rc);
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		int category = rc.getCategory();
		String temp = "";
		if (category == 1)
			temp = "소형";
		else if (category == 2)
			temp = "중형";
		else if (category == 3)
			temp = "대형";
		request.setAttribute("temp", temp);
		return "main";
	}
}