package dao;

import dao.SachDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sach;

import java.util.Objects;

import dao.DataSource;

public class SachDAOImpl implements SachDAO {
    @Override
    public List<Sach> getAllSach() {
        List<Sach> sachList = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        try {
            Connection conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
                sachList.add(sach);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sachList;
    }

    @Override
    public Sach getSachById(int id) {
        Sach sach = null;
        String sql = "SELECT * FROM Sach WHERE id = ?";
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                sach = new Sach(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
            }
            conn.commit();

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }
        return sach;
    }

    @Override
    public List<Sach> searchSachByName(String name) {
        List<Sach> sachList = new ArrayList<>();
        String sql = "SELECT * FROM Sach WHERE name LIKE ?";
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
                sachList.add(sach);
            }
            conn.commit();

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }
        return sachList;
    }

    @Override
    public void addSach(Sach sach) {
        String sql = "INSERT INTO Sach (name, author, quantity, price) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sach.getName());
            pstmt.setString(2, sach.getAuthor());
            pstmt.setInt(3, sach.getQuantity());
            pstmt.setDouble(4, sach.getPrice());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateSach(Sach sach) {
        String sql = "UPDATE Sach SET name = ?, author = ?, quantity = ?, price = ? WHERE id = ?";
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sach.getName());
            pstmt.setString(2, sach.getAuthor());
            pstmt.setInt(3, sach.getQuantity());
            pstmt.setDouble(4, sach.getPrice());
            pstmt.setInt(5, sach.getId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSach(int id) {
        String sql = "DELETE FROM Sach WHERE id = ?";
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        }
    }
}