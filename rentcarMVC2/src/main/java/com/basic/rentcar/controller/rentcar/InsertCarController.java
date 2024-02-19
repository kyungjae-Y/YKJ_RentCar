package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;
import com.basic.rentcar.vo.Rentcar;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertCarController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = request.getServletContext().getRealPath("/img");
		String myPath = "C:\\YKJ_RentCar\\img";
		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		System.out.println(saveDirectory);
		System.out.println(myPath);
		MultipartRequest multi = new MultipartRequest(request, myPath, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		String sFileName = null;
		String oFileName = null;
		if (multi.getFilesystemName("uploadFile") != null) {
			sFileName = multi.getFilesystemName("uploadFile");
			oFileName = multi.getOriginalFileName("uploadFile");
			String fileType = multi.getContentType("uploadFile");
			System.out.println("fileType = " + fileType);
		}
		String name = multi.getParameter("name");
		int category = Integer.parseInt(multi.getParameter("category"));
		int price = Integer.parseInt(multi.getParameter("price"));
		int usepeople = Integer.parseInt(multi.getParameter("usepeople"));
		int total_qty = Integer.parseInt(multi.getParameter("total_qty"));
		String company = multi.getParameter("company");
		String info = multi.getParameter("info");
		Rentcar vo = null;
		System.out.println("saveFileName = " + sFileName);
		System.out.println("orginFileName = " + oFileName);
		vo = new Rentcar(0, name, category, price, usepeople, total_qty, company, sFileName, info);
		String ctx = request.getContextPath();
		int cnt = RentCarDAO.getInstance().rentcarInsert(vo);
		String center = request.getParameter("center");
		request.setAttribute("center", center);
		if (cnt > 0) {
			return "redirect:" + ctx + "/main.do";
		} else {
			throw new ServletException("not insert");
		}
	}
}