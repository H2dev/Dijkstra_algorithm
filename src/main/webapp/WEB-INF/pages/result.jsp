<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<%@include file="header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="mainTitle" /></title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<c:set var="newMatrix">
	<spring:message code="button.newMatrix" />
</c:set>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<table style="margin-left: auto; margin-right: auto;">
		<tbody>
			<tr>
				<td class="elementSmall"></td>
				<c:forEach begin="0" end="${ n - 1 }" varStatus="indexCharacters">
					<td class="elementSmall">${ characterList[indexCharacters.index] }</td>
				</c:forEach>
				<c:forEach begin="1" end="${ n }" varStatus="indexCount">
					<tr>
						<c:forEach begin="1" end="${ n + 1 }" varStatus="innerIndexCount">
							<c:choose>
								<c:when test="${innerIndexCount.index==1}">
									<td class="elementSmall">${ characterList[indexCount.index-1] }</td>
								</c:when>
								<c:when test="${(indexCount.index+1)==innerIndexCount.index}">
									<td><input class="elementSmall" type="text" value="0"
										disabled="disabled"></td>
								</c:when>
								<c:otherwise>
									<td><input class="elementSmall" type="text"
										value="${ matrix[indexCount.index-1][innerIndexCount.index-2] }"
										disabled="disabled"></td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>

	<br>
	<br>
	<p style="text-align: center;">
		<spring:message code="result.routeDistance" />
		${ routeDistance }
		<spring:message code="result.units" />
	</p>
	<p style="text-align: center;">
		<spring:message code="result.nodesOrder" />
		${ route }
	</p>
	<br>
	<br>

	<span style="text-align: center;">
		<form method="GET" action="distance_entry">
			<input class="buttonHighlihted" type="submit" value="${ newMatrix }" />
		</form>
	</span>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>

<%@include file="footer.jsp"%>
</html>