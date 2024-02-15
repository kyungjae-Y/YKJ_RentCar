package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;
import com.basic.rentcar.vo.Reservation;

public class ReservateCarResultController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date d1 = new Date();
		Date d2 = new Date();

		HttpSession session = request.getSession();

		Reservation resev = new Reservation();
		resev.setNo(Integer.parseInt(request.getParameter("no")));
		resev.setId((String) session.getAttribute("id"));
		resev.setQty(Integer.parseInt(request.getParameter("qty")));
		resev.setDday(Integer.parseInt(request.getParameter("dday")));
		resev.setRday(request.getParameter("rday"));
		resev.setUsein(Integer.parseInt(request.getParameter("usein")));
		resev.setUsewifi(Integer.parseInt(request.getParameter("usewifi")));
		resev.setUsenavi(Integer.parseInt(request.getParameter("usenavi")));
		resev.setUseseat(Integer.parseInt(request.getParameter("useseat")));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d1 = sdf.parse(resev.getRday());
			d2 = sdf.parse(sdf.format(d2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int compare = d1.compareTo(d2);
		request.setAttribute("compare", compare);
		System.out.println("compare : " + compare);
		String id1 = (String) session.getAttribute("id");
		resev.setId(id1);

		RentCarDAO rdao = RentCarDAO.getInstance();
		rdao.setReserveCar(resev);

		Rentcar rentcar = rdao.getOneCar(resev.getNo());

		int totalCar = rentcar.getPrice() * resev.getQty() * resev.getDday();

		int usein = 0;
		if (resev.getUsein() == 1) {
			usein = 10000;
		}
		int usewifi = 0;
		if (resev.getUsewifi() == 1) {
			usewifi = 10000;
		}
		int useseat = 0;
		if (resev.getUseseat() == 1) {
			useseat = 10000;
		}
		int totalOption = (resev.getQty() * resev.getDday() * (usein + usewifi + useseat));
		request.setAttribute("totalCar", totalCar);
		request.setAttribute("totalOption", totalOption);

		String img = request.getParameter("img");
		request.setAttribute("img", img);

		String center = request.getParameter("center");
		request.setAttribute("center", center);
		request.setAttribute("rentcar", rentcar);

		return "main";
	}
}