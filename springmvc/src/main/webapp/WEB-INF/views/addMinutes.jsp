<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.error {
	color: #ff0000;
}
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3pxsolid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Add Minutes Page</title>

<script type="text/javascript" src="jquery-1.8.3.js" ></script>
<script type="text/javascript">
$(document).ready(function() {
		//$.getJSON('http://localhost:8080/springmvc/activities', {
		 $.getJSON('<spring:url value="activities"/>', {
			ajax : 'true'
		}, function(response) {
			console.log(response);
			var html = '<option value = "">--Please select one--</option>';
			$.each(response, function(key, val) {
				console.log(val.description);
				html = html + '<option value="' + val.description + '">' + 
				val.description + '</option>';
			});
			$('#activities').html(html);
		});
	});
</script>
</head>
<body>
	<h1>Add Minutes Handson</h1>

	Language :
	<a href="?language=en">English</a> |
	<a href="?language=es">Spanish</a>
	<form:form modelAttribute="exercise">
	<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
		<table>
			<tr>
				<td><spring:message code="goal.text" /></td>
				<td><form:input path="minutes" /></td>
				<td><form:select id="activities" path="activity"></form:select></td>
				<td><form:errors path="activity" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form:form>
	<h1>Our Goal For the day : ${goal.minutes}</h1>
</body>
</html>