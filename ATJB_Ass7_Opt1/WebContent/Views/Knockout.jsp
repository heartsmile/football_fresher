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
<style type="text/css">
input {
	width: 50px;
}
</style>

<title>Quản lý lịch thi đấu</title>
</head>

<body>

	<div class=container>
		<div class="menu">
			<a class="btn btn-primary" href="TeamManage">Quản lý đội bóng</a>
			<a class="btn btn-primary" href="TableRound">Quản lý lịch thi đấu</a>
			<button class="btn btn-primary">Xem thông tin bảng xếp hạng</button>
			<button class="btn btn-primary">Xem đội vô địch</button>
		</div>
		<div class="subMenu">
			<a class="btn btn-info" href="TableRound">Vòng bảng</a>
			<a class="btn btn-info" href="KnockoutRound">Vòng loại trực tiếp</a>
		</div>

		<div>
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Đội 1</td>
						<td>Đội 2</td>
						<td>Vòng</td>
						<td>Tỉ số</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listMatch">
						<tr>
							<td><s:property value="team1Name" /></td>
							<td><s:property value="team2Name" /></td>
							<td><s:property value="round" /></td>
							<td>
								<form method="post" action="SaveRatio">
									<s:hidden name="matchID" value="%{matchID}"></s:hidden>
									<input type="text" name="num1" value="<s:property value="team1Result" />"> 
									- <input type="text" name="num2" value="<s:property value="team2Result" />">
									<button class="btn btn-success" type="submit">Lưu lại</button>
								</form>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>