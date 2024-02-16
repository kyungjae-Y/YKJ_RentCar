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
	<table>
		<tr height="70">
			<td colspan="4">
				<a href="${ctx}/main.do" style="text-decoration: none">
					<img alt="" src="img/rent_logo.jpg" height="120">
				</a>
			</td>
			<td align="center" width="200">
				<c:if test="${id eq null}">
					<c:out value="GUEST" />
				</c:if>
				<a href="userInfo.do?center=user/userInfo.jsp">${id}</a>
				님
				<c:if test="${id eq null}">
					<button onclick="location.href='main.do?center=user/login.jsp' ">로그인</button>
					<button onclick="location.href='main.do?center=user/join.jsp' ">회원가입</button>
				</c:if>
				<c:if test="${id ne null}">
					<button onclick="location.href='logoutCheck.do' ">로그아웃</button>
				</c:if>
			</td>
		</tr>
		<tr height="50">
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="reservateCarMain.do?center=rentcar/reserveCarMain.jsp" style="text-decoration: none">예약하기</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="reservateCarView.do?center=rentcar/reserveCarView.jsp" style="text-decoration: none">예약확인</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="#" style="text-decoration: none">자유게시판</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<font color="white" size="5"><a href="#" style="text-decoration: none">고객센터</a></font>
			</td>
			<td align="center" width="200" bgcolor="pink">
				<c:if test="${id ne 'admin'}">
					<font color="white" size="5"><a href="#" style="text-decoration: none">이벤트</a></font>
				</c:if>
				<c:if test="${id eq 'admin'}">
					<font color="white" size="5"><a href="main.do?center=rentcar/insertCar.jsp" style="text-decoration: none">차량 등록</a></font>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>