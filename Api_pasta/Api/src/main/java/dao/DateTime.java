/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Bruna
 */
public class DateTime {
    public static String getDataTime(){
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = dt.format(formatter);
        return formattedDateTime;
    }
}
