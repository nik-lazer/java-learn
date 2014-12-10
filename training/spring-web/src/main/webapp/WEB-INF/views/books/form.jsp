<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
	<sf:form method="POST" modelAttribute="book">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="name">Name:</label></th>
					<td>
						<sf:input path="name" size="50" id="name"/>
						<sf:errors path="name" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th><label for="publisher">publisher:</label></th>
					<td>
						<sf:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id" id="publisher"/>
						<sf:errors path="publisher" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th><label for="author">author:</label></th>
					<td>
						<sf:select path="author" items="${authors}" itemLabel="lastName" itemValue="id" id="author"/>
						<sf:errors path="author" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th><label for="language">language:</label></th>
					<td>
						<sf:select path="language" items="${langs}" itemLabel="name" itemValue="id" id="language"/>
						<sf:errors path="language" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th><label for="desc">desc:</label></th>
					<td><sf:textarea path="desc" cols="40" rows="5" id="desc"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<sf:button type="submit">Submit</sf:button>
					</td>
				</tr>
			</table>
		</fieldset>
	</sf:form>

</div>
