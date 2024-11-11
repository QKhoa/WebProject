package model.product;

import connectsqlserver.DatabaseConnector;
import model.category.Category;
import model.daointerface.DAOInterface;
import model.supplier.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAOInterface<Product> {
    public static ProductDAO getInstance() {
        return new ProductDAO();
    }

    ;

    // write sql to view all products


    @Override
    public void insert(Product obj) {

    }

    @Override
    public void update(Product obj) {

    }

    @Override
    public void deleteByID(String id) {

    }

    @Override
    public Product findByID(String id) {
        return null;
    }

    @Override
    public List<Product> selectAll() {
        String sql = "SELECT * FROM dbo.Products "
                + "LEFT JOIN dbo.Categories C ON C.CategoryID = Products.CategoryID";

        List<Product> products = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                Category category = new Category();

                // Populate product fields
                product.setProductId(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                product.setUnitPrice(rs.getInt("UnitPrice"));
                product.setUnitsInStock(rs.getInt("UnitsInStock"));
                product.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                product.setReorderLevel(rs.getInt("ReorderLevel"));
                product.setDiscontinued(rs.getBoolean("Discontinued"));

                // Populate category fields
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setDescription(rs.getString("Description"));
                category.setPicture(rs.getBytes("Picture"));

                product.setCategory(category);

                products.add(product);
            }

        } catch (SQLException e) {
            // Log the error with a logging framework or print to console
            System.err.println("Error while fetching products: " + e.getMessage());
            throw new RuntimeException("Error fetching products", e);
        }

        return products;
    }


    @Override
    public Product findByID(int id) {
        return null;
    }

    @Override
    public Product checkAccount(String username, String password) {
        return null;
    }

    public List<Product> selectByConditions( String categoryName, String productName, Integer minPrice, Integer maxPrice) {
        List<Product> products = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Products "
                + "LEFT JOIN dbo.Categories C ON C.CategoryID = Products.CategoryID WHERE 1=1");

        if (productName != null && !productName.isEmpty()) {
            sql.append(" AND ProductName LIKE ? ");
        }
        if (categoryName != null && !categoryName.isEmpty() && !categoryName.contains("all")) {
            sql.append(" AND CategoryName LIKE ? ");
        }
        if (minPrice != null) {
            sql.append(" AND Products.UnitPrice >= ? ");
        }
        if (maxPrice != null) {
            sql.append(" AND Products.UnitPrice <= ? ");
        }

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            int index = 1;

            if (productName != null && !productName.isEmpty()) {
                ps.setString(index++, "%" + productName + "%"); // Add wildcards for LIKE
            }
            if (categoryName != null && !categoryName.isEmpty() && !categoryName.contains("all")) {
                ps.setString(index++, "%" + categoryName + "%"); // Add wildcards for LIKE
            }
            if (minPrice != null) {
                ps.setInt(index++, minPrice);
            }
            if (maxPrice != null) {
                ps.setInt(index++, maxPrice);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                Category category = new Category();

                // Populate product fields
                product.setProductId(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                product.setUnitPrice(rs.getInt("UnitPrice"));
                product.setUnitsInStock(rs.getInt("UnitsInStock"));
                product.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
                product.setReorderLevel(rs.getInt("ReorderLevel"));
                product.setDiscontinued(rs.getBoolean("Discontinued"));

                // Populate category fields
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setDescription(rs.getString("Description"));
                category.setPicture(rs.getBytes("Picture"));

                product.setCategory(category);
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching products by conditions", e);
        }

        return products;
    }
}
