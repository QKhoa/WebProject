package controller.customer;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import connectsqlserver.DatabaseConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.customer.Customer;
import model.customer.CustomerDAO;


@WebServlet(urlPatterns = {"/customerupdateservlet"})
public class CustomerUpdateServlet extends HttpServlet {


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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String customerID = request.getParameter("customerID");

        if (customerID != null && !customerID.trim().isEmpty()) {
            Customer customer = (Customer) CustomerDAO.getInstance().findByID(customerID);
            if (customer != null) {
                request.setAttribute("customer", customer);
            } else {
                request.setAttribute("err", "Không tìm thấy khách hàng với ID: " + customerID);
            }


            request.getRequestDispatcher("customer/customerupdate.jsp").forward(request, response);

        } else  {
            String err = "CustomerID bi null";
            request.setAttribute("err", err);
            request.getRequestDispatcher("customer/customerupdate.jsp").forward(request, response);
        }




    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lay du lieu tu form gui len
        String customerID = request.getParameter("customerID");
        String companyName = request.getParameter("companyName");
        String contactName = request.getParameter("contactName");
        String contactTitle = request.getParameter("contactTitle");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String region = request.getParameter("region");
        String postalCode = request.getParameter("postalCode");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        String fax = request.getParameter("fax");

        // Tao customer luu tru thong tin nguoi dung muon update
        Customer updatedCustomer = new Customer(customerID,companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);


        // update thong tin nguoi dung co torng bang thong tin tu updated customer

        CustomerDAO.getInstance().update(updatedCustomer);


        // chuyen ve trang view cua customer

        response.sendRedirect("customerviewservlet");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
