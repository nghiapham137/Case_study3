<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container-fluid" style="margin-left: 10px; margin-right: 10px">
    <div class="row col-md-12 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <a href="#" class="btn btn-primary btn-xs pull-right" data-toggle="modal" data-target="#modalAdd1"><b>+</b>Add new product</a>

            <%--Show table product--%>
            <tr>
                <td>Order Id</td>
                <td>Order date</td>
                <td>Customer Name</td>
                <td>Customer Email</td>
                <td>Customer Phone</td>
                <td>Customer Address</td>
<%--                <td>Product Id</td>--%>
<%--                <td>Order Amount</td>--%>
<%--                <td>Unit Price</td>--%>
                <td class="text-center">Action</td>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="order" items="${ordersList}" varStatus="loop">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.customerName}</td>
                    <td>${order.customerEmail}</td>
                    <td>${order.customerPhone}</td>
                    <td>${order.customerAddress}</td>
                    <td class="text-center">
                        <a class='btn btn-info btn-xs' data-toggle="modal" data-target="#Edit${item.productId}">
                            <span class="glyphicon glyphicon-edit"></span>Edit</a>

                        <a class="btn btn-danger btn-xs" data-toggle="modal" data-target="#Del${item.productId}">
                            <span class="glyphicon glyphicon-remove"></span>Del</a>

                        <!-- Modal delete-->
                        <div class="modal fade" id="Del${item.productId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="DelModalLabel">Are diu sua?</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                        <a type="button" class="btn btn-primary" href="/productController?action=Delete&id=${item.productId}">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Modal edit-->
                        <div class="modal fade addNewInputs" id="Edit${item.productId}" tabindex="-1" role="dialog" aria-labelledby="modalAdd" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title w-100 font-weight-bold text-primary ml-5" id="editProduct">Edit product</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <form method="post" action="/productController?action=Edit">
                                        <div class="modal-body mx-3">
                                            <input type="text" value="${item.productId}" hidden name="id">
                                            <div class="md-form mb-5">
                                                <p style="text-align: left">Name</p>
                                                <input type="text" name="inputName" class="form-control validate" value="${item.productName}">
                                            </div>
                                            <div class="md-form mb-5">
                                                <p style="text-align: left">Amount</p>
                                                <input type="number" name="inputAmount" class="form-control validate" value="${item.amount}">
                                            </div>
                                            <div class="md-form mb-5">
                                                <p style="text-align: left">Price</p>
                                                <input type="number" name="inputPrice" class="form-control validate" value="${item.price}">
                                            </div>
                                            <div class="md-form mb-5">
                                                <p style="text-align: left">Description</p>
                                                <input type="text" name="inputDescription" class="form-control validate" value="${item.description}">
                                            </div>
                                            <div class="md-form mb-5">
                                                <p style="text-align: left">Thumbnail</p>
                                                <input type="text" name="inputThumbnail" class="form-control validate" value="${item.thumbnail}">
                                            </div>
                                            <div class="md-form mb-5">
                                                <p style="text-align: left">Category</p>
                                                <select name="inputCategory" class="form-control">
                                                    <c:forEach var="item" items="${categories}" varStatus="loop">
                                                        <option class="form-control validate" name="${item.categoryId}"
                                                                value="${item.categoryId}">${item.categoryName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer d-flex justify-content-center buttonAddFormWrapper">
                                            <button type="submit" class="btn btn-outline-primary btn-block buttonAdd">Update product<i class="fas fa-paper-plane-o ml-1"></i>
                                            </button>
                                        </div>
                                    </form>
                                        <%--                                    <div class="modal-footer">--%>
                                        <%--                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>--%>
                                        <%--                                        <a type="button" class="btn btn-primary" href="/productController?action=Delete&id=${item.productId}">Update</a>--%>
                                        <%--                                    </div>--%>
                                </div>
                            </div>
                        </div>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%--    <h4>Order Information</h4>--%>
<%--    <div>--%>
<%--        <tr>--%>
<%--            <td>Order Id</td>--%>
<%--            <td>Order date</td>--%>
<%--            <td>Customer Name</td>--%>
<%--            <td>Customer Email</td>--%>
<%--            <td>Customer Phone</td>--%>
<%--            <td>Customer Address</td>--%>
<%--            <td>Product Id</td>--%>
<%--            <td>Order Amount</td>--%>
<%--            <td>Unit Price</td>--%>
<%--        </tr>--%>
<%--            --%>
<%--    --%>
<%--        <c:forEach var="order" items="${ordersList}" varStatus="loop">--%>
<%--            <td>${order.orderId}</td>--%>
<%--            <td>${order.orderDate}</td>--%>
<%--            <td>${order.customerName}</td>--%>
<%--            <td>${order.customerEmail}</td>--%>
<%--            <td>${order.customerPhone}</td>--%>
<%--            <td>${order.customerAddress}</td>--%>
<%--&lt;%&ndash;            <td>${order.inline_items.getProduct().getProductId()}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${order.inline_items.getAmount()}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>${order.inline_items.getUnitPrice()}</td>&ndash;%&gt;--%>


<%--        </c:forEach>--%>

</div>


</body>
</html>
