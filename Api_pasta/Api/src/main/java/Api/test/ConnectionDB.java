/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectionDB {
    
    public static Connection connectDB(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/botechoDB?user=root&password=fatec";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("ConexãoDB" + e.getMessage());
        }
        return conn;
    }
    
    public static void insertDB(Connection conn, String resposta, Boolean util, char ia, String Nome, String data) throws SQLException {
        String sql = "INSERT INTO prompts (resposta, util, ia, Nome, data) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setString(1, resposta);
        stm.setBoolean(2, util);
        stm.setString(3, String.valueOf(ia));
        stm.setString(4, Nome);
        stm.setString(5, data);
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
    public static ArrayList selectDB(Connection conn, char tipo) throws SQLException{
        String prompt = "SELECT * FROM prompts WHERE ia = ?";
        ArrayList <Object []> historico = new ArrayList<>();
        
        PreparedStatement stm = conn.prepareStatement(prompt);
        stm.setString(1, String.valueOf(tipo));
        ResultSet rs = stm.executeQuery(); 
        
        while(rs.next()) {
            Object[] p = new Object[4];
            p[0] = rs.getString("nome");
            p[1] = rs.getString("data");
            p[2] = rs.getString("resposta");
            p[3] = rs.getString("ia");
            historico.add(p);
        }
        rs.close();
        stm.close();
        return historico;
    }
}
