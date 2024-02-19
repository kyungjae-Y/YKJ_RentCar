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
					<%@ include file="./parts/header.jsp"%>
				</td>
			</tr>
			<c:choose>
				<c:when test="${ center eq null }">
					<table>
						<tr height="500">
							<td align="center">
								<img alt="" src="img/17.jpg" width="1000">
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<jsp:include page="${center}" />
				</c:otherwise>
			</c:choose>
			<tr height="100" align="center">
				<td align="center" width="1000">
					<%@ include file="./parts/footer.jsp"%>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>