package com.example.demo.dao.implement;


import com.example.demo.dao.DataSource;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.entity.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TransactionDAOImpl implements TransactionDAO {
    public static final String CREATE_TRANSACTION_TAG = "INSERT INTO Transaction_Tag_Finance (tag_id, transaction_id) VALUES (?, ?)";
    public static final String SELECT_ALL = "SELECT * FROM Transaction";
    public static final String INSERT_TRAN = "INSERT INTO Transaction (title, description,amount) VALUES (?,?,?)";
    public static final String UPDATE_TRANSACTION = "UPDATE Transaction SET title=?, description =?,amount=?, tag_Id=? WHERE id =?";
    public static final String DELETE_TRAN = "DELETE FROM Transaction WHERE id =?";
    @Override
    public List<Transaction> getAllTransactions() {
        Connection conn = null;
        List<Transaction> list = new ArrayList<>();
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                java.util.Date createAt = rs.getDate("create_at");
                String title = rs.getString("title");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                Transaction transaction = new Transaction(id, createAt, title, description, amount);
                list.add(transaction);
            }

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return list;
    }


    @Override
    public void createTransaction(String title, String description, double amount, int tagId) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement insertTransactionStmt = conn.prepareStatement(INSERT_TRAN, Statement.RETURN_GENERATED_KEYS);
            insertTransactionStmt.setString(1, title);
            insertTransactionStmt.setString(2, description);
            insertTransactionStmt.setDouble(3, amount);
            insertTransactionStmt.executeUpdate();

            ResultSet generatedKeys = insertTransactionStmt.getGeneratedKeys();
            int transactionId;
            if (generatedKeys.next()) {
                transactionId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve generated transaction ID");
            }

            PreparedStatement createTransactionTagStmt = conn.prepareStatement(CREATE_TRANSACTION_TAG);
            createTransactionTagStmt.setInt(1, transactionId);
            createTransactionTagStmt.setInt(2, tagId);
            createTransactionTagStmt.executeUpdate();

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
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }




    @Override
    public void updateTransaction(String title, String description, double amount, int tagId, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TRANSACTION);
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setDouble(3, amount);
            pstmt.setInt(4, tagId);
            pstmt.setInt(5, id);
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
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public void deleteTransaction(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(DELETE_TRAN);
            pstmt.setInt(1, id);
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
            throw new RuntimeException("Failed to delete");

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

//    @Override
//    public void addTransactionToTagFinance(int tagFinanceId, int transactionId) throws SQLException {
//        Connection conn = null;
//        try {
//            conn = DataSource.getInstance().getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(CREATE_TRANSACTION_TAG);
//            pstmt.setInt(1, tagFinanceId);
//            pstmt.setInt(2, transactionId);
//            pstmt.executeUpdate();
//            conn.commit();
//        } catch (SQLException e) {
//            if (conn != null) {
//                try {
//                    conn.rollback();
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    System.out.println("Error closing");
//                }
//            }
//        }
//    }
}