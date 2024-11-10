import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectsqlserver.DatabaseConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.admin.Admin;
import model.admin.AdminDAO;
import model.customer.Customer;
import model.customer.CustomerDAO;

public class testCheckAccount {
    public static void main(String[] args) {

       String username = "123";
       String password = "123";

       checkAccount(username, password);



    }


    public static Admin checkAccount(String username, String password) {
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


