<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../component/top.jsp"></jsp:include>
    <script>
        function homeSubmit() {
            document.getElementById("hi").submit();
        }
        ;
    </script>
    <!-- Hero Start -->
    <div class="container-fluid bg-primary py-5 hero-header mb-5">
        <div class="row py-3">
            <div class="col-12 text-center">
                <h1 class="display-3 text-white animated zoomIn">Nhat Minh Store</h1>
                <a href="home" class="h4 text-white">Home</a>
                <i class="far fa-circle text-white px-2"></i>
                <a href="#" class="h4 text-white">Product</a>
            </div>
        </div>
    </div>
    <!-- Hero End -->


    <!-- Product Start -->
    <div class="container-fluid py-5 wow fadeInUp" data-wow-delay="0.1s">
        <div class="container">
            <form action="home" method="GET" id="hi">
                <div class="row mb-5 p-5" style="background-color: var(--primary) ; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">

                    <div class="col-lg-3">

                        <select class="form-select p-2" name="bid" onchange="homeSubmit()">
                            <option value="">
                                All Brand
                            </option>
                        <c:forEach items="${requestScope.brands}" var="b">
                            <c:if test="${requestScope.bid eq b.id}">
                                <option value="${b.id}" selected="selected">
                                    ${b.name}
                                </option>
                            </c:if>
                            <c:if test="${requestScope.bid ne b.id}">
                                <option value="${b.id}">
                                    ${b.name}
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-3">
                    <select class="form-select p-2" name="cid" onchange="homeSubmit()">
                        <option value="">
                            All Category
                        </option>
                        <c:forEach items="${requestScope.categorys}" var="c">
                            <c:if test="${requestScope.cid eq c.id}">
                                <option value="${c.id}" selected="selected">
                                    ${c.name}
                                </option>
                            </c:if>
                            <c:if test="${requestScope.cid ne c.id}">
                                <option value="${c.id}">
                                    ${c.name}
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-3">
                    <select class="form-select p-2" name="tid" onchange="homeSubmit()">
                        <option value="">
                            All Technology
                        </option>
                        <c:forEach items="${requestScope.technologys}" var="t">
                            <c:if test="${requestScope.tid eq t.id}">
                                <option value="${t.id}" selected="selected">
                                    ${t.name}
                                </option>
                            </c:if>
                            <c:if test="${requestScope.tid ne t.id}">
                                <option value="${t.id}">
                                    ${t.name}
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-3">
                    <select class="form-select p-2" name="size" onchange="homeSubmit()">
                        <option value="0">
                            All Size
                        </option>
                        <c:forEach items="${requestScope.products}" var="s">
                            <c:if test="${requestScope.size eq s.size}">
                                <option value="${s.size}" selected="selected">
                                    ${s.size}
                                </option>
                            </c:if>
                            <c:if test="${requestScope.size ne s.size}">
                                <option value="${s.size}">
                                    ${s.size}
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-lg-3">
                    <div class="row">
                        <div class="col-lg-9">
                            <input type="hidden" name="tid" value="${requestScope.tid}">
                            <input type="hidden" name="cid" value="${requestScope.cid}">
                            <input type="hidden" name="bid" value="${requestScope.bid}">
                            <input type="hidden" name="size" value="${requestScope.size}">
                            <input type="search" class="form-control p-2" name="searchContent" value="${searchContent}" placeholder="Search a service">
                        </div>
                        <div class="col-lg-3">
                            <button type="submit" class="btn btn-dark p-2">Search</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <c:if test="${requestScope.products.size() eq 0}">
            <div class="row align-items-center text-center">
                <h1>
                    Can't found this products!!
                </h1>
            </div>

        </c:if>
        <c:if test="${requestScope.products.size() >1}">
            <div class="row g-5 wow fadeInUp" data-wow-delay="0.1s">

                <c:forEach items="${requestScope.products}" var="p" begin="${requestScope.Start}" end="${requestScope.End}">
                    <div class="col-lg-3">
                        <div class="row g-5">
                            <a href="productdetail?pid=${p.id}">
                                <div class="col-md-12 service-item wow zoomIn" data-wow-delay="0.3s">
                                    <div class="rounded-top overflow-hidden">
                                        <img class="img-fluid" src="${p.getImage()}">
                                    </div>
                                    <div class="position-relative bg-light rounded-bottom text-center p-4">
                                        <h5 class="m-0">${p.name}</h5>
                                    </div>
                                </div>
                            </a>
                            <div class="position-relative bg-light rounded-bottom text-center p-4">
                                <form action="addcard" method="GET">
                                    <input type="hidden" name="id" value="${p.id}"/>
                                    Quantity: <input type="number" name="quantity" value="1"/>
                                    <button type="submit" class="btn btn-primary waves-effect waves-light">Add to card</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
<!-- Product End -->
<div class="row">
    <div class="col-lg-4"></div>
    <div class="col-lg-4 text-center">
        <a class="btn btn-primary" href="home?page=${1}&bid=${bid}&cid=${cid}&tid=${tid}&searchContent=${searchContent}">Start</a>
        <c:if test="${page-2 >0}">
            <a class="btn btn-primary" href="home?page=${page-2}&bid=${bid}&cid=${cid}&tid=${tid}&searchContent=${searchContent}">${page-2}</a>
        </c:if>
        <c:if test="${page-1 >0}">
            <a class="btn btn-primary" href="home?page=${page-1}&bid=${bid}&cid=${cid}&tid=${tid}&searchContent=${searchContent}">${page-1}</a>
        </c:if>

        <a class="btn btn-dark" href="home?page=${page}&bid=${bid}&cid=${cid}&tid=${tid}&searchContent=${searchContent}">${page}</a>
        <c:if test="${page+1 <=totalPage}">
            <a class="btn btn-primary" href="home?page=${page+1}&bid=${bid}&cid=${cid}&tid=${tid}&searchContent=${searchContent}">${page+1}</a>
        </c:if>
        <c:if test="${page+2 <=totalPage}">
            <a class="btn btn-primary" href="home?page=${page+2}&bid=${bid}&cid=${cid}&tid=${tid}&searchContent=${searchContent}">${page+2}</a>
        </c:if>

        <a class="btn btn-primary" href="home?page=${totalPage}&bid=${bid}&cid=${cid}&tid=${tid}&searchContent=${searchContent}">End</a>
    </div>
    <div class="col-lg-4"></div>

</div>

<!-- Newsletter Start -->
<div class="container-fluid position-relative pt-5 wow fadeInUp" data-wow-delay="0.1s" style="z-index: 1;">
    <div class="container">
        <div class="bg-primary p-5">
        </div>
    </div>
</div>
<!-- Newsletter End -->

<jsp:include page="../component/bottom.jsp"></jsp:include>