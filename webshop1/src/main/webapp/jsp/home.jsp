<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><spring:message code="title" text="default"/></h1>
<h1><spring:message code="message" text="default"/></h1>
<form action="addKnjiga" method="post">
naziv <input name="naziv" type="text" />
izdavac <input name="izdavac" type="text" />
<input type="submit" value="Submit"/>
</form>

${book.id} ${book.naziv} ${book.izdavac}
</body>
</html>