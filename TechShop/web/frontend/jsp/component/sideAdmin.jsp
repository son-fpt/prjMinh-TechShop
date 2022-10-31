<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<nav class="pcoded-navbar">

    <div class="pcoded-inner-navbar main-menu">
        <div class="pcoded-navigatio-lavel">Go to homepage</div>
        <ul class="pcoded-item pcoded-left-item">
            <li class="">
                <a href="${pageContext.request.contextPath}/home">
                    <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
                    <span class="pcoded-mtext">Homepage</span>
                </a>
            </li>

        </ul>
        <c:if test="${sessionScope.account.role.id == 1}">
            <div class="pcoded-navigatio-lavel">Admin</div>
            <ul class="pcoded-item pcoded-left-item">
                <li class="">
                    <a href="${pageContext.request.contextPath}/user/list">
                        <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
                        <span class="pcoded-mtext">User List</span>
                    </a>
                </li>
                <li class=" ">
                    <a href="${pageContext.request.contextPath}/product/list">
                        <span class="pcoded-micon"><i class="feather icon-aperture rotate-refresh"></i></span>
                        <span class="pcoded-mtext">Sliders List</span>
                    </a>
                </li>
            </ul>



        </c:if>
        <c:if test="${sessionScope.account.role.id == 2}">
            <div class="pcoded-navigatio-lavel">Manager</div>
            <ul class="pcoded-item pcoded-left-item">



                <li class=" ">
                    <a href="${pageContext.request.contextPath}/service/list">
                        <span class="pcoded-micon"><i class="feather icon-aperture rotate-refresh"></i><b>A</b></span>
                        <span class="pcoded-mtext">Services List</span>
                    </a>
                </li>
                <li class=" ">
                    <a href="${pageContext.request.contextPath}/manager/postslist">
                        <span class="pcoded-micon"><i class="feather icon-cpu"></i></span>
                        <span class="pcoded-mtext">Posts List</span>
                    </a>
                </li>
                <li class=" ">
                    <a href="${pageContext.request.contextPath}/manager/customerslist">
                        <span class="pcoded-micon"><i class="feather icon-aperture rotate-refresh"></i></span>
                        <span class="pcoded-mtext">Customers List</span>
                    </a>
                </li>
                <li class=" ">
                    <a href="${pageContext.request.contextPath}/manager/doctor">
                        <span class="pcoded-micon"><i class="feather icon-cpu"></i></span>
                        <span class="pcoded-mtext">Doctors List</span>
                    </a>
                </li>
                <li class=" ">
                    <a href="${pageContext.request.contextPath}/mfeedback/list">
                        <span class="pcoded-micon"><i class="feather icon-cpu"></i></span>
                        <span class="pcoded-mtext">Feedbacks List</span>
                    </a>
                </li>
                <li class=" ">
                    <a href="${pageContext.request.contextPath}/medicine/list">
                        <span class="pcoded-micon"><i class="feather icon-aperture rotate-refresh"></i></span>
                        <span class="pcoded-mtext">Medicine List</span>
                    </a>
                </li>




            </ul>
        </c:if>
        <c:if test="${sessionScope.account.role.id == 3}">
            <div class="pcoded-navigatio-lavel">Receptionist</div>
            <ul class="pcoded-item pcoded-left-item">

                <li class=" ">
                    <a href="${pageContext.request.contextPath}/reservation/add">
                        <span class="pcoded-micon"><i class="feather icon-edit-1"></i></span>
                        <span class="pcoded-mtext">Reservations List</span>
                    </a>
                </li>

            </ul>
            <div class="pcoded-navigatio-lavel">Doctors</div>
            <ul class="pcoded-item pcoded-left-item">
                <li class="">
                    <a href="${pageContext.request.contextPath}/medicine/list">
                        <span class="pcoded-micon"><i class="feather icon-edit"></i></span>
                        <span class="pcoded-mtext">Medicine Management</span>
                    </a>
                </li>
            </ul>
        </c:if>

    </div>
</nav>