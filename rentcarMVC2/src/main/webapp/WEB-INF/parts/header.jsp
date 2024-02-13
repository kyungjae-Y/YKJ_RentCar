<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../main.jsp"%>
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
					<button onclick=""></button>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>