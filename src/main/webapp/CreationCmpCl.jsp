<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../image/Library.png">
    <title>create account</title>
    <style>
      @import url('https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap');

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
body{
  background: url(image/letter-bg.jpg);
  background-size: cover;
    background-attachment: fixed;
   background-position: center;
}
.wrapper{
  position: relative;
  top: 0cm;
  left: -2cm ;
  max-width: 500px;
  width: 100%;
  background: #fff;
  margin: 1.5cm 23cm ;
  box-shadow: 1px 1px 2px rgba(0,0,0,0.125);
  padding: 20px;
}

.wrapper .title{
  font-size: 24px;
  font-weight: 700;
  margin-bottom: 25px;
  color: #27ae60;
  text-transform: uppercase;
  text-align: center;
}

.wrapper .form{
  width: 100%;
}

.wrapper .form .inputfield{
  margin-bottom: 15px;
  display: flex;
  align-items: center;
}

.wrapper .form .inputfield label{
   width: 200px;
   color: #757575;
   margin-right: 10px;
  font-size: 14px;
}

.wrapper .form .inputfield .input,
.wrapper .form .inputfield .textarea{
  width: 100%;
  outline: none;
  border: 1px solid #d5dbd9;
  font-size: 15px;
  padding: 8px 10px;
  border-radius: 3px;
  transition: all 0.3s ease;
}

.wrapper .form .inputfield .textarea{
  width: 100%;
  height: 125px;
  resize: none;
}

.wrapper .form .inputfield .custom_select{
  position: relative;
  width: 100%;
  height: 37px;
}

.wrapper .form .inputfield .custom_select:before{
  content: "";
  position: absolute;
  top: 12px;
  right: 10px;
  border: 8px solid;
  border-color: #d5dbd9 transparent transparent transparent;
  pointer-events: none;
}

.wrapper .form .inputfield .custom_select select{
  -webkit-appearance: none;
  -moz-appearance:   none;
  appearance:        none;
  outline: none;
  width: 100%;
  height: 100%;
  border: 0px;
  padding: 8px 10px;
  font-size: 15px;
  border: 1px solid #d5dbd9;
  border-radius: 3px;
}


.wrapper .form .inputfield .input:focus,
.wrapper .form .inputfield .textarea:focus,
.wrapper .form .inputfield .custom_select select:focus{
  border: 1px solid #27ae60;
}

.wrapper .form .inputfield p{
   font-size: 14px;
   color: #757575;
}
.wrapper .form .inputfield .check{
  width: 15px;
  height: 15px;
  position: relative;
  display: block;
  cursor: pointer;
}
.wrapper .form .inputfield .check input[type="checkbox"]{
  position: absolute;
  top: 0;
  left: 0;
  opacity: 0;
}
.wrapper .form .inputfield .check .checkmark{
  width: 15px;
  height: 15px;
  border: 1px solid #27ae60;
  display: block;
  position: relative;
}
.wrapper .form .inputfield .check .checkmark:before{
  content: "";
  position: absolute;
  top: 1px;
  left: 2px;
  width: 5px;
  height: 2px;
  border: 2px solid;
  border-color: transparent transparent #fff #fff;
  transform: rotate(-45deg);
  display: none;
}
.wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark{
  background: #27ae60;
}

.wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark:before{
  display: block;
}

.wrapper .form .inputfield .btn{
  width: 100%;
   padding: 8px 10px;
  font-size: 15px; 
  border: 0px;
  background:  #27ae60;
  color: #fff;
  cursor: pointer;
  border-radius: 3px;
  outline: none;
}

.wrapper .form .inputfield .btn:hover{
  background: #27ae60;
}

.wrapper .form .inputfield:last-child{
  margin-bottom: 0;
}

.btndomicile{
  position: relative;
  left: 2cm ;
  top: 2cm;
  padding: 8px 10px;
  font-size: 15px; 
  background:  #27ae60;
  color: #fff;
  border-radius: 3px;
  text-decoration: none;
}

.btndomicile:hover{
  background:  #fff;
  color: #27ae60;
}


.btndomicile:active{
  background:  #ff0000;
  color: rgb(255, 255, 255);
}





@media (max-width:420px) {
  .wrapper .form .inputfield{
    flex-direction: column;
    align-items: flex-start;
  }
  .wrapper .form .inputfield label{
    margin-bottom: 5px;
  }
  .wrapper .form .inputfield.terms{
    flex-direction: row;
  }
}


@media (max-width:768px){

  .wrapper{
    position: relative;
    top: -0.1cm;
    left: -20cm;
  }

}


@media (max-width:450px){


  body{
    background: none ;
  }
  .wrapper{
    position: relative;
    margin-top: 0px;
  }

}
    </style>
</head>
<body>
   <div>
      <a href="PPavantSr.jsp"><button class="btndomicile">domicile</button></a>
   </div>	
    <div class="wrapper">
        <div class="title">
          creation de votre compte
        </div>
        <form action="CreationCL" method="post">
          <div class="form">
           <div class="inputfield">
              <label>nom</label>
              <input type="text" class="input" name="nom1">
           </div>  
            <div class="inputfield">
              <label>prenom   </label>
              <input type="text" class="input" name="prenom1">
           </div>  
           <div class="inputfield">
            <label>date de naissance :</label>
            <input type="date" class="input" name="dateN1"> 
          </div> 
          <div class="inputfield">
          <label>nemuro de telephone</label>
          <input type="number" class="input" name="NmrT1" >
          </div>
          <div class="inputfield">
            <label>pay de residence</label>
            <input type="text" class="input" name="pay">
          </div> 
          <div class="inputfield">
          <label>ville</label>
          <input type="text" class="input" name="ville">
          </div>
             <div class="inputfield">
              <label>Email</label>
              <input type="email" class="input" name="email2">
           </div> 
           <div class="inputfield">
              <label>mot de passe</label>
              <input type="password" class="input" name="password2">
           </div>
           <div class="inputfield">
            <input type="submit" value="Register" class="btn">
           </div>				
           </form>
      	  </div>
</body>
</html>