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
                <a href="Reservation" class="h4 text-white">Card</a>
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
                                                <h4 style="margin-left: 350px">Product Detail</h4>

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
                                        <div class="card">
                                            <div class="card-header">
                                                <!-- Sort data And paging form End -->
                                            </div>
                                            <div class="row card-block">
                                                <div class="col-md-12">
                                                <c:if test="${requestScope.ok != null}">
                                                    <div style="color: green; margin-bottom: 70px; margin-left: 550px">
                                                        <h1>${requestScope.ok}</h1>
                                                        <a style="margin-left: -200px" href="myorderlist" class="btn btn-primary">Back</a>
                                                    </div>
                                                </c:if>
                                                <c:if test="${requestScope.ok == null}">
                                                    <c:if test="${requestScope.list != null}">
                                                        <c:forEach items="${requestScope.list}" var="o">
                                                            <div class="row">
                                                                <div class="col-3"></div>
                                                                <div class="col-6">
                                                                    <h6>Date: <fmt:formatDate type = "date" value = "${o.date}"/></h6>
                                                                </div>
                                                            </div>
                                                            <div class="row" style="margin-bottom: 70px">
                                                                <div class="col-3"></div>
                                                                <div class="col-6">
                                                                    <label class="label label-info">Status: </label>${o.status == false?"Not Payed":"Payed"}<br>
                                                                    Price: ${o.totalmoney}
                                                                </div>
                                                                <div class="col-3">
                                                                    <c:if test="${requestScope.ok == null}">
                                                                        <button type="button" data-toggle="tooltip" title="Detail" class="btn btn-primary btn-mini waves-effect waves-light">
                                                                            <a style="color: blue;" href="Pay?oid=${o.oid}">Payment</a>
                                                                        </button>
                                                                    </c:if>
                                                                    <c:if test="${requestScope.list != null}"></c:if>
                                                                </div>
                                                            </div>

                                                        </c:forEach>
                                                    </c:if>
                                                    <c:if test="${requestScope.list == null}">
                                                        <h4>No Record to display</h4>
                                                    </c:if>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- List view card end -->
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

<script>
    function deleteFeedback(id)
    {
        var result = confirm("Are you sure?");
        if (result)
        {
            window.location.href = "deleteorder?id=" + id;
        }
    }
</script>
<jsp:include page="../component/bottom.jsp"></jsp:include>
