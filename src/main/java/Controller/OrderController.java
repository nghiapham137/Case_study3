package Controller;

import Model.Cart;
import Model.Inline_item;
import Model.Order;
import Model.Product;
import Service.Service;
import Service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class OrderController extends HttpServlet {
    Service service = new Service();
    OrderService orderService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "order":
                    break;
                case "addToOrder":
                    addToOrder(request, response);
                    break;
                case "search":
                    search(request,response);
                    break;

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "order":
                    showOrderPage(request,response);
                    break;
                case "addToCart":
                    showCartBox(request,response);
                    break;
                case "deleteFromCart":
                    deleteFromCart(request,response);
                    break;
                default:
                    showHomePage(request,response);
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("View/index.jsp");
    }



    private void showCartBox(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int  id = Integer.parseInt(request.getParameter("productId"));
        Cart cart;
             HttpSession session = request.getSession();
             if (session.getAttribute("cart") == null) {
                cart  = new Cart();
                session.setAttribute("cart", cart);
             } else {
                  cart = (Cart) session.getAttribute("cart");
             }
        Inline_item items = cart.getItemByProductId(id);
        items.setAmount(items.getAmount() + 1);
        response.sendRedirect("/user?action=order");
    }

    private void deleteFromCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int id = Integer.parseInt(request.getParameter("productId"));
        Inline_item item = cart.getItemByProductId(id);
        item.setAmount(item.getAmount() - 1);
        if (item.getAmount() == 0) {
            cart.getCart().remove(item);
        }
        response.sendRedirect("/user?action=order");

    }

    private void addToOrder(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException, SQLException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Inline_item> list = cart.getCart();
        String date = request.getParameter("order-date");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateStr = formatter.parse(date);
        java.sql.Date dateDB = new Date(dateStr.getTime());
        String name = request.getParameter("customer-name");
        String email = request.getParameter("customer-email");
        String phone =request.getParameter("customer-phone");
        String address = request.getParameter("customer-address");
        Order order = new Order(dateDB, name, email, phone, address, list);
        boolean insertOrder = orderService.insertOrder(order);
        int id = orderService.getOrderId();
        if (insertOrder) orderService.insertOrderDetail(order,id);
        else System.out.println("Loi");
        System.out.println(id);
        request.setAttribute("message", "insert success");
        session.removeAttribute("cart");
        response.sendRedirect("/user?action=order");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String search = request.getParameter("search");
        List<Product> productList = service.searchBy(search);
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/Order.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showOrderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = service.showAllProducts();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/Order.jsp");
        dispatcher.forward(request, response);
    }
}
