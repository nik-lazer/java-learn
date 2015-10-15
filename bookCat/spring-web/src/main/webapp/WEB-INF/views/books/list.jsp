<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Books list</title>
</head>
<body>
<%@include file="table.jsp" %>
<a href="<s:url value="/book/add/" />">add</a>
</body>
</html>
