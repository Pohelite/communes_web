<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Recherche par code postal</h2>
<form action="CommuneServlet" method="get" target="_blank">
Code postal: <input name="cp" id="cp" size="8"><button>Rechercher</button>
</form>
<form action="CommuneByDepartementServlet" method="get" target="_blank">
Département: <input name="departement" id="departement"><button>Rechercher</button>
</form>
</body>
</html>