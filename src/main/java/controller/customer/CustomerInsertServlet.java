package controller.customer;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.customer.Customer;
import model.customer.CustomerDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;



@WebServlet(urlPatterns = {"/customerinsertservlet"})
public class CustomerInsertServlet extends HttpServlet {


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
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // chuyen ve trang web de nguoi dung nhap vao form

        request.getRequestDispatcher("customer/customerinsert.jsp").forward(request, response);

    }


    /**
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        String url = request.getContextPath();

        try {


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

            // Tạo đối tượng Customer
            Customer customer = new Customer();
            customer.setCustomerID(customerID);
            customer.setCompanyName(companyName);
            customer.setContactName(contactName);
            customer.setContactTitle(contactTitle);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setRegion(region);
            customer.setPostalCode(postalCode);
            customer.setCountry(country);
            customer.setPhone(phone);
            customer.setFax(fax);



            // sau khi tao xong doi tuong customer
            CustomerDAO.getInstance().insert(customer);


            // chuyen ve trang view customers

            response.sendRedirect(url + "/customerviewservlet");



        } catch (Exception e) {
            throw new RuntimeException("Loi trong qua trinh them customer");
        }
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



