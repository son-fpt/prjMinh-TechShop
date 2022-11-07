<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../component/top.jsp"></jsp:include>
    <!-- Hero Start -->
    <div class="container-fluid bg-primary py-5 hero-header mb-5">
        <div class="row py-3">
            <div class="col-12 text-center">
                <h1 class="display-3 text-white animated zoomIn">Nhat Minh Store</h1>
                <a href="home" class="h4 text-white">Home</a>
                <i class="far fa-circle text-white px-2"></i>
                <a href="#" class="h4 text-white">Card</a>
            </div>
        </div>
    </div>
    <!-- Hero End -->
    <div class="pcoded-main-container">
        <div class="pcoded-wrapper">
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
                                                <h4 style="margin-left: 350px">Card</h4>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Page-header end -->
                            <!-- Page body start -->
                            <div class="page-body">

                                <div class="row" >
                                    <div class="col-sm-12">
                                        <!-- Responsive integration table start -->
                                        <div class="card">
                                            <div class="card-block">
                                                <div class="row" style="margin-bottom: 70px">  
                                                    <div class="col-2"></div>
                                                    <div class="col-8">
                                                        <div class="row">
                                                            <label>
                                                                User:
                                                            </label>
                                                            <div>${requestScope.order.mail}</div>
                                                        <label>Date</label>
                                                        <div><fmt:formatDate type = "date" value = "${requestScope.order.date}"/></div>
                                                    </div>
                                                    <div class="row">
                                                        <label>List Item</label>
                                                        <c:forEach items="${requestScope.order.od}" var="s">
                                                            <table>
                                                                <tr>
                                                                    <td>
                                                                        <img src="${s.p.image}" alt="alt"/>
                                                                    </td>
                                                                    <td>
                                                                        <div class="col-12">
                                                                            <div>
                                                                                Name: ${s.p.name}
                                                                            </div>
                                                                            <div>
                                                                                Brand: ${s.p.brand.name}
                                                                            </div>
                                                                            <div>
                                                                                Size:${s.p.size}
                                                                            </div>
                                                                            <div>
                                                                                Category: ${s.p.cate.name}
                                                                            </div>
                                                                            <div>
                                                                                Price: ${s.p.price}
                                                                            </div>
                                                                            <div>
                                                                                Quantity: ${s.quantity}
                                                                            </div>
                                                                        </div>
                                                                    </td>
                                                                </tr>

                                                            </table> 
                                                        </c:forEach>
                                                        <div class="col-12">
                                                            <div class="row">
                                                                <div class="col-3">Total:</div>
                                                                <div class="col-5"></div> ${requestScope.order.totalmoney}
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <a class="btn btn-primary" href="Pay?oid=${requestScope.order.oid}">Payment</a>
                                                    </div>


                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Responsive integration table end -->
                                </div>
                            </div>
                        </div>
                        <!-- Page-body end -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../component/bottom.jsp"></jsp:include>
