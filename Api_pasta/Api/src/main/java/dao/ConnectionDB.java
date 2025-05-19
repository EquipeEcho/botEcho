/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
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

    }

    public Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
