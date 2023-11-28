<%@page import="Beans.Livre"%>
<%@page import="DAO.Livre_DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="image/Library.png">
<title>page d'achat SAOI STORE</title>

<style>
@charset "utf-8";

@import
	url(https://fonts.googleapis.com/css?family=Open+Sans:400,700,600);

html, html a {
	-webkit-font-smoothing: antialiased;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.004);
}

body {
	background-color: #fff;
	color: #666;
	font-family: "Open Sans", sans-serif;
	font-size: 62.5%;
	margin: 0 auto;
}

a {
	border: 0 none;
	outline: 0;
	text-decoration: none;
}

strong {
	font-weight: bold;
}

p {
	margin: 0.75rem 0 0;
}

h1 {
	font-size: 0.75rem;
	font-weight: normal;
	margin: 0;
	padding: 0;
}

input, button {
	border: 0 none;
	outline: 0 none;
}

button {
	background-color: #666;
	color: #fff;
}

button:hover, button:focus {
	background-color: #555;
}

img, .basket-module, .basket-labels, .basket-product {
	width: 100%;
}

input, button, .basket, .basket-module, .basket-labels, .item, .price,
	.quantity, .subtotal, .basket-product, .product-image, .product-details
	{
	float: left;
}

.price:before, .subtotal:before, .subtotal-value:before, .total-value:before,
	.promo-value:before {
	content: "ï¿½";
}

.hide {
	display: none;
}

main {
	clear: both;
	font-size: 0.75rem;
	margin: 0 auto;
	overflow: hidden;
	padding: 1rem 0;
	width: 960px;
}

