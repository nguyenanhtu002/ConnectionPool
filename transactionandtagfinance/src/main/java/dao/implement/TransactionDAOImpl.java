package dao.implement;

import dao.DataSource;
import dao.TransactionDAO;
import model.TagFinance;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {

    @Override
    public List<Transaction> getAllTransactions() {
        Connection conn = null;
        List<Transaction> list = new ArrayList<>();
        try {
            conn = DataSource.getInstance().getConnection();
            String SELECT_ALL = "SELECT * FROM Transactions,TagFinance where tag_id = id";
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String createAt = rs.getString("createdAt");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                int tag_id = rs.getInt("tag_id");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description1 = rs.getString("description");
                Transaction transaction = new Transaction(createAt, title, description, amount, tag_id, new TagFinance(id, name, description1));
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
    public void insertTransaction(Transaction transaction) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            String sql = "INSERT INTO Transactions (createdAt,title, description,amount,tag_id) VALUES (?, ?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, transaction.getCreatedAt());
            pstmt.setString(2, transaction.getTitle());
            pstmt.setString(3, transaction.getDescription());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setInt(5, transaction.getTag_id());
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

    public void updateTransaction(Transaction transaction, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            String UPDATE_TRANSACTION = "UPDATE Transactions SET createdAt =?,title=?, description =?,amount=?, WHERE tag_id =?";
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TRANSACTION);
            pstmt.setString(1, transaction.getCreatedAt());
            pstmt.setString(2, transaction.getTitle());
            pstmt.setString(3, transaction.getDescription());
            pstmt.setDouble(4, transaction.getAmount());
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
            String DELETE_TRAN = "DELETE FROM Transactions WHERE tag_id =?";
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
//            e.printStackTrace();
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

    @Override
    public List<Transaction> searchTransactionByTagfinal(int id) {
        List<Transaction> transactions = new ArrayList<>();
        String SEARCH_BY_ID = "SELECT * FROM Transactions,TagFinance WHERE tag_id = ?";
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SEARCH_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String createAt = rs.getString("createdAt");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                int tag_id = rs.getInt("tag_id");
                String name = rs.getString("name");
                String description1 = rs.getString("description");
                Transaction transaction = new Transaction(createAt, title, description, amount, tag_id, new TagFinance(id, name, description1));
                transactions.add(transaction);
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
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return transactions;
    }

    @Override
    public List<Transaction> searchTransactionByName(String name) {
        List<Transaction> transactions = new ArrayList<>();
        String SEARCH_BY_ID = "SELECT * FROM Transactions, TagFinance WHERE name LIKE ?";
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SEARCH_BY_ID);
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String createAt = rs.getString("createdAt");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                int tag_id = rs.getInt("tag_id");
                int id = rs.getInt("id");
                String description1 = rs.getString("description");
                Transaction transaction = new Transaction(createAt, title, description, amount, tag_id, new TagFinance(id, name, description1));
                transactions.add(transaction);
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
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return transactions;
    }
}
