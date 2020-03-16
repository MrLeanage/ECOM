<%-- 
    Document   : checkout
    Created on : Mar 14, 2020, 9:11:30 AM
    Author     : dulshan
--%>

<%@page import="com.devzone.model.TrackOrder"%>
<%@page import="com.devzone.model.Product"%>
<%@page import="com.devzone.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>PYRAMID 3D Solutions | Track Order</title>

    <!-- Favicon  -->
     <link rel="icon" href="${pageContext.request.contextPath}/Public/img/core-img/favicon.png">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Public/css/core-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Public/style.css">

</head>

<body>
    

    <!-- ##### Main Content Wrapper Start ##### -->
    <div class="main-content-wrapper d-flex clearfix">

        <!-- Mobile Nav (max width 767px)-->
        <div class="mobile-nav">
            <!-- Navbar Brand -->
            <div class="amado-navbar-brand">
                <a href="${pageContext.request.contextPath}/Home"><img src="${pageContext.request.contextPath}/Public/img/core-img/logo.png" alt=""></a>
            </div>
            <!-- Navbar Toggler -->
            <div class="amado-navbar-toggler">
                <span></span><span></span><span></span>
            </div>
        </div>

        <!-- Header Area Start -->
        <header class="header-area clearfix">
            <!-- Close Icon -->
            <div class="nav-close">
                <i class="fa fa-close" aria-hidden="true"></i>
            </div>
            <!-- Logo -->
            <div class="logo">
                <a href="${pageContext.request.contextPath}/Home"><img src="${pageContext.request.contextPath}/Public/img/core-img/logo.png" alt=""></a>
            </div>
            <!-- Amado Nav -->
            <nav class="amado-nav">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/Products">Shop Now</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/Order/TrackLogin">Track Your Order</a></li>
                    <li><a href="${pageContext.request.contextPath}/Public/contact.html">Contact Us</a></li>
                </ul>
            </nav>
            
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100"></div>
            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="https://www.facebook.com/112160797011201/"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
        </header>
        <!-- Header Area End -->

        <div class="cart-table-area section-padding-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-8 border border-info">
                        <div class="checkout_details_area mt-50 clearfix ">

                            <div class="cart-title">
                                <h1>Your Order Tracking Information</h1>
                            </div>
                            <div class="col-12 col-lg-8">
                                <div class="cart-summary">
                                    <h5>Cart Total</h5>
                                    <%
                                        Product product = (Product)request.getAttribute("productInfo");
                                        Order order = (Order)request.getAttribute("orderInfo");
                                        TrackOrder trackOrder = (TrackOrder)request.getAttribute("trackInfo");
                                       {
                                    %>
                                    
                                        <ul class="summary-table">
                                            <li><span>Item ID:</span> <span><%=product.getpID()%></span></li>
                                            <li><span>Item Name:</span> <span><%=product.getpName()%></span></li>
                                            <li><span>Total Quantity:</span> <span><%=order.getoQuantity()%></span></li>
                                            <li><span>Order Subtotal:</span> <span>Rs <%=order.getoPrice()%>0</span></li>
                                            <li><span>Advance Payment Amount:</span> <span>Rs <%=order.getoAdAmount()%>0</span></li>
                                            <li><span>Order Processing Status:</span> <span><%=order.getoStatus()%></span></li>
                                        </ul>
                                    
                            
                        </div>
                    </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-4 border border-success">
                        <div class="cart-summary">
                            <h3>Your Order Tracking Info</h3>
                            <p>Please Save Your <b>Order Tracking Information</b> for future Order Status tracking purpose. Keep This information save with you till your order get Completed. </p>
                            <ul class="summary-table">
                                <li><span>Your Order ID:</span> <span><%=order.getoID()%></span></li>
                                <li><span>Your Tracking Code:</span> <span><%=trackOrder.gettCode()%></span></li>
                                 <li><span>Advance Payment Status:</span> <span><%=trackOrder.gettStatus()%></span></li>
                            </ul>
                            
                        </div>
                            <% }
                            %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Main Content Wrapper End ##### -->

    

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer_area clearfix">
        <div class="container">
            <div class="row align-items-center">
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-4">
                    <div class="single_widget_area">
                        <!-- Logo -->
                        
                        <!-- Copywrite Text -->
                        <p class="copywrite">PYRAMID 3D SOLUTIONS &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved.<br>Powered by <i class="fa fa-circle" aria-hidden="true"></i> by <a href="https://devzone.lk" target="_blank">DevZone LK</a></p>

                    </div>
                </div>
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-8">
                    <div class="single_widget_area">
                        <!-- Footer Menu -->
                        <div class="footer_menu">
                            <nav class="navbar navbar-expand-lg justify-content-end">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                                <div class="collapse navbar-collapse" id="footerNavContent">
                                    <ul class="navbar-nav ml-auto">
                                        
                                        <li class="nav-item ">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Home">Home</a>
                                        </li>
                                        <li class="nav-item ">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Products">Shop</a>
                                        </li>
                                        <li class="nav-item active">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Order/TrackLogin">Track Your Order</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Public/contact.html">Contact Us</a>
                                        </li>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area End ##### -->

    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
    <script src="${pageContext.request.contextPath}/Public/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="${pageContext.request.contextPath}/Public/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="${pageContext.request.contextPath}/Public/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="${pageContext.request.contextPath}/Public/js/plugins.js"></script>
    <!-- Active js -->
    <script src="${pageContext.request.contextPath}/Public/js/active.js"></script>

</body>

</html>