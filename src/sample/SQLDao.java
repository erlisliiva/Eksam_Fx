package sample;

import java.sql.*;
import java.util.*;

public class SQLDao {
    private Connection connect() {
        // SQLite connection string
        String username = "";
        String password = "";

        /* Make sure to add sqlite driver (ctrl + alt + shift + s)
            Project Settings -> Modules -> + and add the jar file.
         */
        String url = "jdbc:sqlite://C:\\Users\\Erlis\\IdeaProjects\\eksam\\src\\sample\\identifier.sqlite";
        Connection conn = null;
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the warehouses table
     */
    public Map<String, Vooluring> selectAll() {
        String sql = "select vooluring.id, vooluring.Voolutugevus, vooluring.Pinge, vooluring.Takisti from vooluring";

        Map<String, Vooluring> shapes = new HashMap<String, Vooluring>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Vooluring shape = new Vooluring();
                //Use ID instead of shape.name for key in dictionary if multiple same named shapes
                shape.name = rs.getString("id");
                shape.Voolutugevus = rs.getFloat("Voolutugevus");
                shape.pinge = rs.getFloat("Pinge");
                shape.takisti = rs.getFloat("Takisti");
                shapes.put(shape.name, shape);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return shapes;
    }
}