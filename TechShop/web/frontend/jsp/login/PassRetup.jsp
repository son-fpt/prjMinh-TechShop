
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../component/top.jsp"></jsp:include>
    

            <!-- Hero Start -->
            <div class="container-fluid bg-primary py-5 hero-header mb-5">
                <div class="row py-3">
                    <div class="col-12 text-center">
                        <h1 class="display-3 text-white animated zoomIn">Password Setup</h1>
                        <a href="home" class="h4 text-white">Home</a>
                        <i class="far fa-circle text-white px-2"></i>
                        <a href="Login" class="h4 text-white">Login</a>
                    </div>
                </div>
            </div>
            <!-- Hero End -->
            <!-- Banner Start -->
            <div class="container-fluid banner mb-5" style="margin-top: 90px;margin-bottom: 150px">
                <div class="container">
                    <div class="row gx-0">
                        <div class="col-lg-4 wow zoomIn" data-wow-delay="0.1s">
                            <div class="bg-primary d-flex flex-column p-5" style="height: 300px;">
                                <h3 class="text-white mb-3">Password Request Must</h3>
                                <div class="d-flex justify-content-between text-white mb-3">

                                    <p class="mb-0">Uppercase, Lowercase</p>
                                </div>
                                <div class="d-flex justify-content-between text-white mb-3">

                                    <p class="mb-0">No white space</p>
                                </div>
                                <div class="d-flex justify-content-between text-white mb-3">

                                    <p class="mb-0">At least 8 characters</p>
                                </div>

                            </div>
                        </div>
                        <div class="col-lg-4 wow zoomIn" data-wow-delay="0.3s">
                            <form action="EnterNewPass" method="POST">
                                <div class="bg-dark d-flex flex-column p-5" style="height: 300px;">

                                    <h3 class="text-white mb-3">Enter The Code</h3>
                                    <div class="date mb-3" data-target-input="nearest">
                                        <input type="text" name="randomPass" class="form-control bg-light border-0" placeholder="Code" style="height: 40px;">
                                    </div>
                                    <div class="date mb-3" data-target-input="nearest">
                                        <input type="password" name="password" class="form-control bg-light border-0" placeholder="New Password" style="height: 40px;">
                                    </div>
                                    <div class="date mb-3" data-target-input="nearest">
                                        <input type="password" name="confirmPassword" class="form-control bg-light border-0" placeholder="Confirm Password" style="height: 40px;">
                                    </div>
                                    <button type="submit" class="btn btn-light">Submit</button>

                                </div>
                                <h5 style="color: #664d03;text-align: center">${requestScope.confirmFailed}</h5>

                            <h5 style="color: #664d03;text-align: center">${requestScope.notCorrect}</h5>

                            <h5 style="color: #664d03;text-align: center">${requestScope.error}</h5></form>
                    </div>
                    <div class="col-lg-4 wow zoomIn" data-wow-delay="0.6s">
                        <div class="bg-secondary d-flex flex-column p-5" style="height: 300px;">
                            <h3 class="text-white mb-3">Pleased to serve you.</h3>
                            <p class="text-white">This page will be up and running within 2 minutes. After 2 minutes you will have access again</p>
                            <h2 class="text-white mb-0">Number: +012 345 6789</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Banner Start -->

        <!-- Newsletter Start -->
        <div class="container-fluid position-relative pt-5 wow fadeInUp" data-wow-delay="0.1s" style="z-index: 1;">
            <div class="container">
                <!--            <div class="bg-primary p-5">
                                <form class="mx-auto" style="max-width: 600px;">
                                    <div class="input-group">
                                        <h4 style="text-align: center">Have Nice Day</h4>
                                    </div>
                                </form>
                            </div>-->
            </div>
        </div>
        <!-- Newsletter End -->
    </body>
    <jsp:include page="../component/bottom.jsp"></jsp:include>
</html>
