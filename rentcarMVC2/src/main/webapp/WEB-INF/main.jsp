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
			<tr height="120" align="center">
				<td align="center" width="1000">
					<jsp:include page="./parts/header.jsp"></td>
			</tr>
			<tr align="center">
				<td align="center" width="1000"></td>
			</tr>
			<tr height="100" align="center">
				<td align="center" width="1000">
					<jsp:include page="./parts/footer.jsp"></td>
			</tr>
		</table>
	</div>
</body>
</html>