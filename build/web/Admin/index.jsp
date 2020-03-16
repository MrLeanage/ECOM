
<%--
  Created by IntelliJ IDEA.
  User: dulshan
  Date: 3/6/2020
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>



<%
    if (null != session.getAttribute("authenticatedUser")) {
        if (session.getAttribute("authenticatedUser").toString().equals(false)) {
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    } else {
        response.sendRedirect(request.getContextPath() + "/Login");
    }
%>
<%@page import="com.devzone.model.Order"%>
<%@page import="com.devzone.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>DevZone Admin</title>
    <%@include file="../Admin/includes/head.jsp"%>
</head>
<body>

<!--Header-part-->
<div id="header">
    <h1><a href="index.jsp">DevZone Admin</a></h1>
</div>
<!--close-Header-part-->


<!--top-Header-menu-->
<div id="user-nav" class=" navbar-inverse">
    <ul class="nav">
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href=""><i class=""></i> </a></li>
                <li class="divider"></li>
                <li><a href="<%=request.getContextPath()%>/Login"><i class="icon-key"></i> Log Out</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="3" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i></a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="<%=request.getContextPath()%>/Admin/Order"><i class="icon-envelope"></i> New Orders</a></li>
            </ul>
        </li>
    </ul>
</div>
<!--close-top-Header-menu-->
<!--sidebar-menu-->
<div id="sidebar"><a href="${pageContext.request.contextPath}/Order" class="visible-phone"><i class="icon icon-home"></i> Admin Dashboard</a>
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
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
    <!--breadcrumbs-->
    <div id="content-header">
        <div id="breadcrumb"> <a href="${pageContext.request.contextPath}/Order" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
    </div>
    <!--End-breadcrumbs-->

    <!--Action boxes-->
    
        <!--End-Action boxes-->

        <!--Chart-box-->
        <div class="row-fluid">
            <div class="widget-box">
                <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
                    <h5>Order Information</h5>
                </div>
                <div class="widget-content" >
                    <div class="row-fluid">
                        
                        <div class="span12">
                            <ul class="site-stats">
                                <li class="bg_lh"><i class="icon-user"></i> <strong>0</strong> <small>Total Completed Orders</small></li>
                                <li class="bg_lh"><i class="icon-plus"></i> <strong>Rs 0.00</strong> <small>Total Earnings</small></li>
                                <li class="bg_lh"><i class="icon-shopping-cart"></i> <strong>0</strong> <small>Total Items</small></li>
                                <li class="bg_lh"><i class="icon-tag"></i> <strong>0</strong> <small>Total Orders</small></li>
                                <li class="bg_lh"><i class="icon-repeat"></i> <strong>0</strong> <small>Pending Orders</small></li>
                                <li class="bg_lh"><i class="icon-globe"></i> <strong>0</strong> <small>Tracking Visits</small></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="widget-box">
                    <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
                        <h5>Data table</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table id="productTable" class="table table-bordered data-table">
                                <thead>
                                <tr>
                                    <th>OID</th>
                                    <th>PID</th>
                                    <th>Quantity</th>
                                    <th>Customer Name</th>
                                    <th>Contact</th>
                                    <th>Order Price</th>
                                    <th>Order Status</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <%  ArrayList<Order> orderList = (ArrayList<Order>)request.getAttribute("OrderList");
                                        for(Order orders : orderList){
                                    %>
                                    <tr class="gradeX" style="cursor:pointer; ">
                                    
                                    <td><%=orders.getoID()%></td>
                                    <td><%=orders.getoPID()%></td>
                                    <td><%=orders.getoQuantity()%></td>
                                    <td><%=orders.getoCName()%></td>
                                    <td><%=orders.getoCPhone()%></td>
                                    <td>Rs <%=orders.getoPrice()%>0</td>
                                    <td ><%=orders.getoStatus()%></td>
                                    <td>
                                        <div class="btn-group">
                                            <button class="btn btn-info btn-mini" ><a style="color:white;" href="${pageContext.request.contextPath}/Order/OrderInfo?oID=<%=orders.getoID()%>"  >View Order</a></button>
                                        </div>
                                    </td>
                                </tr>
                                <% }
                                    %>
                                </tbody>
                            </table>
                    </div>
                </div>     
            <div class="widget-box">
                    <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>Form Elements</h5>
                    </div>
                    <div class="widget-content nopadding">
                        
                    </div>
                </div> 
        
        <!--End-Chart-box-->
        <hr/>
    </div>
    
</div>

<!--end-main-container-part-->

<!--Footer-part-->

<div class="row-fluid">
    <div id="footer" class="span12"> PYRAMID 3D SOLUTIONS &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved.<br>Powered by <i class="fa fa-circle" aria-hidden="true"></i> by <a href="https://devzone.lk/index-1" target="_blank">DevZone LK</a> </div>
</div>

<!--end-Footer-part-->

<%@include file="../Admin/includes/script.jsp" %>

<script type="text/javascript">
    // This function is called from the pop-up menus to transfer to
    // a different page. Ignore if the value returned is a null string:
    function goPage (newURL) {

        // if url is empty, skip the menu dividers and reset the menu selection to default
        if (newURL != "") {

            // if url is "-", it is this page -- reset the menu:
            if (newURL == "-" ) {
                resetMenu();
            }
            // else, send page to designated URL
            else {
                document.location.href = newURL;
            }
        }
    }

    // resets the menu selection upon entry to this page:
    function resetMenu() {
        document.gomenu.selector.selectedIndex = 2;
    }
</script>
</body>
</html>
