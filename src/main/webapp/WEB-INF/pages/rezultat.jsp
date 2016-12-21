<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<%@include file="header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dijkstra's algorithm and diagram</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css" />

</head>

<body>
		
	<br><br><br><br><br><br>
	
	<table style="margin-left: auto; margin-right: auto;">
		<tbody>
			<tr><td class="elementMali"></td>
			<c:forEach begin="0" end="${ n - 1 }" varStatus="indeksSlova">
				 <td class="elementMali">${ listaSlova[indeksSlova.index] }</td>
			</c:forEach>
			<c:forEach begin="1" end="${ n }" varStatus="indeks">
		   		 <tr>
		   		 <c:forEach begin="1" end="${ n + 1 }" varStatus="indeksic">
		   			 <c:choose>
		   			    <c:when test="${indeksic.index==1}">
					       <td class="elementMali">${ listaSlova[indeks.index-1] }</td>
					    </c:when>
					    <c:when test="${(indeks.index+1)==indeksic.index}">
					       <td><input class="elementMali" type="text" value="0" disabled="disabled"></td>
					    </c:when>
					    <c:otherwise>
					       <td><input class="elementMali" type="text" value="${ matrica[indeks.index-1][indeksic.index-2] }" disabled="disabled"></td>
					    </c:otherwise>
		   			</c:choose>
		   		</c:forEach>
		   		</tr>
			</c:forEach>
			</tr>
		</tbody>
	</table> 	
	
	<br><br>
	<p style="text-align:center;"><spring:message code="rezultat.duljinaPuta"/> ${ duljinaPuta } <spring:message code="rezultat.jedinica"/> </p>
	<p style="text-align:center;"><spring:message code="rezultat.redosljedPuta"/>  ${ put } </p>
	<br><br>
	
	<span style="text-align:center;">
		<form method="GET" action="index">
			<spring:message code="gumb.novaMatrica" var="tekst3"/>
			<input class="gumb" style="border: 3px solid #c7f45e; width:180px;" type="submit" value="${ tekst3 }"  />
		</form>
	</span>
	<br><br><br><br><br>
		  
</body>

<%@include file="footer.jsp"%>
</html>