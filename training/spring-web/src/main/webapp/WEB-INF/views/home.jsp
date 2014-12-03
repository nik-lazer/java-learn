<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home page</title>
</head>
<body>
<table border="1">
	<tr>
		<td>Name</td>
		<td>Publisher</td>
		<td>Author</td>
		<td>Language</td>
		<td>Date</td>
	</tr>
	<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.name}</td>
			<td>${book.publisher}</td>
			<td>${book.author}</td>
			<td>${book.language}</td>
			<td>${book.date}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
