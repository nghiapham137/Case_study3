<%--
  Created by IntelliJ IDEA.
  User: Minh Nguyễn
  Date: 9/27/2020
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
    <%--    <link rel="stylesheet" href="/StyleManagementPage/LoginStyle.css"/>--%>
<%--    <script src="http://code.jquery.com/jquery-latest.min.js"></script>--%>
<%--    <script>--%>
<%--        $(document).on("click", "#submit", function () {--%>
<%--            $.get("/userController", function (responseText) {--%>
<%--                $("#errorString").text(responseText);--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>
</head>
<body style="background: #282781 !important;">

<div id="login">
    <div>
<%--        <h3 class="text-center text-blue pt-5" id="errorString">${errorString}</h3>--%>
        <h3 class="text-center text-blue pt-5" style="color: #282781 !important;">Username: admin Password: admin </h3>
        <br/>
    </div>

    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="../login?action=login" method="post">
                        <h3 class="text-center text-info" style="color: #fdfbfb !important;">Login</h3>
                        <div class="form-group">
                            <label for="username" class="text-info" style="color: #fdfbfb !important;">Username:</label><br>
                            <input type="text" name="username" id="username" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info" style="color: #fdfbfb !important;">Password:</label><br>
                            <input type="password" name="password" id="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="remember-me" class="text-info" style="color: #fdfbfb !important;"><span>Remember me</span> <span><input
                                    id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                            <input type="submit" name="submit" id="submit" class="btn btn-info btn-md" value="submit"
                                   style="background-color: #fdfbfb !important; border-color: #ced4da !important;color: #282781 !important; font-weight: bold">
                        </div>
                        <div id="register-link" class="text-right">
                            <a href="../View/index.jsp" class="text-info" style="color: #fdfbfb !important;">Home Page</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>