

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../component/top.jsp"></jsp:include>

        <!-- Full Screen Search Start -->
        <div class="modal fade" id="searchModal" tabindex="-1">
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" style="background: rgba(9, 30, 62, .7);">
                    <div class="modal-header border-0">
                        <button type="button" class="btn bg-white btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body d-flex align-items-center justify-content-center">
                        <div class="input-group" style="max-width: 600px;">
                            <input type="text" class="form-control bg-transparent border-primary p-3" placeholder="Type search keyword">
                            <button class="btn btn-primary px-4"><i class="bi bi-search"></i></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Full Screen Search End -->


        <!-- Hero Start -->
        <div class="container-fluid bg-primary py-5 hero-header mb-5">
            <div class="row py-3">
                <div class="col-12 text-center">
                    <h1 class="display-3 text-white animated zoomIn">Change Password</h1>
                    <a href="" class="h4 text-white">User</a>
                    <i class="far fa-circle text-white px-2"></i>
                    <a href="" class="h4 text-white">Change Password</a>
                </div>
            </div>
        </div>
        <!-- Hero End -->


        <!-- Appointment Start -->
        <div class="container-fluid bg-primary bg-appointment mb-5 wow fadeInUp" data-wow-delay="0.1s" style="margin-top: 90px;">
            <div class="container">
                <div class="row gx-5">
                    <div class="col-lg-6 py-5">
                        <div class="py-5">
                            <h1 class="display-5 text-white mb-4">     Change Password</h1>
                            <p class="text-white mb-0">${requestScope.error} Please enter current password and new password to change password. </p>

                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="appointment-form h-100 d-flex flex-column justify-content-center text-center p-5 wow zoomIn" data-wow-delay="0.6s">
                            <h1 class="text-white mb-4"></h1>
                            <form action="changePassword" method="post"> 
                                <div class="row g-3">

                                    <div class="col-12 col-sm-12">
                                        <input type="password" id="password" name="currentPassword" required class="form-control bg-light border-0" placeholder="Current Password" style="height: 55px;">
                                    </div>
                                    <div class="col-12 col-sm-12">
                                        <input type="password" id="newPassword" name="newPassword" required class="form-control bg-light border-0" placeholder="New Password" style="height: 55px;">
                                    </div>
                                    <div class="col-12 col-sm-12">
                                        <input type="password" id="confirmPassword" name="confirmPassword" required class="form-control bg-light border-0" placeholder="Confirm Password " style="height: 55px;">
                                    </div>

                                    <div class="col-12">
                                        <button class="btn btn-dark w-100 py-3" type="submit">Submit</button>
                                    </div>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Appointment End -->


        <jsp:include page="../component/bottom.jsp"></jsp:include>
