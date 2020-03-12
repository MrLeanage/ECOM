<%--
  Created by IntelliJ IDEA.
  User: dulshan
  Date: 3/6/2020
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <ul class="nav">
        <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome ${username}</span><b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a href=""><i class=""></i> </a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
                <li class="divider"></li>
                <li><a href="login.jsp"><i class="icon-key"></i> Log Out</a></li>
            </ul>
        </li>
        <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i></a></li>
                <li class="divider"></li>
                <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> New Orders</a></li>
            </ul>
        </li>
    </ul>
</div>
<!--close-top-Header-menu-->
<!--sidebar-menu-->

<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Admin Dashboard</a>
    <ul>
        <li ><a href="${pageContext.request.contextPath}/Order"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
        <li ><a href="${pageContext.request.contextPath}/Product"><i class="icon icon-home"></i> <span>Products</span></a> </li>
        <li class="active"><a href="${pageContext.request.contextPath}/Material"><i class="icon icon-home"></i> <span>Product Customization</span></a> </li>
    </ul>
</div>

<!--close-left-menu-stats-sidebar-->

<div id="content">
    <div id="content-header">
        <div id="breadcrumb"> <a href="" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>  <a href="#" class="current">Product Customization</a> </div>

    </div>
    <div class="container-fluid">

        <hr>
        <div class="row-fluid">
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title "> <span class="icon"><i class="icon-th"></i></span>
                        <h5>Products Color table</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table   ">
                            <thead>
                            <tr>
                                <th>CID</th>
                                <th>Color</th>
                                <th class="right">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="gradeX">
                                <td>C001</td>
                                <td>Blue</td>
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
                            <tr class="gradeX">
                                <td>C002</td>
                                <td>Black</td>
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
                            <tr class="gradeX">
                                <td>C002</td>
                                <td>Black</td>
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
            <div class="span6">
                <div class="widget-box">
                    <div class="widget-title "> <span class="icon"><i class="icon-th"></i></span>
                        <h5>Products Material table</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table   ">
                            <thead>
                            <tr>
                                <th>MID</th>
                                <th>Product Material</th>
                                <th class="right">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="material" items="${materialList}" >
                                <tr class="gradeX">
                                    <td><c:out value="${material.mID}"/> </td>
                                    <td><c:out value="${material.mName}"/></td>
                                    <td>
                                        <div class="btn-group">
                                            <button class="btn btn-primary">Action</button>
                                            <button data-toggle="dropdown" class="btn btn-primary dropdown-toggle"><span class="caret"></span></button>
                                            <ul class="dropdown-menu">
                                                <li><a href="edit?id=<c:out value='${material.mID}' />">Update</a></li>
                                                <li class="divider"></li>
                                                <li><a href="delete?id=<c:out value='${material.mID}' />">Delete</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
                <div class="widget-box">
                    <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
                        <h5>Product Material Name</h5>
                    </div>
                    <div class="widget-content nopadding">
                    <c:if test="${material == null}">
                            <form action="insert" method="post" class="form-horizontal">
                         </c:if>
                        <c:if test="${material != null}">
                            <form action="update" method="post" class="form-horizontal">
                        </c:if>
                        <c:if test="${material != null}">
                            <input type="hidden" name="ID" value="<c:out value="${material.mID}"/>"/>
                        </c:if>
                            <div class="control-group">
                                <label class="control-label">Material Name :</label>
                                <div class="controls">
                                    <input type="text" name="mName" value="<c:out value='${material.mName}' />" class="span11" placeholder="Color" />
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