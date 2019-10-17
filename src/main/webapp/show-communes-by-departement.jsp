<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Communes du département ${param['departement']} :</h2>
	<table>
		<c:forEach items="${communes}" var="commune">
			<tr>
				<td>${commune.nom }</td>
				<td>${commune.codePostal }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.jsp"></a>
</body>
</html>