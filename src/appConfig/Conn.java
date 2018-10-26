/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appConfig;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sayamasfahri
 */
public class Conn {
    public static Connection conn;
    public static Statement stmt;
    public static void main (String args[]) {
        try {
            String url = "jdbc:mysql://localhost/skripskuy";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            stmt = (Statement) conn.createStatement();
            System.out.println("Success");            
        } catch (Exception e) {
            System.err.println("Fail Connection "+e.getMessage());
        }
    }
    
}
