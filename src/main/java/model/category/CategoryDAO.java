package model.category;

import connectsqlserver.DatabaseConnector;
import model.daointerface.DAOInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements DAOInterface<Category> {
    public static CategoryDAO getInstace() {
        return new CategoryDAO();
    }

    @Override
    public void insert(Category obj) {

    }

    @Override
    public void update(Category obj) {

    }

    @Override
    public void deleteByID(String id) {

    }

    @Override
    public Category findByID(String id) {
        return null;
    }

    @Override
    public List<Category> selectAll() {

        // lay ra tat ca cac category

        String sql = "select * from dbo.Categories";
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getInt("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                category.setDescription(rs.getString("Description"));
                category.setPicture(rs.getBytes("Picture"));

                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Category findByID(int id) {
        return null;
    }

    @Override
    public Category checkAccount(String username, String password) {
        return null;
    }
}
