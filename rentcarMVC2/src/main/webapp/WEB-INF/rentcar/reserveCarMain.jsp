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
			<tr height="60">
				<td align="center" colspan="3">
					<font size="6" color="gray">최신형 자동차</font>
				</td>
			</tr>
			<tr height="240">
				<c:forEach var="vo" items="${list}">
					<td width="333" align="center">
						<a href="${ctx}/carInfo.do?center=rentcar/reserveCarInfo.jsp&no=${vo.no}">
							<img alt="" src="img/${vo.img}" width="300" height="220">
						</a>
						<p>차량명 : ${vo.name}</p>
					</td>
				</c:forEach>
			</tr>
		</table>
		<hr size="3" color="red">
		<p>
			<font size="4" color="gray"><b>차량 검색 하기</b></font>
		</p>
		<form action="${ctx}/carList.do?center=rentcar/carCategoryList.jsp" method="post">
			<font size="3" color="gray"><b>차량 검색 하기</b></font>
			<select name="category">
				<option value="1">소형</option>
				<option value="2">중형</option>
				<option value="3">대형</option>
			</select>
			<input type="submit" value="검색" />
		</form>
		<button onclick="location.href='${ctx}/carList.do?center=rentcar/rentCarList.jsp' ">전체 검색</button>
	</div>
</body>
</html>