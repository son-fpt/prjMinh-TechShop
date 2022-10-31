<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>Tech Shop</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com"/>
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet"/>

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet"/>

        <!-- Libraries Stylesheet -->
        <link href="${pageContext.request.contextPath}/frontend/assert/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/frontend/assert/lib/animate/animate.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/frontend/assert/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/frontend/assert/lib/twentytwenty/twentytwenty.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="${pageContext.request.contextPath}/frontend/assert/css/mycss/bootstrap.min.css" rel="stylesheet"/>

        <!-- Template Stylesheet -->
        <link href="${pageContext.request.contextPath}/frontend/assert/css/mycss/style.css" rel="stylesheet"/>

    </script>


</head>

<body>
    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm px-5 py-3 py-lg-0">
        <a href="home" class="navbar-brand p-0">
            <h1 class="m-0 text-primary"><img class="w-25 h-25" src="${pageContext.request.contextPath}/frontend/assert/img/Icon.ico" alt="">TechShop</h1>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto py-0">

                <a href="${pageContext.request.contextPath}/home" class="nav-item nav-link ${pageContext.request.getRequestURI().contains("home.jsp")?'active':''}">Home</a>
                <c:if test="${sessionScope.account ne null && sessionScope.account.role.id==3}">
                    <a href="${pageContext.request.contextPath}/Reservation" class="nav-item nav-link ${pageContext.request.getRequestURI().contains("Reservation")?'active':''}">Cart</a>
                    <a href="${pageContext.request.contextPath}/myorderlist" class="nav-item nav-link ${pageContext.request.getRequestURI().contains("myorderlist")?'active':''}">Order</a>
                </c:if>
                <c:if test="${sessionScope.account.role.id == 1}">
                    <a href="${pageContext.request.contextPath}/product/list" class="nav-item nav-link ${pageContext.request.getRequestURI().contains("product/list")?'active':''}">Administrator</a>
                </c:if> 
            </div>


            <c:if test="${sessionScope.account eq null}">
                <a href="login" class="btn btn-primary py-2 px-4 ms-3">Login</a>
            </c:if>
            <c:if test="${sessionScope.account ne null}">


                <div class="dropdown-primary dropdown">
                    <button class="btn btn-primary dropdown-toggle" id="userProfile" data-bs-toggle="dropdown" aria-expanded="false">

                        <span>Hi! ${sessionScope.account.name}</span>

                    </button>

                    <ul class="dropdown-menu row" aria-labelledby="userProfile">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/changePassword"><i class="bi bi-key"></i> Change Password</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i class="bi bi-key"></i>Logout</a></li>
                    </ul>

                </div>
                
            </c:if>


        </div>
    </nav>
    <!-- Navbar End -->