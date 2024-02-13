<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../main.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="${ctx}/main.jsp?center=carOption.jsp" method="post">
			<table>
				<tr height="100">
					<td align="center" colspan="3">
						<font size="6" color="gray">${vo.name} 차량 선택</font>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>