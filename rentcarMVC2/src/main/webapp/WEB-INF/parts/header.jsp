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
	<c:if test="${vo.id eq null}">
		<c:out value="GUEST" />
	</c:if>
	<table>
		<tr height="70">
			<td colspan="4">
				<a href="${ctx}/main.jsp" style="text-decoration: none">
					<img alt="" src="../../img/rent_logo.jpg" height="120">
				</a>
			</td>
			<td align="center" width="200">
				${vo.id} 님
				<c:if test="${vo.id eq 'GUEST'}">
					<button onclick="location.href='${ctx}/main.jsp?center=${ctx}/login.jsp' ">로그인</button>
				</c:if>
				<c:if test="${vo.id ne 'GUEST'}">
					<button onclick="location.href='${ctx}/logout.jsp' ">로그아웃</button>
				</c:if>
			</td>
		</tr>
		<tr height="50">
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="${ctx}/main.jsp?center=reserveCarMain.jsp" style="text-decoration: none">예약하기</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="${ctx}/main.jsp?center=reserveCarView.jsp" style="text-decoration: none">예약확인</a></font>
			</td>
		</tr>
	</table>
</body>
</html>