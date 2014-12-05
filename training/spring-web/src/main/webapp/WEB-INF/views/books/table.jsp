<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<table border="1">
	<tr>
		<td></td>
		<td></td>
		<td>Name</td>
		<td>Publisher</td>
		<td>Author</td>
		<td>Language</td>
		<td>Date</td>
	</tr>
	<c:set var="i" value="0"/>
	<c:forEach items="${books}" var="book">
		<tr>
			<td><a href="<s:url value="/book/update/${i}/" />">update</a></td>
			<td><a href="<s:url value="/book/delete/${i}/"/>">delete</a></td>
			<td>${book.name}</td>
			<td>${book.publisher}</td>
			<td>${book.author}</td>
			<td>${book.language}</td>
			<td>${book.date}</td>
		</tr>
		<c:set var="i" value="${i + 1}"/>
	</c:forEach>
</table>