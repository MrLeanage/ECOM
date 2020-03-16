<%-- 
    Document   : index
    Created on : Mar 14, 2020, 7:25:36 AM
    Author     : dulshan
--%>

<%@page import="com.devzone.model.Product"%>
<%@page import="java.util.ArrayList"%>
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
    <title>PYRAMID 3D Solutions | All Products </title>

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
                    <li class="active"><a href="${pageContext.request.contextPath}/Products">Shop Now</a></li>
                    <li><a href="${pageContext.request.contextPath}/Order/TrackLogin">Track Your Order</a></li>
                    <li><a href="${pageContext.request.contextPath}/Public/contact.html">Contact Us</a></li>
                </ul>
            </nav>
           
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100">
            </div>
            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="https://www.facebook.com/112160797011201/"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
        </header>
        <!-- Header Area End -->

        <!-- Product Catagories Area Start -->
        <div class="products-catagories-area clearfix">
            <div class="amado-pro-catagory clearfix">
                <%
                    ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
                    for(Product products : productList){
                %>
                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/Product?itemNo=<%=products.getpID()%>">
                        <img src="<%="/ECOM-SERVER/public/resources/"+products.getpImage1()%>" >
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            
                            <p>From Rs <%=products.getpPrice()%>0</p>
                            <h4><%=products.getpName()%></h4>
                            <div class="ratings" style="color: yellow;">  
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        
                            </div>
                            
                        </div>
                    </a>
                                    
                </div>
                <% }
                %>
                
            </div>
        </div>
        <!-- Product Catagories Area End -->
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
                                        <li class="nav-item active">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/Products">Shop</a>
                                        </li>
                                        <li class="nav-item">
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