package ControllerManagement;

import ModelManagement.Entities.Category;
import ModelManagement.Entities.Order;
import ModelManagement.Entities.Product;
import ModelManagement.ServiceManagement.OrderService;

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
    OrderService orderService = new OrderService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> ordersList = orderService.getAll();
        request.setAttribute("ordersList", ordersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewManagementPage/OrderManagement.jsp");
        dispatcher.forward(request,response);

    }

}
