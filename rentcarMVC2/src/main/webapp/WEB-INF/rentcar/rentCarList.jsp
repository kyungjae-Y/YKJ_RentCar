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
					<font size="6" color="gray">전체 렌트카 보기</font>
				</td>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr height="220">
					<td width="333" align="center">
						<a href="${ctx}/main.do?center=reserveCarView.do?no=${vo.no}">
							<img alt="" src="img/${vo.img}" width="300" height="200">
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