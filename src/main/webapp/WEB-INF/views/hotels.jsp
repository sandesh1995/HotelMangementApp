<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th> Id </th>
		<th> Name </th>
		<th> City </th>
		<th> Rating </th>
	</tr>
	<form action="booking" method="POST">
 	<c:forEach items="${hotelData1}" var="hotelData">
		<tr>
			<td>${hotelData.hotelid}</td>
			<td>${hotelData.hotelname}</td>
			<td>${hotelData.city}</td>
			<td>${hotelData.rating}</td>
			<td><input type="submit" value="Book Now"/> </td>
		</tr>
		</br>
	</c:forEach>
	</form>
 </table>
 ${hotelData1}
</body>
</html>