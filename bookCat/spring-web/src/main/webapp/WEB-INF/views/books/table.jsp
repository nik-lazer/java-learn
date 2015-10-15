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
	<c:forEach items="${books}" var="book">
		<tr>
			<td><a href="<s:url value="/book/update/${book.uid}/" />">update</a></td>
			<td><a href="<s:url value="/book/delete/${book.uid}/"/>">delete</a></td>
			<td>${book.name}</td>
			<td>${book.publisher.name}</td>
			<td>${book.author.getName()}</td>
			<td>${book.language.name}</td>
			<td>${book.date}</td>
		</tr>
	</c:forEach>
</table>