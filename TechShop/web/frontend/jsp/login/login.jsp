
<%--Chưa hiển thị được thông báo lỗi --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../component/top.jsp"></jsp:include>
  

            <!-- Hero End -->
        <c:if test="${requestScope.msg ne null}">
            <div style="" class="row text-center">
                <h3 style="color: red">${requestScope.msg}</h3>
            </div>
        </c:if>

        <!-- Appointment Start -->
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="">

            <div class="container">

                <div class="row py-3">
                    <div class="col-12 text-center">
                        <h1 class="display-3 text-white animated zoomIn">Account Login</h1>
                        <a href="" class="h4 text-white">Home</a>
                        <i class="far fa-circle text-white px-2"></i>

                        <a href="login" class="h4 text-white">Login</a>

                    </div>
                </div>

                <div class="row gx-5">
                    <div class="col-lg-3">

                    </div>
                    <div class="col-lg-6">
                        <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                            
                            <form action="login" method="POST">
                                <div class="row g-3">
                                    <div class="col-12 col-sm-6">
                                        <input type="email" name="email" class="form-control bg-light border-0" placeholder="Email" style="height: 55px;">
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <input type="password" name="password" minlength="8" class="form-control bg-light border-0" placeholder="Your Password" style="height: 55px;" required>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <div class="date" id="date1" data-target-input="nearest" class="form-control bg-light border-0">
                                            <a href="ResetPass" class="btn btn-dark w-100 py-3" style="color:white;font-size: 15px;background-color: #040e1e"><u>Forget password</u></a>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <div class="time" id="time1" data-target-input="nearest" >
                                            <a href="Registration" class="btn btn-dark w-100 py-3" style="color:white;font-size: 15px;background-color: #040e1e"><u>User Registration</u></a>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <h5 style="color: #664d03;">${requestScope.failed}</h5>
                                        <button class="btn btn-dark w-100 py-3" type="submit">Login</button>
                                    </div>

                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-3">

                    </div>
                </div>
            </div>
        </div>
        <!-- Appointment End -->


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