.basket, aside {
	padding: 0 1rem;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.basket {
	width: 70%;
}

.basket-module {
	color: #111;
}

label {
	display: block;
	margin-bottom: 0.3125rem;
}

.promo-code-field {
	border: 1px solid #ccc;
	padding: 0.5rem;
	text-transform: uppercase;
	transition: all 0.2s linear;
	width: 48%;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	-moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	-o-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
}

.promo-code-field:hover, .promo-code-field:focus {
	border: 1px solid #999;
}

.promo-code-cta {
	border-radius: 4px;
	font-size: 0.625rem;
	margin-left: 0.625rem;
	padding: 0.6875rem 1.25rem 0.625rem;
}

.basket-labels {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	margin-top: 1.625rem;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	color: #111;
	display: inline-block;
	padding: 0.625rem 0;
}

li.price:before, li.subtotal:before {
	content: "";
}

.item {
	width: 55%;
}

.price, .quantity, .subtotal {
	width: 15%;
}

.subtotal {
	text-align: right;
}

.remove {
	bottom: 1.125rem;
	float: right;
	position: absolute;
	right: 0;
	text-align: right;
	width: 45%;
}

.remove button {
	background-color: transparent;
	color: #777;
	float: none;
	text-decoration: underline;
	text-transform: uppercase;
}

.item-heading {
	padding-left: 4.375rem;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.basket-product {
	border-bottom: 1px solid #ccc;
	padding: 1rem 0;
	position: relative;
}

.product-image {
	width: 35%;
}

.product-details {
	width: 65%;
}

.product-frame {
	border: 1px solid #aaa;
}

.product-details {
	padding: 0 1.5rem;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.quantity-field {
	background-color: #ccc;
	border: 1px solid #aaa;
	border-radius: 4px;
	font-size: 0.625rem;
	padding: 2px;
	width: 3.75rem;
}

aside {
	float: right;
	position: relative;
	width: 30%;
}

.summary {
	background-color: #eee;
	border: 1px solid #aaa;
	padding: 1rem;
	position: fixed;
	width: 250px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.summary-total-items {
	color: #666;
	font-size: 0.875rem;
	text-align: center;
}

.summary-subtotal, .summary-total {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	clear: both;
	margin: 1rem 0;
	overflow: hidden;
	padding: 0.5rem 0;
}

.subtotal-title, .subtotal-value, .total-title, .total-value,
	.promo-title, .promo-value {
	color: #111;
	float: left;
	width: 50%;
}

.summary-promo {
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

.promo-title {
	float: left;
	width: 70%;
}

.promo-value {
	color: #8b0000;
	float: left;
	text-align: right;
	width: 30%;
}

.summary-delivery {
	padding-bottom: 3rem;
}

.subtotal-value, .total-value {
	text-align: right;
}

.total-title {
	font-weight: bold;
	text-transform: uppercase;
}

.summary-checkout {
	display: block;
}

.checkout-cta {
	display: block;
	float: none;
	font-size: 0.75rem;
	text-align: center;
	text-transform: uppercase;
	padding: 0.625rem 0;
	width: 100%;
}

.summary-delivery-selection {
	background-color: #ccc;
	border: 1px solid #aaa;
	border-radius: 4px;
	display: block;
	font-size: 0.625rem;
	height: 34px;
	width: 100%;
}

.alafacture {
	text-decoration: none;
	color: white;
}

.alafacture:hover {
	color: rgb(32, 186, 14);
}

.alafacture:active {
	color: rgb(196, 196, 196);
}

.btndomicile {
	margin: 1cm;
	padding: 8px 10px;
	font-size: 15px;
	background: #27ae60;
	color: #fff;
	border-radius: 3px;
	text-decoration: none;
}

.btndomicile:hover {
	background: #fff;
	color: #27ae60;
}

.btndomicile:active {
	background: #ff0000;
	color: rgb(255, 255, 255);
}

@media screen and (max-width: 640px) {
	aside, .basket, .summary, .item, .remove {
		width: 100%;
	}
	.basket-labels {
		display: none;
	}
	.basket-module {
		margin-bottom: 1rem;
	}
	.item {
		margin-bottom: 1rem;
	}
	.product-image {
		width: 40%;
	}
	.product-details {
		width: 60%;
	}
	.price, .subtotal {
		width: 33%;
	}
	.quantity {
		text-align: center;
		width: 34%;
	}
	.quantity-field {
		float: none;
	}
	.remove {
		bottom: 0;
		text-align: left;
		margin-top: 0.75rem;
		position: relative;
	}
	.remove button {
		padding: 0;
	}
	.summary {
		margin-top: 1.25rem;
		position: relative;
	}
}

@media screen and (min-width: 641px) and (max-width: 960px) {
	aside {
		padding: 0 1rem 0 0;
	}
	.summary {
		width: 28%;
	}
}

@media screen and (max-width: 960px) {
	main {
		width: 100%;
	}
	.product-details {
		padding: 0 1rem;
	}
}
</style>

</head>

<body>

	<div>
		<a href="PPavantSr.jsp"><button class="btndomicile">domicile</button></a>
	</div>

	<main>

		<%
		Livre livre = Livre_DAO.getLivreid(Integer.valueOf(request.getParameter("id")));
		%>
		<div class="basket">
			<div class="basket-module">
				<label for="promo-code">Enter a promotional code</label> <input
					id="promo-code" type="text" name="promo-code" maxlength="5"
					class="promo-code-field">
				<button class="promo-code-cta">ok</button>
			</div>
			<div class="basket-labels">
				<ul>
					<li class="item item-heading">Produit</li>
					<li class="price">Prix</li>
      			    <li class="quantity">nemuro des pages</li>
					<li class="subtotal">description</li>
				</ul>
			</div>
			<div class="basket-product">
				<div class="item">
					<div class="product-image">
						<img src="<%=livre.getIMAGE()%>" alt="Placholder Image 2"
							class="product-frame">
					</div>
					<div class="product-details">
						<h1>
							<strong><span class="item-quantity"><%=livre.getTITRE_LV()%>
						</h1>
					</div>
				</div>
				<div class="price"><%=livre.getPRIX_LV()%></div>
				<div class="quantity">
					<label class="quantity-field"><%=livre.getNMRPAGE_LV()%></label>
				</div>
      		  <div class="subtotal"><%=livre.getDESC_LV()%></div>
			</div>
		</div>
		<aside>
			<div class="summary">
				<div class="summary-total-items">
					<span class="total-items"></span> vos Produit
				</div>
				<div class="summary-subtotal">
					<div class="subtotal-title">total</div>
					<div class="subtotal-value final-value" id="basket-subtotal"><%=livre.getPRIX_LV()%></div>
					<div class="summary-promo hide"></div>
				</div>
				<div class="summary-delivery">
					<select name="delivery-collection"
						class="summary-delivery-selection">
						<option value="0" selected="selected">choisir votre
							méthode de livraison</option>
						<option value="second-class">au niveau du magasin</option>
					</select>
				</div>
				<div class="summary-total">
					<div class="total-title">Total</div>
					<div class="total-value final-value" id="basket-total"><%=livre.getPRIX_LV()%></div>
				</div>
				<div class="summary-checkout">
					<button class="checkout-cta">
						<a href="facture.jsp?id=<%=livre.getISBN_LV()%>">
							 <button class="checkout-cta">  <p class="alafacture"> acheter, imprimer ma facture </p></button>
						</a>
					</button>
				</div>
			</div>
		</aside>
	</main>


</body>

</html>