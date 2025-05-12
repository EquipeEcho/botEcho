/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectionDB {
    
    public static Connection connectDB(){
        Connection conn = null;
        String url = "jdbc:hsqldb:file:\\botechodb\\db";
        String user = "botecho";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("ConexãoDB" + e.getMessage());
        }
        return conn;
    }
    
    public static void buildTables() throws SQLException{
        
        String prompts = "CREATE TABLE IF NOT EXISTS PROMPTS ("
                + "ID INTEGER IDENTITY,"
                + "NOME VARCHAR(45),"
                + "RESPOSTA VARCHAR(10000),"
                + "UTIL TINYINT,"
                + "IA CHAR(1),"
                + "DATA VARCHAR(19));";
        
        PreparedStatement stm = connectDB().prepareStatement(prompts);
        stm.execute();
        connectDB().commit();
        
        stm.close();
        connectDB().close();
        
=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<<< HEAD:Api_pasta/Api/src/main/java/dao/Dao.java
import java.sql.SQLException;
========
>>>>>>>> f06ddf3aeaf8efad646c909b134c69490836129f:Api_pasta/Api/src/main/java/dao/ConnectionDB.java
import java.util.ArrayList;

/**
 *
 * @author Bruna
 */
public class Dao {
    
    public static void insertDB(Connection conn, String resposta, Boolean util, char ia, String Nome, String data) throws SQLException {
        String sql = "INSERT INTO PROMPTS (resposta, util, ia, Nome, data) VALUES (?, ?, ?, ?, ?)";
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
>>>>>>> f06ddf3aeaf8efad646c909b134c69490836129f
    }
    
}
