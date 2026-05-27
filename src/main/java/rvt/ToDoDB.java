package rvt;

import java.sql.Statement;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToDoDB {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public ToDoDB() {
        initSchem();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initSchem() {
        String sql = "CREATE TABLE IF NOT EXISTS todo ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "task TEXT NOT NULL)";
        try (
                Connection conn = connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Init failed" + e.getMessage());
        }
    }

    public void add(String task) {
        String sql = "INSERT INTO todo(task) VALUES(?)";
        try (
                Connection con = connect();
                PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setString(1, task);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert task: " + e.getMessage());
        }
    }

    public void findAll() {
        String sql = "SELECT * FROM todo";
        try (
                Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String task = rs.getString("task");
                System.out.println("ID: " + id + " | Task: " + task);
            }
        } catch (SQLException e) {
            System.err.println("Failed to output task: " + e.getMessage());
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        try (
                Connection con = connect();
                PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Task with ID " + id + " deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to insert task: " + e.getMessage());
        }
    }
}
