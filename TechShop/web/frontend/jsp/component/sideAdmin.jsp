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
                        <span class="pcoded-mtext">Product List</span>
                    </a>
                </li>
            </ul>
        </c:if>

    </div>
</nav>