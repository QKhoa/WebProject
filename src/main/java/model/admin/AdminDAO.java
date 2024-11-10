package model.admin;

import connectsqlserver.DatabaseConnector;
import model.daointerface.DAOInterface;
import model.admin.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDAO implements DAOInterface<Admin> {

    public static AdminDAO getInstance() {
        return new AdminDAO();
    }

    @Override
    public void insert(Admin obj) {

    }

    @Override
    public void update(Admin obj) {

    }

    @Override
    public void deleteByID(String id) {

    }

    @Override
    public Admin findByID(String id) {
        return null;
    }

    @Override
    public List<Admin> selectAll() {
        return List.of();
    }

    @Override
    public Admin findByID(int id) {
        return null;
    }

    @Override
    public Admin checkAccount(String username, String password) {
        String sql = "select * from admin where username=? and password=?";

        try {

            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Admin admin = new Admin();
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getString("role"));

                return admin;
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
