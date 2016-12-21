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
	
  <br><br><br><br><br>
  <span style="text-align:center;">			
  <form method="GET" action="upis_udaljenosti" onsubmit="return validirajBrojTocaka()"> 
	
	<spring:message code="upis.brojTocaka"/>
	<spring:message code="gumb.novaMatrica" var="tekst1"/>
	<input class="upis" type="number" id="upisBrojTocaka" name="n">&nbsp;&nbsp;&nbsp;
 	<input type="submit" class="gumb" style="width:180px; height:58px; "value="${ tekst1 }" />

  </form>
  </span>

	<br>
	
   <div style="margin-left: 20%; margin-right: 20%;"><span class="komentar"><spring:message code="tekst.opis"/></span></div>	
	 
	<br><br> 
	 
<c:if test="${ n!=null }">	
	<span style="text-align:center;">	 
	<form method="POST" action="rezultat" onsubmit="return validirajMatricu(${n})"> 
		 
	  	<table style="margin-left: auto; margin-right: auto;">
			<tbody>
				<tr><td class="element"></td>
				<c:forEach begin="0" end="${ n - 1 }" varStatus="indeksSlova">
					 <td class="element">${ listaSlova[indeksSlova.index] }</td>
				</c:forEach>
				<c:forEach begin="1" end="${ n }" varStatus="indeks">
			   		 <tr>
			   		 <c:forEach begin="1" end="${ n + 1 }" varStatus="indeksic">
			   			 <c:choose>
			   			    <c:when test="${indeksic.index==1}">
						       <td class="element"><span class="element" style="text-align:centre;">${ listaSlova[indeks.index-1] }</span></td>
						    </c:when>
						    <c:when test="${(indeks.index+1)==indeksic.index}">
						       <td class="element"><input class="element" type="text" name="element${indeks.index-1}${indeksic.index-2}" value="0" disabled="disabled"></td>
						    </c:when>
						    <c:otherwise>
						        <td class="element"><input class="element" type="text" name="element${indeks.index-1}${indeksic.index-2}" onblur="popuniMatricuSimetricno(this,${indeks.index-1},${indeksic.index-2})"></td>
						    </c:otherwise>
			   			</c:choose>
			   		</c:forEach>
			   		</tr>
				</c:forEach>
				</tr>
			</tbody>
		</table> 	
	
		<br><br>
		<button class="gumb" style="width:180px;" type="reset"><spring:message code="gumb.reset"/></button>
		<spring:message code="gumb.obradi" var="tekst2"/>
		&nbsp;&nbsp;&nbsp;<input class="gumb" style="border: 3px solid #c7f45e; width:180px;" type="submit" value="${ tekst2 }"  />
	 	<br><br><br><br><br>
	</form>
	</span>
</c:if>
		
  
</body>

<script type="text/javascript">
	
	function popuniMatricuSimetricno(element, red, stupac){
		
		var redSim = stupac.toString();
		var stupacSim = red.toString();
		var str = "element"; 
		
		var elementSim = str.concat(redSim).concat(stupacSim);
					
		document.getElementsByName(elementSim)[0].value=element.value;
	}

	function validirajMatricu(brojTocaka) {
		
		for (i=0; i<brojTocaka; i++) {
			for (j=0; j<brojTocaka; j++){
				var stringIndeks = i.toString().concat(j.toString());
				var elementString = "element".concat(stringIndeks);
				
				var element = document.getElementsByName(elementString)[0];
				
				if ( element.value == "" ) {
					element.value = '#';
				}

				var intElement = Number(element.value);
				
				if ( intElement < 0 || intElement > 999 || ( isNaN(intElement) && element.value!="#" ) ) {
			        alert("That entries are not permitted.");
			        return false;
				}
			}
		}
		return true;
	}
	
	function validirajBrojTocaka() {
		var brojTocaka = document.getElementById("upisBrojTocaka").value;
		if ( brojTocaka < 3 || brojTocaka > 26 ) {
			 alert("That entry is not permitted.");
			 return false;
		}
	}
	
</script>

<%@include file="footer.jsp"%>
</html>

