/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Khach
 */
public class MyConnexion {
    
      public String url="jdbc:mysql://localhost:3306/projetrh";
    public String user="root";
    public String pwd="";
    
    private Connection cnx;
    public static MyConnexion ct;
    
    public MyConnexion(){
        try{
        cnx=(Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected Successfully!");
        }

        catch (SQLException ex){
            System.out.println(ex.getMessage());
            
        }
    
}
    public static MyConnexion getInstance(){
        if(ct==null)
            ct = new MyConnexion();
        return ct;
        
    }
    
    public Connection getCnx(){
        return cnx;
    }
    
}
