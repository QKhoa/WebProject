package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.category.Category;
import model.category.CategoryDAO;
import model.product.Product;
import model.product.ProductDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(urlPatterns = {"/productviewservlet"})
public class ProductViewServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getContextPath();
        // chuyen huong ve trang jsp
        // lay du lieu tu database


        try {
            // Fetch data from DAOs
            ArrayList<Product> products = (ArrayList<Product>) ProductDAO.getInstance().selectAll();
            ArrayList<Category> categories = (ArrayList<Category>) CategoryDAO.getInstace().selectAll();

            // Ensure non-null lists to avoid potential issues in JSP
            if (products == null) {
                products = new ArrayList<>();
            }
            if (categories == null) {
                categories = new ArrayList<>();
            }

            // Set attributes for JSP access
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);

            // Forward to JSP
            request.getRequestDispatcher("product/productview.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getContextPath();




// Handle potential null values for minPrice and maxPrice
        Integer minPrice = null;
        Integer maxPrice = null;
        String categoryName = null;
        String productName = null;
        try {
            String minPriceParam = request.getParameter("minPrice");
            if (minPriceParam != null && !minPriceParam.isEmpty()) {
                minPrice = Integer.parseInt(minPriceParam);
            }

            String maxPriceParam = request.getParameter("maxPrice");
            if (maxPriceParam != null && !maxPriceParam.isEmpty()) {
                maxPrice = Integer.parseInt(maxPriceParam);
            }

            if (request.getParameter("categoryName") != null && !request.getParameter("categoryName").isEmpty()) {
                categoryName = request.getParameter("categoryName");
            }

            if (request.getParameter("productName") != null && !request.getParameter("productName").isEmpty()) {
                productName = request.getParameter("productName");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the error, or handle it as needed
            // Optionally, you can set default values for minPrice and maxPrice here if necessary
        }

// Retrieve filtered products based on the provided conditions
        ArrayList<Product> products = (ArrayList<Product>) ProductDAO.getInstance().selectByConditions(categoryName, productName, minPrice, maxPrice);
        ArrayList<Category> categories = (ArrayList<Category>) CategoryDAO.getInstace().selectAll();

// Set attributes to make the data available in JSP
        request.setAttribute("categories", categories);
        request.setAttribute("products", products);
        request.setAttribute("categoryName", categoryName);
        request.setAttribute("productName", productName);
        request.setAttribute("minPrice", minPrice);
        request.setAttribute("maxPrice", maxPrice);

// Forward to JSP
        request.getRequestDispatcher("product/productview.jsp").forward(request, response);




    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}