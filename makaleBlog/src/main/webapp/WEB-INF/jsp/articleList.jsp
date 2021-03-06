<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<head>

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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

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
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
    <table class="w3-table w3-striped" border="1">
      <tr>
				<th>Makale Numarası:</th>
				<th>Makale Sahibi:</th>
				<th>Makale Başlığı:</th>
				<th>İçerik:</th>
				
	 </tr>
       
       
      	<c:forEach var="item" items="${listArticle }">
         
         <c:url var="deleteLink" value="/articleDelete">
         		<c:param name="articleId" value="${item.id}"/>
         </c:url>
     <tr>
     	<td>
			${item.id}
     	</td>
     	<td>
			${item.authorName}
     	</td><td>
			${item.articleTitle}
     	</td>
     	<td>
			<a href="articleView.html?id=${item.id}" style="color:blue">İçeriği için Tıklayın</a>
     	</td>
     	<td>
                         <a href="${deleteLink}" style="color:blue"
			          onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
					</td>

     </tr>
        
      
      
      
      
      </c:forEach>
     </table>  
       
        <hr>
        <!-- Pager -->
        <div class="clearfix">
          <a class="btn btn-primary float-right" href="articleAdd.html">Makale Ekle &rarr;</a>
        </div>
      </div>
    </div>
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
