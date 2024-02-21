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
	<c:set var="category" value="${param.category}" />
	<c:choose>
		<c:when test="${category == 1}">
			<c:set var="temp" value="소형" />
		</c:when>
		<c:when test="${category == 2}">
			<c:set var="temp" value="중형" />
		</c:when>
		<c:when test="${category == 3}">
			<c:set var="temp" value="대형" />
		</c:when>
	</c:choose>
	<div align="center" class="myslider">
		<table>
			<tr height="60">
				<td align="center" colspan="3">
					<font size="6" color="gray">${temp} 자동차</font>
				</td>
			</tr>
			<c:forEach var="vo" items="${list}">
				<c:if test="${vo.category == param.category}">
					<tr height="220">
						<td width="333" align="center" class="cclist">
							<a href="${ctx}/carInfo.do?center=rentcar/reserveCarInfo.jsp&no=${vo.no}">
								<img alt="" src="img/${vo.img}" width="300" height="200" />
							</a>
							<p>
								<font size="3" color="gray"><b>차량명 / ${vo.name}</b></font>
							</p>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
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