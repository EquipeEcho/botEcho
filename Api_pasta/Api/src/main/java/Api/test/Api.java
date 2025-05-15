/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Api.test;

import dao.ConnectionDB;
import gui.SplashScreen;
import gui.UI;
import java.sql.SQLException;


/**
 *
 * @author Ryan
 */
public class Api {

    public static void main(String[] args) {
        
        try {
            ConnectionDB.buildTables();
        } catch (SQLException err) {
            throw new RuntimeException(err);
        }
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });   
    }
}
