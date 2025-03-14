/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
    
    public static Connection connectDB(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/botechoDB?user=root&password=fatec";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Db Conectada");
        } catch (SQLException e) {
            System.out.println("ConexãoDB" + e.getMessage());
        }
        return conn;
    }
    
    public static void insertDB(Connection conn, String resposta, Boolean util) throws SQLException {
        String sql = "INSERT INTO prompts (resposta, util) VALUES (?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setString(1, resposta);
        stm.setBoolean(2, util);
        stm.executeUpdate();
        
        conn.close();
    }
    
    public static void deleteDB(Connection conn, int ID) throws SQLException {
        String del = "DELETE FROM prompts WHERE ID = ?";
        PreparedStatement stm = conn.prepareStatement(del);
        
        stm.setInt(1, ID);
        stm.executeUpdate();
        
        conn.close();
        
    }
}
