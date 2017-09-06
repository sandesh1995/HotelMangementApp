<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Select Room Type</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>capacity</th>
			<th>Price</th>
		</tr>
		<tr>
			<form action="booking" method="POST">
				<c:forEach items="${room}" var="room">
					<tr>
						<td>${room.roomId}</td>
						<td>${room.roomType}</td>
						<td>${room.capacity}</td>
						<td>${room.price}</td>
						<td><input type="radio" name="room" value="${room.roomId}" /></td>
					</tr>
					</br>
				</c:forEach>
			</form>
		</tr>
	</table>
	<h3>Select Services</h3>
	<table>
		<tr>
			<th>ID</th>
			<th>Type</th>
			<th>Price</th>
		</tr>
		<tr>
			<form action="booking" method="POST">
				<c:forEach items="${services}" var="services">
					<tr>
						<td>${services.serviceId}</td>
						<td>${services.servicesType}</td>
						<td>${services.price}</td>
						<td><input type="checkbox" name="services" value="${services.roomId}" /></td>
					</tr>
					</br>
				</c:forEach>
			</form>
		</tr>
	</table>
</body>
</html>