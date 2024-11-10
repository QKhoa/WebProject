package controller.login;


import connectsqlserver.DatabaseConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.admin.Admin;
import model.admin.AdminDAO;
import model.customer.Customer;
import model.customer.CustomerDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(urlPatterns = {"/loginservlet"})
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath();

        request.getRequestDispatcher("login/login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getContextPath();


        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username == null || password == null) {
                String err = "Username or password is null";
                request.setAttribute("err", err);
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
            }

            Admin account = checkAccount(username, password);
            if (account != null) {
                HttpSession session = request.getSession();
                // dang nhap thanh cong
                session.setAttribute("account", account);
                request.getRequestDispatcher("login/welcome.jsp").forward(request, response);

            } else {
                String err = "Dang nhap that bai! Khong tim thay tai khoan!";
                request.setAttribute("err", err);
                request.getRequestDispatcher("login/login.jsp").forward(request, response);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }



@Override
public String getServletInfo() {
    return "Short description";
}// </editor-fold>


protected Admin checkAccount(String username, String password) {
    Admin admin = AdminDAO.getInstance().checkAccount(username, password);

    if (admin != null) {
        System.out.println("Dang nhap thanh cong");
        return admin;
    } else {

        System.out.println("Sai tai khoan hoac mat khau");

    }

    return null;
}

}