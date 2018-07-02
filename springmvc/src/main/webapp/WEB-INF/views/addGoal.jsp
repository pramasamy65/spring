<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Add Goal</title>
</head>
<body>
	<form:form modelAttribute="goal">
		<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
		<table>
			<tr>
				<td>Enter Goal in Minutes</td>
				<td><form:input path="minutes" /></td>
				<td><form:errors path="minutes" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Enter Goal" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>