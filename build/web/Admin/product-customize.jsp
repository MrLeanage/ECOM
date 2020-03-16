<%--
  Created by IntelliJ IDEA.
  User: dulshan
  Date: 3/6/2020
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>DevZone Admin</title>
    <%@include file="includes/head.jsp"%>
</head>
<body>

<!--Header-part-->
<div id="header">
    <h1><a href="index.jsp">DevZone Admin</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul>
        <li class="active"><a href="${pageContext.request.contextPath}/Order"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
        <li ><a href="${pageContext.request.contextPath}/Product"><i class="icon-shopping-cart"></i> <span>Products</span></a> </li>
        <li ><a ><i class="icon icon-list"></i> <span>Portfolio Customization<br>(feature Disabled)</span></a> </li>
        <li ><a ><i class="icon-globe"></i> <span>Track Order<br>(feature Disabled)</span></a> </li>
        <li ><a ><i class="icon-globe"></i> <span>Completed Orders<br>(feature Disabled)</span></a> </li>
        <li class="content"> <span>Disk Space Usage</span>
            <div class="progress progress-mini active progress-striped">
                <div style="width: 87%;" class="bar"></div>
            </div>
            <span class="percent" ><fmt:formatNumber type = "number" maxIntegerDigits = "3" value = "${(usage/2)*100}" />%</span>
            <div class="stat"> <fmt:formatNumber type = "number" maxIntegerDigits = "3" value = "${usage}" />/ 2 GB</div>
        </li>
        <li class="content"> <span>Local Time</span>
            <% 
            Date date = new Date();
            %>
            
            <div class="stat"><%=date.toString()%></div>
        </li>
        <li ><a href="${pageContext.request.contextPath}/Order"><i class="icon-globe"></i> <span>System Updates<br>(Not Available)</span></a> </li>

    </ul>
</div>
<!--close-top-Header-menu-->
<!--sidebar-menu-->

<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Admin Dashboard</a>
    <ul>
        <li ><a href="${pageContext.request.contextPath}/Order"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
        <li ><a href="${pageContext.request.contextPath}/Product"><i class="icon icon-home"></i> <span>Products</span></a> </li>
        <li class="active"><a href="${pageContext.request.contextPath}/Portfolio"><i class="icon icon-home"></i> <span>Portfolio Customization</span></a> </li>
    </ul>
</div>

<!--close-left-menu-stats-sidebar-->

<div id="content">
    <div id="content-header">
        <div id="breadcrumb"> <a href="${pageContext.request.contextPath}/Order" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>  <a href="${pageContext.request.contextPath}/Portfolio" class="current">Product Customization</a> </div>

    </div>
    <div class="container-fluid">

        <hr>
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title "> <span class="icon"><i class="icon-th"></i></span>
                        <h5>Customize Your Portfolio</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table   ">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Product Name</th>
                                <th class="right">Image 1 (Cover Image)</th>
                                <th class="right">Image 2 </th>
                                <th class="right">Image 3 </th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="gradeX">
                                <td>P001</td>
                                <td>Phone Cover</td>
                                <td>
                                   <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" height="200" width="200" alt="" > </a>
                                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                                </td>
                                <td>
                                   <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" height="200" width="200" alt="" > </a>
                                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                                </td>
                                <td>
                                   <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" height="200" width="200" alt="" > </a>
                                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <button class="btn btn-danger btn-mini" ><a style="color:white;" href="#"   >Delete</a></button>
                                    </div>
                                </td>
                            </tr>
                            <tr class="gradeX">
                                <td>P002</td>
                                <td>Phone Cover 2 </td>
                                <td>
                                   <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" height="200" width="200" alt="" > </a>
                                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                                </td>
                                <td>
                                   <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" height="200" width="200" alt="" > </a>
                                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                                </td>
                                <td>
                                   <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" height="200" width="200" alt="" > </a>
                                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <button class="btn btn-danger btn-mini" ><a style="color:white;" href="#"   >Delete</a></button>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                </div>
                <div class="widget-box">
                    <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>Product Colors</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <form action="<%=request.getContextPath()%>/list" method="POST" class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label">Available Color :</label>
                                <div class="controls">
                                    <input type="text" class="span11" placeholder="Color" />
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-success">Save</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!--Footer-part-->
<div class="row-fluid">
    <div id="footer" class="span12"> PYRAMID 3D SOLUTIONS &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved.<br>Powered by <i class="fa fa-circle" aria-hidden="true"></i> by <a href="https://devzone.lk/index-1" target="_blank">DevZone LK</a> </div>
</div>
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.ui.custom.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-colorpicker.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/jquery.toggle.buttons.js"></script>
<script src="js/masked.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/matrix.js"></script>
<script src="js/matrix.form_common.js"></script>
<script src="js/wysihtml5-0.3.0.js"></script>
<script src="js/jquery.peity.min.js"></script>
<script src="js/bootstrap-wysihtml5.js"></script>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.uniform.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/matrix.tables.js"></script>
<script>
    $('.textarea_editor').wysihtml5();
</script>
</body>
</html>