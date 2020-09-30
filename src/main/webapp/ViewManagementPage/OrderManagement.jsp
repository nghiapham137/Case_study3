<%--
  Created by IntelliJ IDEA.
  User: Minh Nguyễn
  Date: 9/28/2020
  Time: 8:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Management</title>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>

    <!-- Bootstrap files (jQuery first, then Popper.js, then Bootstrap JS) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark sticky-top bg-primary">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main_nav"><span class="navbar-toggler-icon"></span></button>
        <a class="navbar-brand" href="../View/index.jsp">HomePage</a>

        <div class="collapse navbar-collapse" id="main_nav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="../ViewManagementPage/Dashboard.jsp"> Dashboard </a></li>
                <li class="nav-item"><a class="nav-link" href="/productController">Product Management </a></li>
                <li class="nav-item active"><a class="nav-link" href="/orderController"> Order Management </a></li>
<%--                <li class="nav-item"><a class="nav-link" href="/userController"> User Management </a></li>--%>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="../View/index.jsp"> Logout </a></li>
            </ul>
        </div> <!-- navbar-collapse.// -->
    </div><!-- container //  -->
</nav>


</body>
</html>
