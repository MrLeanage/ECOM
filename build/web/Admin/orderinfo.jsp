<%--
  Created by IntelliJ IDEA.
  User: dulshan
  Date: 3/6/2020
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.devzone.model.TrackOrder"%>
<%@page import="java.util.Date"%>
<%@page import="com.devzone.model.Order"%>
<%@page import="com.devzone.model.Product"%>
<%@page import="java.util.ArrayList"%>
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
        <div id="breadcrumb"> <a href="${pageContext.request.contextPath}/Order" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>Specific Order Information</a></div>
    </div>
    <!--End-breadcrumbs-->

        <!--Chart-box-->
        <div class="row-fluid">
            <div class="widget-box">
                <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
                    <h5>Quick Widgets</h5>
                </div>
                <div class="widget-content" >
                    
                    <div class="row-fluid">
                        
                        <div class="span12">
                            <ul class="site-stats">
                                <li class="bg_lh"><i class="icon-user"></i> <strong>0</strong> <small>Total Completed Orders</small></li>
                                <li class="bg_lh"><i class="icon-plus"></i> <strong>Rs 0.00</strong> <small>Total Earnings</small></li>
                                <li class="bg_lh"><i class="icon-shopping-cart"></i> <strong>0</strong> <small>Total Items</small></li>
                                <li class="bg_lh"><i class="icon-tag"></i> <strong>0</strong> <small>Total Orders</small></li>
                                <li class="bg_lh"><i class="icon-repeat"></i> <strong>10</strong> <small>Pending Orders</small></li>
                                <li class="bg_lh"><i class="icon-globe"></i> <strong>0</strong> <small>Tracking Visits</small></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="span12">
                <div class="widget-box" >
        <div class="widget-title"> <span class="icon"> <i class="icon-picture"></i> </span>
            <h5>Order Information </h5>
          </div>
                    
        <%
            Product productData = (Product)request.getAttribute("productData");
            Order orderData = (Order)request.getAttribute("orderData");
            TrackOrder trackOrderData = (TrackOrder)request.getAttribute("trackOrderData");
            {
        %> 
          <div class="widget-content">
            <h5>Order ID : <%=orderData.getoID()%>  Customer : <%=orderData.getoCName()%></h5>
            <ul class="thumbnails ">
                <li class="span3"> <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" alt="" > </a>
                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                </li>
                <li class="span3"> <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" alt="" > </a>
                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                </li>
                <li class="span3"> <a> <img src="${pageContext.request.contextPath}/Admin/img/gallery/imgbox3.jpg" alt="" > </a>
                    <div class="actions"> <a title="" class="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
               </li>
            </ul>
        </div>
                  
            <div class="widget-content nopadding">
                <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px;margin:3px;">
                    <div class="span6">
                        <label class="control-label " ><b>Order Type : <%=orderData.getoType()%></b></label>
                    </div>
                    <div class="span6">
                        <label hidden class="control-label" style="padding-left:20px;color:grey;"></label>
                    </div>
                </div>
                <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px;margin:3px;">
                    <div class="span6">
                        <label class="control-label " >Product Name</label>
                    </div>
                    <div class="span6">
                        <label class="control-label" style="padding-left:20px;color:grey;">: <%=productData.getpName()%></label>
                    </div>
                </div>
                <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px;margin:3px;">
                    <div class="span6">
                        <label class="control-label " >Product Description</label>
                    </div>
                    <div class="span6">
                        <label class="control-label" style="padding-left:20px;color:grey;">: <%=productData.getpDescription()%></label>
                    </div>    
                </div>
                <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px;margin:3px;">
                    <div class="span6">
                        <label class="control-label " >Product Dimension</label>
                    </div>
                    <div class="span6">
                        <label class="control-label" style="padding-left:20px;color:grey;">: <%=productData.getpDimention()%></label>
                    </div>    
                </div>
                <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px; margin:3px;">
                    <div class="span6">
                        <label class="control-label " >Product Material and Color</label>
                    </div>
                    <div class="span6">
                        <label class="control-label" style="padding-left:20px;color:grey;">: <%=productData.getpMaterial()%> in <%=productData.getpMaterial()%></label>
                    </div>    
                </div>
                <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px; margin:3px;">
                    <div class="span6">
                        <label class="control-label " ><b>Order Quantity </b></label>
                    </div>
                    <div class="span6">
                        <label hidden class="control-label" style="padding-left:20px;color:grey;"><b>: <%=orderData.getoQuantity()%> Units</b></label>
                    </div>    
                </div>
                <form action="<%=request.getContextPath()%>/Order/FormAction?oID=<%=orderData.getoID()%>"  method="post" class="form-horizontal">

                    <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px; margin:3px;">
                        <div class="span6">
                            <label class="control-label " ><b>Advance Payment Status</b></label>
                        </div>
                        <div class="span6">
                            <div class="" style="padding-bottom:10px;">
                                        <select name='tStatus' required id="tStatus">
                                            <option><%=trackOrderData.gettStatus()%></option>
                                            <option>Pending</option>
                                            <option>Advance Payment Verified</option>
                                            <option>Full Payment Verified</option>
                                            
                                        </select>
                            </div>
                        </div>    
                    </div>
                    <div class="span7 " style="border:1px #28b779 solid; padding-left: 10px;padding-top:10px; margin:3px;">
                        <div class="span6">
                            <label class="control-label " ><b>Order Processing Status</b></label>
                        </div>
                        <div class="span6">
                            <div class="" style="padding-bottom:10px;">
                                        <select name='oStatus' required id="oStatus">
                                            <option><%=orderData.getoStatus()%></option>
                                            <option>Pending</option>
                                            <option>On Processing</option>
                                            <option>Completed</option>
                                        </select>
                            </div>
                        </div>    
                    </div>
                     <div class="span7 " style=" padding: 10px; margin:3px;">
                        <div class="span6">
                            <input type="hidden"  value="" class="control-label " >
                        </div>
                        <div class="span6">
                            <button type="submit" class="btn btn-success" style="display:block; width: 100%;"   id="actionButton">Update Status</button>
                        </div>    
                    </div>   
                </form>
                <div class="span7 " style="border:#149bdf solid; padding-left: 10px;padding-top:10px;margin:3px;">
                    <div class="span6">
                        <h4>Customer Information </h4>
                    </div>
                    <div class="span6">
                        <label hidden class="control-label" style="padding-left:20px;color:grey;"></label>
                    </div>
                </div> 
                <div class="span7 " style="; padding-left: 10px;padding-top:10px; margin:3px;">
                    <div class="span6">
                        <label class="control-label " ><b>Customer Full Name </b></label>
                    </div>
                    <div class="span6">
                        <label hidden class="control-label" style="padding-left:20px;color:grey;"><b>: <%=orderData.getoCName()%></b></label>
                    </div> 
                </div>
                <div class="span7 " style=" padding-left: 10px;padding-top:10px; margin:3px;">
                    <div class="span6">
                        <label class="control-label " ><b>Customer NIC</b></label>
                    </div>
                    <div class="span6">
                        <label hidden class="control-label" style="padding-left:20px;color:grey;"><b>: <%=orderData.getoCNIC()%></b></label>
                    </div> 
                </div>
                <div class="span7 " style=" padding-left: 10px;padding-top:10px; margin:3px;">
                    <div class="span6">
                        <label class="control-label " ><b>Customer Contact </b></label>
                    </div>
                    <div class="span6">
                        <label hidden class="control-label" style="padding-left:20px;color:grey;"><b>: <%=orderData.getoCPhone()%></b></label>
                    </div> 
                </div>
                <div class="span7 " style=" padding-left: 10px;padding-top:10px; margin:3px;">
                    <div class="span6">
                        <label class="control-label " ><b>Customer Order Tracking Code </b></label>
                    </div>
                    <div class="span6">
                        <label hidden class="control-label" style="padding-left:20px;color:grey;"><b>: <%=trackOrderData.gettCode()%></b></label>
                    </div> 
                </div>
                <%
                    }
                  %>
                        
                    
                </div>
            </div>
        </div>
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


</body>
</html>
