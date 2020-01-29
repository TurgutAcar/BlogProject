<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">


<head>
<script language="JavaScript" type="text/javascript" src="<c:url value="/resources/js/passwordEqualityCheck.js" />"></script>



<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: white;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: black;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Clean Blog - Start Bootstrap Theme</title>

  <!-- Bootstrap core CSS -->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="resources/css/clean-blog.min.css" rel="stylesheet">

</head>
<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
 <c:if test="${pageContext.request.userPrincipal.name != null}">
								
				 					<c:url var="logoutUrl" value="/logout"/>
      <a class="navbar-brand" href="${logoutUrl}">Logout</a>	</c:if>
          <c:if test="${pageContext.request.userPrincipal.name == null}">
      <a class="navbar-brand" href="index.html">Ana Sayfa</a>      
          </c:if>      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
            <a class="nav-link" href="index.html">Home</a>
          </li>
            <li class="nav-item">
            <a class="nav-link" href="about.jsp">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">Contact</a>
          </li>
            <li class="nav-item">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a class="nav-link" href="memberRegister.jsp">Member Register</a>
            </c:if>
          </li>
            <li class="nav-item">
           <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a class="nav-link" href="articleAdd.html">Article Add</a>
            </c:if>
          </li>
          <li class="nav-item">
                      <c:if test="${pageContext.request.userPrincipal.name == null}">
          
            <a class="nav-link" href="login.jsp">Login</a>
            </c:if>
          </li>
           <li class="nav-item">
           <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a class="nav-link" href="articleList.html">Article List</a>
            </c:if>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('resources/img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>Clean Blog</h1>
            <span class="subheading">A Blog Theme by Start Bootstrap</span>
          </div>
        </div>
      </div>
    </div>
  </header>
  
  <!-- Main Content -->
 <div id=content>
 
   <form:form action="memberRegister" method="POST" ModelAttribute="member" commandName="member">
    <div class="container">
    <hr>
     <table> 
            <tr>
                <td>Adınız:</td>
                <td><form:input path="name" required="true"/></td>
            </tr>
            <tr>
                <td>Soyadınız:</td>
                <td><form:input path="surname" required="true"/></td>
            </tr>
            <tr>
                <td>Email Adresiniz:</td>
                <td><form:input path="emailAddress"  required="true"/></td>               
                <td><form:errors path="emailAddress"></form:errors> </td>
            </tr>
            <tr>
            	<td>Doğum Tarihiniz:</td>
            	<td> <form:input id="birthDate" path="birthDate" required="true"/></td>
            </tr>
            <tr>
                <td>Adresiniz:</td>
                <td><form:input path="address" required="true"/></td>
                <td> <form:errors path="address"></form:errors> </td>
                
            </tr>
            <tr>
                <td>Parolanız:</td>
                <td><form:input type="password" id="password" path="password" required="true"/></td>
            </tr>
            <tr>
                <td>Parolanızı Tekrar Girin:</td>
                <td>
                 <input type="password" id="passwordAgain" onblur="sameness('password','passwordAgain','Parolalar')" type="text">
                
                </td>
            </tr>
            <tr>
                <td>Telefon Numaranız:</td>
    					<td><form:input type="text" id="telephoneNumber" name="phone" path="telephoneNumber" 
       pattern="[0-9]{1}-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}"
       required="true"/>
      <br> <small>Format: 0-456-789-64-65</small>
       </td>

                
                
            </tr>
    
           <tr>
            	<td><p style="float:left;width:206px;margin-left:20px;font-family:Arial;font-size:14px;color:red;font-weight:bold;" id="warning_text"></p></td>
            </tr>
            <tr>
                <td><input  type="submit"  class="btn btn-primary float-right" value="Kaydet"></td>
           </tr>
           <tr>
               <td> <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
                </tr>
           </table>   
        </div>
        </form:form>
 </div>
 
 
 
 
    

  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <ul class="list-inline text-center">
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted">Copyright &copy; Your Website 2019</p>
        </div>
      </div>
    </div>
  </footer>
  <!-- Bootstrap core JavaScript -->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="resources/js/clean-blog.min.js"></script>

</body>

</html>
