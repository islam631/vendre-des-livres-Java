<%@page import="DAO.Livre_DAO"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page import="Beans.Livre"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
<body>
	<div class="product">
		<%
		String titre = request.getParameter("titreLv");
		Livre livre = Livre_DAO.getLivreid(Livre_DAO.Get_ID_Livre(titre));
		%>
		<img src="<%=livre.getIMAGE()%>" alt="Placholder Image 2">
		<h2 class="product-name"><%=livre.getTITRE_LV()%></h2>
		<p class="product-description"><%=livre.getDESC_LV()%></p>
		<p class="product-price">
		<strong>Price:</strong><%=livre.getPRIX_LV()%></p>
		<a href="PageDachat.jsp?id=<%=livre.getISBN_LV()%>"><button class="add-to-cart">acheter</button></a>
	</div>
	
	<style>
.product {
	width: 300px;
	padding: 20px;
	text-align: center;
	border: 1px solid #ccc;
	margin: 20px auto;
}

.product img {
	width: 100%;
}

.product-name {
	margin-top: 20px;
	font-size: 24px;
}

.product-description {
	margin-top: 20px;
	font-size: 16px;
	color: #555;
}

.product-price {
	margin-top: 20px;
	font-size: 18px;
	font-weight: bold;
}

.add-to-cart {
	display: block;
	margin: 20px auto;
	padding: 10px 20px;
	background-color: #333;
	color: #fff;
	border: none;
	cursor: pointer;
}

.add-to-cart:hover {
	background-color: #000;
}
</style>
</body>
</html>