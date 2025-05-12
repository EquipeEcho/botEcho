/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Api.test;

<<<<<<< HEAD
import dao.ConnectionDB;
import gui.UI;
import java.sql.SQLException;
=======
import gui.UI;
>>>>>>> f06ddf3aeaf8efad646c909b134c69490836129f

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
                new UI().setVisible(true);
            }
        });   
    }
}
