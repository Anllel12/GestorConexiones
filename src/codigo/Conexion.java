/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Conexion {
    
    Connection conexion;

    public void conectar() {

        String urlBBDD = "jdbc:mysql://localhost:3306/discografica?serverTimezone=UTC";
        String user= "root";
        String pass = "";

        try {
            conexion = DriverManager.getConnection(urlBBDD, user, pass);
            if (conexion != null) {
                System.out.println("Conectado a la Base de Datos");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            conexion.close();
            System.out.println("Desconectado a la Base de Datos");
            
            //return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            //return false;
        }
    }
}
