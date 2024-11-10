package model.customer;

import connectsqlserver.DatabaseConnector;
import model.daointerface.DAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAOInterface<Customer> {

    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }

    @Override
    public void insert(Customer customer) {
        String sql = "insert into  dbo.Customers (CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax) values (?, ?, ?, ? , ?, ?, ?, ?, ?, ? , ?)";

        try {
            int index = 1;
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(index++, customer.getCustomerID());
            ps.setString(index++, customer.getCompanyName());
            ps.setString(index++, customer.getContactName());
            ps.setString(index++, customer.getContactTitle());
            ps.setString(index++, customer.getAddress());
            ps.setString(index++, customer.getCity());
            ps.setString(index++, customer.getRegion());
            ps.setString(index++, customer.getPostalCode());
            ps.setString(index++, customer.getCountry());
            ps.setString(index++, customer.getPhone());
            ps.setString(index++, customer.getFax());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error inserting customer into database");

        }

    }


    @Override
    public void update(Customer updatedCustomer) {


        String sql = "UPDATE dbo.Customers\n" +
                "SET\n" +
                "    CustomerID = ?,\n" +
                "    CompanyName = ?,\n" +
                "    ContactName = ?,\n" +
                "    ContactTitle = ?,\n" +
                "    Address = ?,\n" +
                "    City = ?,\n" +
                "    Region = ?,\n" +
                "    PostalCode = ?,\n" +
                "    Country = ?,\n" +
                "    Phone = ?,\n" +
                "    Fax = ?\n" +
                "WHERE\n" +
                "    CustomerID = ?";

        try {
            int index = 1;
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(index++, updatedCustomer.getCustomerID());
            ps.setString(index++, updatedCustomer.getCompanyName());
            ps.setString(index++, updatedCustomer.getContactName());
            ps.setString(index++, updatedCustomer.getContactTitle());
            ps.setString(index++, updatedCustomer.getAddress());
            ps.setString(index++, updatedCustomer.getCity());
            ps.setString(index++, updatedCustomer.getRegion());
            ps.setString(index++, updatedCustomer.getPostalCode());
            ps.setString(index++, updatedCustomer.getCountry());
            ps.setString(index++, updatedCustomer.getPhone());
            ps.setString(index++, updatedCustomer.getFax());
            ps.setString(index++, updatedCustomer.getCustomerID());
            ps.executeUpdate();

            System.out.println("Update thanh cong thong tin khach hang");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteByID(String customerIdToDelete) {

        String sql = "DELETE FROM dbo.Customers WHERE CustomerID = ?";

        try {
            Connection conn = DatabaseConnector.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, customerIdToDelete);

            ps.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Customer findByID(String id) {
        String sql = "SELECT * FROM customers WHERE customerID = ?";
        Customer customer = null;

        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerID(rs.getString("customerID"));
                customer.setCompanyName(rs.getString("companyName"));
                customer.setContactName(rs.getString("contactName"));
                customer.setContactTitle(rs.getString("contactTitle"));
                customer.setAddress(rs.getString("address"));
                customer.setCity(rs.getString("city"));
                customer.setRegion(rs.getString("region"));
                customer.setPostalCode(rs.getString("postalCode"));
                customer.setCountry(rs.getString("country"));
                customer.setPhone(rs.getString("phone"));
                customer.setFax(rs.getString("fax"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return customer;
    }


    @Override
    public List<Customer> selectAll() {
        // Kết nối với cơ sở dữ liệu
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Tạo câu lệnh SQL
            String sql = "select * from customers";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Customer> list = new ArrayList<>();

            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getString("CustomerID"));
                c.setCompanyName(rs.getString("CompanyName"));
                c.setContactName(rs.getString("ContactName"));
                c.setContactTitle(rs.getString("ContactTitle"));
                c.setAddress(rs.getString("Address"));
                c.setCity(rs.getString("City"));
                c.setRegion(rs.getString("Region"));
                c.setPostalCode(rs.getString("PostalCode"));
                c.setCountry(rs.getString("Country"));
                c.setPhone(rs.getString("Phone"));
                c.setFax(rs.getString("Fax"));

                // Thêm đối tượng Customer vào danh sách
                list.add(c);
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }


    }


    @Override
    public Customer findByID(int id) {
        return null;
    }


    @Override
    public Customer checkAccount(String username, String password) {
        return null;
    }
}
