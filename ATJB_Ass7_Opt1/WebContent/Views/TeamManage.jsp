<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


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

<title>Quản lý đội bóng</title>
</head>

<body>
	<div class=container>
		<div class="menu">
			<button class="btn btn-primary">Quản lý đội bóng</button>
			<button class="btn btn-primary">Quản lý lịch thi đấu</button>
			<button class="btn btn-primary">Xem thông tin bảng xếp hạng</button>
			<button class="btn btn-primary">Xem đội vô địch</button>
		</div>

		<div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>Mã đội bóng</td>
						<td>Tên đội bóng</td>
						<td>Bảng</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listTeam">
						<tr>
							<td><s:property value="teamID" /></td>
							<td><s:property value="teamName" /></td>
							<td><s:property value="table" /></td>
							<td><a
								href="UpdateTeam?id=<s:property value="teamID"/>&name=<s:property value="teamName"/>">
									Cập nhật </a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div>
				<a class="btn btn-success" href="GroupTable">Sắp xếp bảng</a>
			</div>
		</div>

	</div>
</body>
</html>