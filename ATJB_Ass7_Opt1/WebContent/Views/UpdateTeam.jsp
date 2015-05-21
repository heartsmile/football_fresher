<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/Views/resources/css/bootstrap.min.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/Views/resources/css/homepage.css" />"
	type="text/css">

<title>Update Team</title>
</head>
<body>
	<div class=container>
		<form action="SubmitUpdate" method="post">
			<table class="table">
				<tr>
					<td>Mã đội bóng <input type="text" name="teamID" readonly="readonly"
						value="<s:property value="teamObj.teamID"/>"></td>
					<td>Tên đội bóng<input type="text" name="teamName"
						value="<s:property value="teamObj.teamName"/>"></td>
				</tr>
				<tr>
					<td>
						<button class="btn btn-success" value="Update">Update</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>