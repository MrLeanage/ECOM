<%-- 
    Document   : product
    Created on : Mar 14, 2020, 9:09:32 AM
    Author     : dulshan
--%>

<%@page import="com.devzone.model.Product"%>
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
    <title>PYRAMID 3D Solutions | Product Details</title>

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

        <!-- Product Details Area Start -->
        <div class="single-product-area section-padding-100 clearfix">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-12">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb mt-50">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Home">Home</a></li>
                                <li class="breadcrumb-item"><a href="#${pageContext.request.contextPath}/Products">Shop Now</a></li>
                                <li class="breadcrumb-item"><a href="#">Product Details</a></li>
                            </ol>
                        </nav>
                    </div>
                </div>

                <div class="row">
                    <%
                    Product specificProduct = (Product)request.getAttribute("specificProduct");
                    {
                    %>
                    <div class="col-12 col-lg-7">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage1()%>);">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="1" style="background-image: url(<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage2()%>);">
                                    </li>
                                    <li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage3()%>);">
                                    </li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <a class="gallery_img" href="<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage1()%>">
                                            <img class="d-block w-100" src="<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage1()%>"  alt="First slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage2()%>">
                                           <img class="d-block w-100" src="<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage2()%>"  alt="Second slide">
                                        </a>
                                    </div>
                                    <div class="carousel-item">
                                        <a class="gallery_img" href="<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage3()%>">
                                            <img class="d-block w-100" src="<%="/ECOM-SERVER/public/resources/"+specificProduct.getpImage3()%>" alt="Third slide">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-5">
                        <div class="single_product_desc">
                            <!-- Product Meta Data -->
                            <div class="product-meta-data">
                                <div class="line"></div>
                                <p class="product-price">Rs <%=specificProduct.getpPrice()%>0</p>
                                    <h6><%=specificProduct.getpName()%></h6>
                                
                                <!-- Ratings & Review -->
                                <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                    <div class="ratings">
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                        <i class="fa fa-star" aria-hidden="true"></i>
                                    </div>
                                    <div class="review">
                                        <a href="#">Write A Review<p>(Currently Unavailable for this Item)</p></a>
                                    </div>
                                </div>
                                <!-- Avaiable -->
                                <p class="avaibility"><i class="fa fa-circle"></i> <%=specificProduct.getpAvailability()%></p>
                            </div>

                            <div class="short_overview my-5">
                                <p><%=specificProduct.getpDescription()%></p>
                            </div>
                            <div class="short_overview my-5">
                                <table>
                                        <td style="padding:5px;">Dimension  </td>
                                        <td>: <%=specificProduct.getpDimention()%></td>
                                    </tr>
                                    <tr>
                                        <td style="padding:5px;">Weight </td>
                                        <td>: <%=specificProduct.getpWeight()%></td>
                                    </tr>
                                    <tr>
                                        <td style="padding:5px;">Available Color  </td>
                                        <td>: <%=specificProduct.getpColor()%></td>
                                    </tr>
                                    <tr>
                                        <td style="padding:5px;">Material </td>
                                        <td>: <%=specificProduct.getpMaterial()%></td>
                                    </tr>
                                </table>
                                
                            </div>

                            <!-- Add to Cart Form -->
                            <form class="cart clearfix" action="<%=request.getContextPath()%>/Order/ProcessToCheckout?ItemNo=<%=specificProduct.getpID()%>" method="post">
                                <div class="cart-btn d-flex mb-50">
                                    <p>Qty</p>
                                    <div class="quantity">
                                        <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-caret-down" aria-hidden="true"></i></span>
                                        <input type="number" class="qty-text" id="qty" step="1" min="1" max="300" name="Quantity" value="1">
                                        <input type="hidden" name="Price" value="<%=specificProduct.getpPrice()%>">
                                        <input type="hidden" name="Name" value="<%=specificProduct.getpName()%>">
                                        <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-caret-up" aria-hidden="true"></i></span>
                                    </div>
                                </div>
                                <button type="submit" name="addtocart" value="5" class="btn amado-btn">Order This Item</button>
                            </form>

                        </div>
                    </div>
                    <% }
                    %>
                </div>
            </div>
        </div>
        <!-- Product Details Area End -->
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