package ControllerManagement;

import ModelManagement.Entities.Category;
import ModelManagement.Entities.Order;
import ModelManagement.Entities.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderControllerServlet", urlPatterns = "/orderController")
public class OrderControllerServlet extends HttpServlet {

    RequestDispatcher dispatcher;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "":
                break;

            default:
                try{
                    HttpSession session = request.getSession();
                    boolean checkLogin = (boolean) session.getAttribute("checkLogin");
                    if(checkLogin){
                        List<Order> orders = orderService.getAll();
                        request.setAttribute("products", orders);
                        dispatcher = getServletContext().getRequestDispatcher("/ViewManagementPage/OrderManagement.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                }catch (NullPointerException e){
                    dispatcher = getServletContext().getRequestDispatcher("/ViewManagementPage/error.jsp");
                    dispatcher.forward(request, response);
                }
        }
    }
}
