package ControllerManagement;

import ModelManagement.ServiceManagement.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "userControllerServlet", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
                        HttpSession session = request.getSession();
                        boolean checkLogin = true;
                        session.setAttribute("checkLogin",checkLogin);
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
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "login":
                response.sendRedirect("/ViewManagementPage/Login.jsp");
                break;
            case  "logout":
                HttpSession session = request.getSession();
                session.invalidate();
            default:
                response.sendRedirect("/ViewManagementPage/Login.jsp");
                break;
        }
    }
}
