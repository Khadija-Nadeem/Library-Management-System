/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JFrames;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    static Connection con = null;
    
    //Method to communicate with Database (we don't need to write it again n again)
    public static Connection getConnection() {
        try{
     
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library_Management_System", "root", "programmer._.2004");
        } catch (Exception e) {
            e.printStackTrace();// Prints the stack trace for debuggin ;
        }
        return con;
    }
}
