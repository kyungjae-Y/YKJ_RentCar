<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../main.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="category" value="${param.category}" />
	<c:set var="temp">
		<c:choose>
			<c:when test="${category == 1}">소형</c:when>
			<c:when test="${category == 2}">중형</c:when>
			<c:when test="${category == 3}">대형</c:when>
		</c:choose>
	</c:set>
	<div align="center">
		<table>
			<tr height="60">
				<td align="center" colspan="3">
					<font size="6" color="gray">${category} 자동차</font>
				</td>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr height="220">
					<td width="333" align="center">
						<a href="${ctx}/main.jsp?center=reserveCarInfo.jsp?no=${vo.no}">
							<img alt="" src="img/${vo.img}" width="300" height="200" />
						</a>
						<p>
							<font size="3" color="gray"><b>차량명 / ${vo.name}</b></font>
						</p>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>