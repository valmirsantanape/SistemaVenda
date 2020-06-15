/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author valmi
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/bdvendas?useTimezone=true&serverTimezone=UTC","root","12345");
        } catch (Exception e) {
            throw new RuntimeException(e);
            //JOptionPane.showMessageDialog("Falha na conexão", e);
        }
        
    }
    
    
}
