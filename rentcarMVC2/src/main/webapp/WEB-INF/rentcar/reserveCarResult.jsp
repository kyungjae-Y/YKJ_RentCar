<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<tr height="100">
				<td align="center">
					<font size="6" color="gray">차량 예약 완료 화면</font>
				</td>
			</tr>
			<tr height="100">
				<td align="center">
					<img src="img/${img}" width="470" />
				</td>
			</tr>
			<tr height="50">
				<td align="center">
					<font size="5" color="red">차량 총 예약 금액 : ${totalCar}</font>
				</td>
			</tr>
			<tr height="50">
				<td align="center">
					<font size="5" color="red">차량 총 옵션 금액 : ${totalOption}</font>
				</td>
			</tr>
			<tr height="50">
				<td align="center">
					<font size="5" color="red">차량 총 금액 : ${totalCar + totalOption}</font>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>