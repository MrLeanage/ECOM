<%--
  Created by IntelliJ IDEA.
  User: dulshan
  Date: 3/6/2020
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="com.devzone.model.Product"%>
<%@page import="java.util.ArrayList" %>
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
    <h1><a href="index.jspl">DevZone Admin</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav">
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href=""><i class=""></i> </a></li>
                <li class="divider"></li>
                <li><a href="<%=request.getContextPath()%>/Login"><i class="icon-key"></i> Log Out</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i></a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="<%=request.getContextPath()%>/Order"><i class="icon-envelope"></i> New Orders</a></li>
            </ul>
        </li>
    </ul>
</div>
<!--close-top-Header-menu-->
<!--sidebar-menu-->

<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Admin Dashboard</a>
    <ul>
        <li ><a href="<%=request.getContextPath()%>/Order"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
        <li class="active"><a href="<%=request.getContextPath()%>/Product"><i class="icon icon-home"></i> <span>Products</span></a> </li>
        <li ><a href="<%=request.getContextPath()%>/Material"><i class="icon icon-home"></i> <span>Product Customization</span></a> </li>
    </ul>
</div>
<div id="content">
    <div id="content-header">
        <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Products</a> </div>
    </div>
    <div class="container-fluid">
        <hr>
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
                        <h5>Data table</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table table-bordered data-table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Image</th>
                                <th>Product Name</th>
                                <th>Dimension</th>
                                <th>Weight</th>
                                <th>Description</th>
                                <th>Customize</th>
                                <th>Availability</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                                <%
                                    ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
                                    for(Product products : productList){
                                %>
                            <tr class="gradeX">
                                <td><%=products.getpID()%></td>
                                <td><img src = "<%=request.getContextPath()%>/Admin/img/gallery/imgbox3.jpg" height="100" width="100" ><div class="actions"> <a title="" href="#"><i class="icon-pencil"></i></a> <a class="lightbox_trigger" href="img/gallery/imgbox3.jpg"><i class="icon-search"></i></a> </div>
                                </td>
                                <td><%=products.getpName()%></td>
                                <td><%=products.getpDimention()%></td>
                                <td><%=products.getpWeight()%></td>
                                <td><%=products.getpDescription()%></td>
                                <td class="right"><%=products.getpCustomize()%></td>
                                <td class="right"><%=products.getpAvailability()%></td>
                                <td>
                                    <div class="btn-group">
                                        <button class="btn btn-primary">Action</button>
                                        <button data-toggle="dropdown" class="btn btn-primary dropdown-toggle"><span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Update</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Delete</a></li>
                                        </ul>
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
                        <form action="<%=request.getContextPath()%>/Product" method="post" class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label">Product Name</label>
                                <div class="controls">
                                    <input type="text" name="name" id="name"  style="width: 90%">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Product Dimension</label>
                                <div class="controls">
                                    <input type="text" name="dimention" id="dimension" style="width: 90%">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Product Weight</label>
                                <div class="controls">
                                    <input type="text" name="weight" id="weight" style="width: 90%">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Item Product Description</label>
                                <div class="controls">
                                    <textarea name="description" id="description" class="span11" style="width: 90%"></textarea>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Customizable?</label>
                                <div class="controls">
                                    <select name='customize' >
                                        <option selected >Yes</option>
                                        <option >No</option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Select Available Colors</label>
                                <div class="controls">
                                    <input type="text" name="color" id="name" style="width: 90%">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Select Available Materials</label>
                                <div class="controls">
                                    <input type="text" name="material" id="name" style="width: 90%">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Set Availability Status</label>
                                <div class="controls">
                                    <select name='status'>
                                        <option>Available</option>
                                        <option>Out of Order</option>
                                        <option>Not Available</option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Select Images(max 5) :</label>
                                <div class="controls">
                                    <input type="file" name='image1' />
                                    <input type="file" name='image2' />
                                    <input type="file" name='image3' />
                                    <input type="file" name='image4' />
                                    <input type="file" name='image5' />
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" name='action' value='add' class="btn btn-success">Save</button>
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
<%@include file="includes/script.jsp" %>
</body>
</html>

