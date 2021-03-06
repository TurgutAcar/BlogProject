<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<head>
<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>


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
  <div class="container">
   <form:form action="articleUpdate" modelAttribute="article" commandName="article" method="POST">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Makale Başlığı:</td>
				<td>
					<form:input cssStyle="width:550px;" id="articleTitle" path="articleTitle"/> 
					<form:errors path="articleTitle" cssClass="text-danger"/> 
				</td>
			</tr>
			<tr>
				<td>Makale Konu Basligi:</td>
				<td>
					<form:input cssStyle="width:550px;" id="articleSubTitle" path="articleSubTitle"/> 
					<form:errors path="articleSubTitle" cssClass="text-danger"/> 
				</td>
			</tr>
		<tr>
	             <td>Makale Tarihi:</td>
				
				<td>
				<form:input id="articleDate" path="articleDate"/> 
					<form:errors path="articleDate"/> 
				</td>
			</tr>
			<tr>
				<td>Makale İçeriği</td>
				<td>
					<form:textarea path="articleContent" class="ckeditor"/>
					<form:errors path="articleContent"/> 
				</td>
			</tr>
			<tr>
			<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> </td>
			</tr>
			
			<tr>
                <td colspan="2" align="center"><input type="submit" value="Kaydet"></td>
            </tr>
		</table>
	</form:form>
   
   
   
   
   </div>
   
   
  <hr>

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
