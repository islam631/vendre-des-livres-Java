	<%@page import="DAO.Livre_DAO"%>
<%@page import="java.beans.Beans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="css/style1.css">
    <script src="js/script1.js" defer></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="image/Library.png">
    <title>SAOI STRORE</title>
</head>
<body>
    
<!-- header section starts  -->

<header class="header">

    <div class="header-1">

        <a href="#" class="logo"> <i class="fas fa-book"></i> SAOI STORE </a>

        <form action="cherchlv.jsp" class="search-form">
            <input type="search" name="titreLv" placeholder="search here..." id="search-box">
            <label for="search-box" class="fas fa-search"></label>
        </form>
		<div class="profile-details">
       		<span class="admin_name" style="font-size: 0.5cm;">Bienvenue chez nous</span>
     	 </div>
        <div class="icons">
            <div id="search-btn" class="fas fa-search"></div>
            <div id="login-btn" class="fas fa-user">
            	<label style="font-size: large;">Se connecter</label>
            </div>
        </div>

    </div>

    <div class="header-2">
        <nav class="navbar">
            <a href="#home">Domicile</a>
            <a href="#product-preview">Livres étrangers</a>
            <a href="#featured">livres arabes</a>
        </nav>
    </div>
</header>

<!-- header section ends -->

<!-- login form  -->

<!-- connection-->
<div class="login-form-container">
    <div id="close-login-btn" class="fas fa-times"></div>
    <form action="LoginUtAd" method="post">
        <h3>Se connecter 
            <h4 style="color: red;">remarque</h4>
            <ul>
            <li ><H5>Si vous ètes un admin donner votre email et mot de passe</H5></li>
            <li><h5>le mème avec les utilisateurs</h5></li>
            </ul>
        </h3>
        <span>email</span>
        <input type="email" name="email1" class="box" placeholder="enter your email" id="">
        <span>mot de passe</span>
        <input type="password" name="password1" class="box" placeholder="enter your password" id=""> 
        <label class="container"> pour les admins 
  		<input type="checkbox" checked="checked"  name="checkAdUt">
  		<span class="checkmark"></span>
		</label>
        <input type="submit" value="sign in" class="btn">
        <p>vous n'avez pas de compte ? <a href="CreationCmpCl.jsp">créer un compte</a></p>
    </form>
</div>

<!-- home section starts  -->

<section class="home" id="home">
		<div class="row">
			<div class="content">
				<h3>sold</h3>
				<p>
					vous allez trouver dans notre Boutique les meilleurs <br>
					livres quel soit en arab pour les arabiens ou bien <br> une
					autre langue comme le franï¿½ais et bien sur L'anglais <br>
				</p>
			</div>
			<div class="swiper books-slider">
				<%
				
				Livre_DAO livreDao = new Livre_DAO();
				out.println("<div class='swiper-wrapper'>");
				for (int i = 1; i < 4; i++) {
				%>
				<a href="PageDachat.jsp?id=<%=livreDao.GetLivrs().get(i).getISBN_LV()%>" class="swiper-slide"> <img
					src="<%=Livre_DAO.GetLivrs().get(i).getIMAGE()%>">
				</a>
				<%
				}
				out.println("</div>");
				%>
				<img src="image/stand.png" class="stand" alt="">
			</div>
		 </div>
	</section>

<!-- home section ense  -->


	<!-- produit view starts-->
	
	<%
	Livre_DAO livreDV = new Livre_DAO();
	out.println("<div class='container'>");
	out.println("<h1 class='heading'><br><br><br><br>");
	out.println("<span>Livres étrangers</span>");
	out.println("</h1>");
	out.println("<div class='products-container'>");

	for (int i = 0; i < livreDV.GetLivrs().size(); i++) {
	%>
		<div class="product" data-name="p-9">
				<a href="PageDachat.jsp?id=<%=livreDV.GetLivrs().get(i).getISBN_LV()%>">
				<img src='<%=livreDV.GetLivrs().get(i).getIMAGE() %>' alt="">
				<h3><%= livreDV.GetLivrs().get(i).getTITRE_LV()%></h3>
				<div class="price">$<%= livreDV.GetLivrs().get(i).getPRIX_LV()%></div>
				</a>
		</div>
	<%
	}
	out.println("</div>");
	out.println("</div>");
	%>
 
	<!--produit view ends-->
<!-- featured section starts  -->

<%
	Livre_DAO livreft = new Livre_DAO();
	out.println("<section class='featured' id='featured'>");
	out.println("<h1 class='heading'><span>livres arabes</span></h1>");
	out.println("<div class='swiper featured-slider'>");
	out.println("<div class='swiper-wrapper'>");

	for (int i = 0; i < livreft.GetLivrs().size(); i++) {
	%>
		<div class="swiper-slide box">
					<div class="icons">
						 <a href="PageDachat.jsp?id=<%=livreDV.GetLivrs().get(i).getISBN_LV()%>" class="fa fa-shopping-cart"></a>
					</div>
					<div class="image">
						<img src='<%=livreDV.GetLivrs().get(i).getIMAGE() %>' alt="">
					</div>
					<div class="content">
						<h3><%= livreDV.GetLivrs().get(i).getTITRE_LV()%></h3>
						<div class="price">$<%= livreDV.GetLivrs().get(i).getPRIX_LV()%>
						</div>
					</div>
				</div>
				
				<a href="PageDachat.jsp?id=<%=livreDV.GetLivrs().get(i).getISBN_LV()%>">
	<%
	}
	
	out.println("</div>");
	out.println("</div>");
	out.println("</section>");
	out.println("<div class='swiper featured-slider'>");
	%>
<!-- featured section ends -->





<!-- footer section starts  -->

<section class="footer">

		<div class="box-container">

			<div class="box">
				<h3>nos localisations</h3>
				<a href="#"> <i class="fas fa-map-marker-alt"></i> Guelma
				</a> <a href="#"> <i class="fas fa-map-marker-alt"></i> Annaba
				</a> <a href="#"> <i class="fas fa-map-marker-alt"></i> Constantine
				</a> <a href="#"> <i class="fas fa-map-marker-alt"></i> Khanchela
				</a>
			</div>

			<div class="box">
				<h3>Nos contacts</h3>
				<a href="#"> <i class="fas fa-phone"></i> +213 660 69 97 96
				</a> <a href="#"> <i class="fas fa-phone"></i> +213 660 93 43 16
				</a> <a href="#"> <i class="fas fa-envelope"></i>
					tebaibiaislam0@gmail.com
				</a> <a href="#"> <i class="fas fa-envelope"></i>
					tahachenaa@gmail.com
				</a><br><br><br> <img src="image/worldmap.png" class="map" alt="">
			</div>

		</div>

		<div class="share">
			<a href="https://www.facebook.com/GT63s" class="fab fa-facebook-f"></a>
			<a href="https://www.instagram.com/anaqine/" class="fab fa-instagram"></a>
			<a href="https://web.telegram.org" class="fab fa-telegram"></a>
		</div>
		
	</section>
<!-- footer section ends -->

<!-- loader  -->

<div class="loader-container">
    <img src="image/loader-img.gif" alt="">
</div>

<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
<!-- custom js file link  -->
<script src="js/script.js"></script>
</body>
</html>