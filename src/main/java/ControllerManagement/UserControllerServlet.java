package ControllerManagement;

import ModelManagement.Entities.Product;
import ModelManagement.ServiceManagement.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "userControllerServlet", urlPatterns = {"/userController"})
public class UserControllerServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                boolean isLogged = userService.login(username, password);
                if (isLogged) {
                    try {
                        response.sendRedirect("/productController");
                    } catch (Exception exception) {
                        System.out.println(exception);
                    }
                } else {
                    response.sendRedirect("../ViewManagementPage/Login.jsp");
                }
                break;
            default:
                response.sendRedirect("../ViewManagementPage/Login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "add":
                break;
            case "delete":
                break;
            case "update":
                break;
            default:
//                List<Product> products = userService.getAll();
//                request.setAttribute("products", products);
                dispatcher = getServletContext().getRequestDispatcher("/ViewManagementPage/ProductManagement.jsp");
                dispatcher.forward(request, response);
                break;
        }
    }
}
