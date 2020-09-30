package ControllerManagement;

import ModelManagement.Entities.Category;
import ModelManagement.Entities.Product;
import ModelManagement.ServiceManagement.CategoryService;
import ModelManagement.ServiceManagement.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductControllerServlet", urlPatterns = "/productController")
public class ProductControllerServlet extends HttpServlet {

    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    RequestDispatcher dispatcher;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Category> categories = categoryService.getAll();
        switch (action) {
            case "Add":
                String ProductName = request.getParameter("inputName");
                int ProductAmount = Integer.parseInt(request.getParameter("inputAmount"));
                float ProductPrice = Float.parseFloat(request.getParameter("inputPrice"));
                String ProductDescription = request.getParameter("inputDescription");
                String ProductThumbnail = request.getParameter("inputThumbnail");
                int CategoryId = Integer.parseInt(request.getParameter("inputCategory"));
                for (Category x : categories) {
                    if (x.getCategoryId() == CategoryId) {
                        Category category = new Category(x.getCategoryId(), x.getCategoryName());
                        Product product = new Product(ProductName, ProductAmount, ProductPrice, ProductDescription, ProductThumbnail, category);
                        productService.create(product);
                    }
                }
                response.sendRedirect("/productController");
                break;
            case "Edit":
                int id = Integer.parseInt(request.getParameter("id"));
                String Name = request.getParameter("inputName");
                int Amount = Integer.parseInt(request.getParameter("inputAmount"));
                float Price = Float.parseFloat(request.getParameter("inputPrice"));
                String Description = request.getParameter("inputDescription");
                String Thumbnail = request.getParameter("inputThumbnail");
                int EditCategoryId = Integer.parseInt(request.getParameter("inputCategory"));
                for (Category x : categories) {
                    if (x.getCategoryId() == EditCategoryId) {
                        Category category = new Category(x.getCategoryId(), x.getCategoryName());
                        productService.update(new Product(id, Name, Amount, Price, Description, Thumbnail, category));
                    }
                }
                response.sendRedirect("/productController");
                break;
            case "Delete":


                break;
            default:
                response.sendRedirect("../ViewManagementPage/ProductManagement.jsp");
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Category> categories = categoryService.getAll();
        action = action == null ? "" : action;
        switch (action) {
            case "Add":
                String ProductName = request.getParameter("inputName");
                int ProductAmount = Integer.parseInt(request.getParameter("inputAmount"));
                float ProductPrice = Float.parseFloat(request.getParameter("inputPrice"));
                String ProductDescription = request.getParameter("inputDescription");
                String ProductThumbnail = request.getParameter("inputThumbnail");
                int CategoryId = Integer.parseInt(request.getParameter("inputCategory"));
                for (Category x : categories) {
                    if (x.getCategoryId() == CategoryId) {
                        Category category = new Category(x.getCategoryId(), x.getCategoryName());
                        Product product = new Product(ProductName, ProductAmount, ProductPrice, ProductDescription, ProductThumbnail, category);
                        productService.create(product);
                    }
                }
                response.sendRedirect("/productController");
                break;
            case "Delete":
                int idProduct = Integer.parseInt(request.getParameter("id"));
                productService.delete(idProduct);
                response.sendRedirect("/productController");
                break;
            case "Update":
                break;
            default:
                try{
                    HttpSession session = request.getSession();
                    boolean checkLogin = (boolean) session.getAttribute("checkLogin");
                    if(checkLogin){
                        List<Product> products = productService.getAll();
                        List<Category> categoryList = categoryService.getAll();
                        request.setAttribute("categories", categoryList);
                        request.setAttribute("products", products);
                        dispatcher = getServletContext().getRequestDispatcher("/ViewManagementPage/ProductManagement.jsp");
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
