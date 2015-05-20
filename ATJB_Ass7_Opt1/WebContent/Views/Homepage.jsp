<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Quản lý lịch thi đấu bảng xếp hạng</title>

<script type="text/javascript">
	function TeamManage() {
		window.location = "TeamManage()";
	}
</script>

</head>

<body>
	<div class=container>
		<div class="menu">
			<a class="btn btn-primary" href="TeamManage">Quản lý đội bóng</a>
			<button class="btn btn-primary">Quản lý lịch thi đấu</button>
			<button class="btn btn-primary">Xem thông tin bảng xếp hạng</button>
			<button class="btn btn-primary">Xem đội vô địch</button>
		</div>
	</div>
</body>
</html>