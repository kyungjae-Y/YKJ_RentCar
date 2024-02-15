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
	<c:set var="id" value="${sessionScope.id}" />
	<c:choose>
		<c:when test="${id eq null}">
			<script type="text/javascript">
				alert("로그인 후 예약이 가능 합니다");
				location.href = 'main.do?center=user/login.jsp';
			</script>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${compare < 0}">
			<script type="text/javascript">
				alert('현재 시스템 날짜보다 이전 날짜는 선택할 수 없음');
				history.go(-1);
			</script>
		</c:when>
		<c:when test="${compare == 0}">
			<script type="text/javascript">
				alert('날짜를 선택해주세요');
				history.go(-1);
			</script>
		</c:when>
	</c:choose>
	<div align="center">
		<table>
			<tr height="100">
				<td align="center">
					<font size="6" color="gray">차량 예약 완료 화면</font>
				</td>
			</tr>
			<tr height="100">
				<td align="center">
					<img src="img/${rentcar.img}" width="470" />
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