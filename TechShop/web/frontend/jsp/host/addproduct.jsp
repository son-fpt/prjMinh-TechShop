

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Admin - Nhat Minh Store </title>
        <!-- Meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="#">
        <meta name="keywords" content="flat ui, admin Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
        <meta name="author" content="#">
        <!-- Favicon icon -->
        <link rel="icon" href="..\frontend\assert\libAdmin\assets\images\favicon.ico" type="image/x-icon">
        <!-- Google font-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
        <!-- Required Fremwork -->
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\bower_components\bootstrap\css\bootstrap.min.css">
        <!-- themify-icons line icon -->
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\assets\icon\themify-icons\themify-icons.css">
        <!-- ico font -->
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\assets\icon\icofont\css\icofont.css">
        <!-- feather Awesome -->
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\assets\icon\feather\css\feather.css">
        <!-- Data Table Css -->
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\bower_components\datatables.net-bs4\css\dataTables.bootstrap4.min.css">
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\assets\pages\data-table\css\buttons.dataTables.min.css">
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\bower_components\datatables.net-responsive-bs4\css\responsive.bootstrap4.min.css">

        <!-- Style.css -->
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\assets\css\style.css">
        <link rel="stylesheet" type="text/css" href="..\frontend\assert\libAdmin\assets\css\jquery.mCustomScrollbar.css">
        <link rel="stylesheet" href="..\frontend\assert\libAdmin\assets\scss\partials\menu\_pcmenu.htm">
        <!-- JS Pager -->
        <script src="../frontend/assert/libAdmin/assets/js/pager.js" type="text/javascript"></script>
        <!-- Style Pager -->
        <link href="../frontend/assert/libAdmin/assets/css/pagerstyle.css" rel="stylesheet" type="text/css"/>
        <!-- Font Awesome Icon Library -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <!-- Pre-loader start -->
        <div class="theme-loader">
            <div class="ball-scale">
                <div class='contain'>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                    <div class="ring">
                        <div class="frame"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Pre-loader end -->
        <div id="pcoded" class="pcoded">
            <div class="pcoded-overlay-box"></div>
            <div class="pcoded-container navbar-wrapper">

                <nav class="navbar header-navbar pcoded-header">
                    <div class="navbar-wrapper">

                        <div class="navbar-logo">
                            <a class="mobile-menu" id="mobile-collapse" href="#!">
                                <i class="feather icon-menu"></i>
                            </a>
                            <a href="../home">
                                <img class="img-fluid" src="..\frontend\assert\libAdmin\assets\images\logo.png" alt="Theme-Logo">

                            </a>
                            <a class="mobile-options">
                                <i class="feather icon-more-horizontal"></i>
                            </a>
                        </div>

                        <div class="navbar-container container-fluid">
                            <ul class="nav-left">
                                <li class="header-search">
                                    <div class="main-search morphsearch-search">
                                        <div class="input-group">
                                            <span class="input-group-addon search-close"><i class="feather icon-x"></i></span>
                                            <input type="text" class="form-control">
                                            <span class="input-group-addon search-btn"><i class="feather icon-search"></i></span>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <a href="#!" onclick="javascript:toggleFullScreen()">
                                        <i class="feather icon-maximize full-screen"></i>
                                    </a>
                                </li>
                            </ul>
                            <ul class="nav-right">
                                <li class="user-profile header-notification">
                                    <div class="dropdown-primary dropdown">
                                        <div class="dropdown-toggle" data-toggle="dropdown">
                                            <span>${requestScope.account.name}</span>
                                            <i class="feather icon-chevron-down"></i>
                                        </div>
                                        <ul class="show-notification profile-notification dropdown-menu" data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
                                            <li>
                                                <a href="#!">
                                                    <i class="feather icon-settings"></i> Settings
                                                </a>
                                            </li>
                                            <li>
                                                <a href="user-profile.htm">
                                                    <i class="feather icon-user"></i> Profile
                                                </a>
                                            </li>
                                            <li>
                                                <a href="auth-normal-sign-in.htm">
                                                    <i class="feather icon-log-out"></i> Logout
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>


                <div class="pcoded-main-container">
                    <div class="pcoded-wrapper">
                        <jsp:include page="../component/sideAdmin.jsp"></jsp:include>
                            <div class="pcoded-content">
                                <div class="pcoded-inner-content">
                                    <!-- Main-body start -->
                                    <div class="main-body">
                                        <div class="page-wrapper">
                                            <!-- Page-header start -->
                                            <div class="page-header">
                                                <div class="row align-items-end">
                                                    <div class="col-lg-8">
                                                        <div class="page-header-title">
                                                            <div class="d-inline">
                                                                <h4>Product Manager</h4>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <div class="page-header-breadcrumb">
                                                            <ul class="breadcrumb-title">
                                                                <li class="breadcrumb-item">
                                                                    <a href="#"> <i class="feather icon-home"></i> </a>
                                                                </li>
                                                                <li class="breadcrumb-item"><a href="#!">Widget</a> </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Page-header end -->
                                            <!-- Page body start -->
                                            <div class="page-body">

                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <!-- List view card start -->
                                                        <div class="card">
                                                            <div class="row card-block">
                                                                <div class="col-md-12">
                                                                    <form action="add" method="POST" enctype="multipart/form-data">
                                                                        <div class="form-group row">
                                                                            <label class="col-sm-2 col-form-label">Category</label>
                                                                            <div class="col-sm-10">
                                                                                <select name="cate" class="form-control">
                                                                                <c:forEach items="${requestScope.listCategory}" var="c">
                                                                                    <option value="${c.id}">${c.name}</option>
                                                                                </c:forEach>
                                                                            </select>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Brand</label>
                                                                        <div class="col-sm-10">
                                                                            <select name="brand" class="form-control">
                                                                                <c:forEach items="${requestScope.listBrand}" var="b">
                                                                                    <option value="${b.id}">${b.name}</option>
                                                                                </c:forEach>
                                                                            </select>                                                                  
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Technology</label>
                                                                        <div class="col-sm-10">
                                                                            <select name="tech" class="form-control">
                                                                                <c:forEach items="${requestScope.listTech}" var="t">
                                                                                    <option value="${t.id}">${t.name}</option>
                                                                                </c:forEach>
                                                                            </select>                                                                  
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Product ID</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="text" name="pid" class="form-control" placeholder="Type product id" required/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Product Name</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="text" name="pname" class="form-control" placeholder="Type product name" required/>
                                                                        </div>
                                                                    </div>

                                                                    <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Size</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="number" name="size" class="form-control" placeholder="Type product size" required/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Price</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="number" name="price" class="form-control" placeholder="Type product price" required/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Upload Image</label>
                                                                        <div class="col-sm-10">
                                                                            <input type="file" name="image" class="form-control" required/>
                                                                        </div>
                                                                    </div>
                                                                        <div class="form-group row">
                                                                        <label class="col-sm-2 col-form-label">Product Description</label>
                                                                        <div class="col-sm-10">
                                                                            <textarea class="col-sm-2 col-form-label" name="des"></textarea>
                                                                        </div>
                                                                    </div>
                                                                    
                                                                    <input type="submit" class="btn btn-primary waves-effect waves-light" value="Submit">
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- List view card end -->
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Page-body end -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="styleSelector">

                        </div>
                    </div>
                </div>
            </div>
        </div> 

        <!-- Required Jquery -->
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\jquery\js\jquery.min.js"></script>
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\jquery-ui\js\jquery-ui.min.js"></script>
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\popper.js\js\popper.min.js"></script>
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\bootstrap\js\bootstrap.min.js"></script>
        <!-- jquery slimscroll js -->
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\jquery-slimscroll\js\jquery.slimscroll.js"></script>
        <!-- modernizr js -->
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\modernizr\js\modernizr.js"></script>
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\modernizr\js\css-scrollbars.js"></script>

        <!-- i18next.min.js -->
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\i18next\js\i18next.min.js"></script>
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\i18next-xhr-backend\js\i18nextXHRBackend.min.js"></script>
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\i18next-browser-languagedetector\js\i18nextBrowserLanguageDetector.min.js"></script>
        <script type="text/javascript" src="..\frontend\assert\libAdmin\bower_components\jquery-i18next\js\jquery-i18next.min.js"></script>
        <script src="..\frontend\assert\libAdmin\assets\js\pcoded.min.js"></script>
        <script src="..\frontend\assert\libAdmin\assets\js\vartical-layout.min.js"></script>
        <script src="..\frontend\assert\libAdmin\assets\js\jquery.mCustomScrollbar.concat.min.js"></script>
        <!-- Custom js -->

        <script type="text/javascript" src="..\frontend\assert\libAdmin\assets\js\script.js"></script>
        <!-- data-table js -->
        <script src="..\frontend\assert\libAdmin\bower_components\datatables.net\js\jquery.dataTables.min.js"></script>
        <script src="..\frontend\assert\libAdmin\bower_components\datatables.net-buttons\js\dataTables.buttons.min.js"></script>
        <script src="..\frontend\assert\assets\pages\data-table\js\jszip.min.js"></script>
        <script src="..\frontend\assert\assets\pages\data-table\js\pdfmake.min.js"></script>
        <script src="..\frontend\assert\assets\pages\data-table\js\vfs_fonts.js"></script>
        <script src="..\frontend\assert\libAdmin\bower_components\datatables.net-buttons\js\buttons.print.min.js"></script>
        <script src="..\frontend\assert\libAdmin\bower_components\datatables.net-buttons\js\buttons.html5.min.js"></script>
        <script src="..\frontend\assert\libAdmin\bower_components\datatables.net-bs4\js\dataTables.bootstrap4.min.js"></script>
        <script src="..\frontend\assert\libAdmin\bower_components\datatables.net-responsive\js\dataTables.responsive.min.js"></script>
        <script src="..\frontend\assert\libAdmin\bower_components\datatables.net-responsive-bs4\js\responsive.bootstrap4.min.js"></script>

        <!-- modernizr js -->
        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
        <script>

                                        window.dataLayer = window.dataLayer || [];

                                        function gtag() {
                                            dataLayer.push(arguments);
                                        }
                                        gtag('js', new Date());

                                        gtag('config', 'UA-23581568-13');

        </script>
    </body>
</html>
