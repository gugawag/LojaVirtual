<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos da Loja</title>
</head>
<body>
  
  <table border=1>
  <tr>
  	<td><b>Descrição</b></td><td><b>Valor</b></td>
  </tr>
  <c:forEach var="produto" items="${applicationScope.produtos}">
  	<tr><td><a href="inserir.do?codigo=${produto.codigo}">${produto.descricao}</a></td><td>${produto.valor}</td></tr>
  </c:forEach>
  
  </table>
 
	

</body>
</html>