

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../component/top.jsp"></jsp:include>
    

            <!-- Hero Start -->
            <div class="container-fluid bg-primary py-5 hero-header mb-5">
                <div class="row py-3">
                    <div class="col-12 text-center">
                        <h1 class="display-3 text-white animated zoomIn">Reset Password</h1>
                        <a href="home" class="h4 text-white">Home</a>
                        <i class="far fa-circle text-white px-2"></i>
                        <a href="Login" class="h4 text-white">Login</a>
                    </div>
                </div>
            </div>
            <!-- Hero End -->

            <!-- Banner Start -->
            <div class="container-fluid banner mb-5" style="margin-top: 90px">
                <div class="container">
                    <div class="row gx-0">
                        <div class="col-lg-4 wow zoomIn" data-wow-delay="0.1s">
                            <div class="bg-primary d-flex flex-column p-5" style="height: 300px;">
                                <h3 class="text-white mb-3">Guaranteed safety</h3>
                                <div class="d-flex justify-content-between text-white mb-3">

                                    <p class="mb-0">Email Registered</p>
                                </div>
                                <div class="d-flex justify-content-between text-white mb-3">

                                    <p class="mb-0"> Enter the correct verification code</p>
                                </div>
                                <div class="d-flex justify-content-between text-white mb-3">

                                    <p class="mb-0"> Gmail only works for 2 minutes</p>
                                </div>

                            </div>
                        </div>
                        <div class="col-lg-4 wow zoomIn" data-wow-delay="0.3s">
                            <form action="ResetPass" method="POST">
                                <div class="bg-dark d-flex flex-column p-5" style="height: 300px;">
                                    <h3 class="text-white mb-3">Please Enter Your Email</h3>
                                    <div class="date mb-3" data-target-input="nearest">
                                        <input type="email" name="email" class="form-control bg-light border-0" placeholder="Your Email" style="height: 40px;">
                                        <h5 style="color: #664d03;">${requestScope.notExist}</h5>
                                </div>
                                <button type="submit" class="btn btn-light">Submit</button>
                            </div></form>
                    </div>
                    <div class="col-lg-4 wow zoomIn" data-wow-delay="0.6s">
                        <div class="bg-secondary d-flex flex-column p-5" style="height: 300px;">
                            <h3 class="text-white mb-3">Pleased to serve you.</h3>
                            <p class="text-white">Customers can contact us directly via the call center.</p>
                            <h2 class="text-white mb-0">+012 345 6789</h2>
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
