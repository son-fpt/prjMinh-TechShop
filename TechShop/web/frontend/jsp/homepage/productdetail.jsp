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
                <a href="home" class="h4 text-white">Product</a>
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
                                                <h4>Product Detail</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Page-header end -->
                            <!-- Page body start -->
                            <div class="page-body">

                                <div class="row">
                                    <div class="col-sm-12">
                                        <!-- Responsive integration table start -->
                                        <div class="card">
                                            <div class="card-block">
                                                <div class="row">
                                                    <div class="col-6">
                                                        <img src="${requestScope.product.image}" alt="alt"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-3">
                                                    <div>
                                                        <label>Name</label>
                                                        <div>${requestScope.product.name}</div>
                                                    </div>
                                                    <div>
                                                        <label>
                                                            Brand
                                                        </label>
                                                        <div>${requestScope.product.brand.name}</div>
                                                    </div>
                                                    <div>
                                                        <label>Size</label>
                                                        <div>${requestScope.product.size}</div>
                                                    </div>
                                                </div>
                                                <div class="col-3">
                                                    <div>
                                                        <label>Category</label>
                                                        <div>${requestScope.product.cate.name}</div>
                                                    </div>
                                                    <div>
                                                        <label>Technology</label>
                                                        <div>${requestScope.product.tech.name}</div>
                                                    </div>
                                                    <div>
                                                        <label>Price</label>
                                                        <div>${requestScope.product.price}</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-6"></div>
                                                <label>Description</label>
                                                <div>${requestScope.product.des}</div>
                                            </div>    
                                            <div class="row">
                                                <div class="col-6">
                                                    <div class="row">
                                                        <button class="btn btn-primary waves-effect waves-light">Add to card</button>
                                                    </div>
                                                   
                                                </div>
                                            </div>
                                            <!--                                                <div class="dt-responsive table-responsive">
                                                                                                <form method="GET" action="productdetail">
                                                                                                    <table id="responsive-reorder" class="table table-striped table-bordered nowrap">
                                                                                                        <tbody>
                                                                                                            <tr>
                                                                                                                
                                                                                                            </tr>
                                                                                                        </tbody>
                                                                                                    </table>
                                                                                                </form>
                                                                                            </div>-->
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