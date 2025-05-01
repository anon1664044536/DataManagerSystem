package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DataSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/collage";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    private static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    public static ResultSet tchSelect(String tchName) throws SQLException {

        Statement stmt = conn.createStatement();

        String sql = "select StuName, s.StuNO, CosName, Grade\n" +
                "from Student s, Course c, stu_course sc\n" +
                "where s.StuNo = sc.StuNo and\n" +
                "      sc.CosNo = c.CosNO and\n" +
                "      c.TchNo = " + tchName + ";";

        ResultSet rs = stmt.executeQuery(sql);
        //123
        return rs;
    }
}
