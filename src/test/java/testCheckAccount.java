import model.admin.Admin;
import model.admin.AdminDAO;
import model.product.Product;
import model.product.ProductDAO;

import java.util.ArrayList;

public class testCheckAccount {
    public static void main(String[] args) {

        ArrayList<Product> products = (ArrayList<Product>) ProductDAO.getInstance().selectByConditions(null, "Confections", 5 , 30);

        for (Product product : products) {

            System.out.println(product.toString());
        }



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


