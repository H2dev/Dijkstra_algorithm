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
<c:set var="process">
	<spring:message code="button.process" />
</c:set>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<span style="text-align: center;">
		<form method="GET" action="distance_entry"
			onsubmit="return validationNumberOfNodes()">
			<spring:message code="entry.numberOfNodes" />
			<input class="entry" type="number" id="numberOfNodesEntry" name="n">&nbsp;&nbsp;&nbsp;
			<input type="submit" class="button"
				style="width: 180px; height: 58px;" value="${ newMatrix }" />
		</form>
	</span>
	<br>
	<br>
	<div style="margin-left: 20%; margin-right: 20%; text-align: justify;">
		<span class="comment"><spring:message code="appDesciption" /></span>
	</div>
	<br>
	<br>
	<c:if test="${ n != null }">
		<span style="text-align: center;">
			<form method="POST" action="result"
				onsubmit="return validateMatrix(${n})">
				<table style="margin-left: auto; margin-right: auto;">
					<tbody>
						<tr>
							<td class="element"></td>
							<c:forEach begin="0" end="${ n - 1 }" varStatus="indexCharacter">
								<td class="element">${ characterList[indexCharacter.index] }</td>
							</c:forEach>
							<c:forEach begin="1" end="${ n }" varStatus="indexCount">
								<tr>
									<c:forEach begin="1" end="${ n + 1 }"
										varStatus="innerIndexCount">
										<c:choose>
											<c:when test="${innerIndexCount.index==1}">
												<td class="element"><span class="element"
													style="text-align: centre;">${ characterList[indexCount.index-1] }</span></td>
											</c:when>
											<c:when test="${(indexCount.index+1)==innerIndexCount.index}">
												<td class="element"><input class="element" type="text"
													name="element${indexCount.index-1}${innerIndexCount.index-2}"
													value="0" disabled="disabled"></td>
											</c:when>
											<c:otherwise>
												<td class="element"><input class="element" type="text"
													name="element${indexCount.index-1}${innerIndexCount.index-2}"
													oninput="fillMatrixSimetricaly(this,${indexCount.index-1},${innerIndexCount.index-2})"></td>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tr>
							</c:forEach>
						</tr>
					</tbody>
				</table>
				<br> <br>
				<button class="button" type="reset">
					<spring:message code="button.reset" />
				</button>
				&nbsp;&nbsp;&nbsp;<input class="buttonHighlihted" type="submit"
					value="${ process }" /> <br> <br> <br> <br> <br>
			</form>
		</span>
	</c:if>
</body>

<script type="text/javascript">
	
	function fillMatrixSimetricaly(element, row, column){
		
		var rowSim = column.toString();
		var columnSim = row.toString();
		var str = "element"; 
		
		var elementSim = str.concat(rowSim).concat(columnSim);
					
		document.getElementsByName(elementSim)[0].value=element.value;
	}

	function validateMatrix(numberOfNodes) {
		
		for (i=0; i<numberOfNodes; i++) {
			for (j=0; j<numberOfNodes; j++){
				var stringIndex = i.toString().concat(j.toString());
				var elementString = "element".concat(stringIndex);
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
	
	function validationNumberOfNodes() {
		var numberOfNodes = document.getElementById("numberOfNodesEntry").value;
		if ( numberOfNodes < 3 || numberOfNodes > 26 ) {
			 alert("That entry is not permitted.");
			 return false;
		}
	}
	
</script>

<%@include file="footer.jsp"%>
</html>

