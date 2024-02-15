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
	<c:choose>
		<c:when test="${vo.totalQty eq 0}">
			<script type="text/javascript">
				alert("이 차량은 모두 대여중입니다");
				location.href = 'main.do?center=rentcar/reserveCarMain.jsp';
			</script>
		</c:when>
	</c:choose>
	<div align="center">
		<form action="${ctx}/selectCarOption.do?center=rentcar/carOption.jsp" method="post">
			<table>
				<tr height="100">
					<td align="center" colspan="3">
						<font size="6" color="gray">${vo.name} 차량 선택</font>
					</td>
				</tr>
				<tr>
					<td rowspan="6" width="500" align="center">
						<img alt="" src="img/${vo.img}" width="450">
					</td>
					<td width="250" align="center">차량이름</td>
					<td width="250" align="center">${vo.name}</td>
				</tr>
				<tr>
					<td width="250" align="center">총 승차인원</td>
					<td width="250" align="center">${vo.usepeople}</td>
				</tr>
				<tr>
					<td width="250" align="center">차량수량</td>
					<td width="250" align="center">
						<select name="qty">
							<c:forEach begin="1" end="${vo.totalQty}" var="i">
								<c:choose>
									<c:when test="${i eq 1}">
										<option value="1" selected>1</option>
									</c:when>
									<c:otherwise>
										<option value="${i}">${i}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="250" align="center">차량분류</td>
					<td width="250" align="center">${temp}</td>
				</tr>
				<tr>
					<td width="250" align="center">대여가격</td>
					<td width="250" align="center">${vo.price}원</td>
				</tr>
				<tr>
					<td width="250" align="center">제조회사</td>
					<td width="250" align="center">${vo.company}</td>
				</tr>
				<tr>
					<td width="250" align="center">
						<c:if test="${id ne null}">
							<input type="hidden" name="no" value="${vo.no}" />
							<input type="hidden" name="img" value="${vo.img}" />
							<input type="submit" value="옵션 선택 후 렌트 예약하기" />
						</c:if>
					</td>
				</tr>
			</table>
			<br /> <br /> <br /> <font size="5" color="gray">차랑 정보 보기</font>
			<p>${vo.info}</p>
		</form>
	</div>
</body>
</html>