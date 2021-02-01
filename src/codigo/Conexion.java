/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel
 */
public class Conexion {
    
    Connection con;  

    public void conectar() {

        String urlBBDD = "jdbc:mysql://localhost:3306/discografica?serverTimezone=UTC";
        String user= "root";
        String pass = "";

        try {
            con = DriverManager.getConnection(urlBBDD, user, pass);
            if (con != null) {
                System.out.println("Conectado a la Base de Datos");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            con.close();
            System.out.println("Desconectado a la Base de Datos");
            
            //return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            //return false;
        }
    }
    
    public void addSong(int id, String titulo, String autor, int album){  // Añade Canciones.
        String query = "INSERT INTO cancion(id,titulo,autor,album) VALUES (?, ?, ?, ?);";
        System.out.println(id);
        System.out.println(titulo);
        System.out.println(autor);
        System.out.println(album);
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, titulo);
            stmt.setString(3, autor);
            stmt.setInt(4, album);
            
            stmt.executeUpdate();  // Añade el usuario.
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void addAlbum(int id, String titulo, String autor, String fecha){  // Añade Albunes.
        String query = "INSERT INTO album(id,titulo,autor,fecha_lanzamiento) VALUES (?, ?, ?, ?);";
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, titulo);
            stmt.setString(3, autor);
            stmt.setString(4, fecha);
            
            stmt.executeUpdate();  // Añade el usuario.
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void updateAlbum(int row, int col, String value, String column){
         String query = "UPDATE album SET(? = ?)";
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            switch(col){
                case 0:  stmt.setString(1, column); stmt.setInt(2, Integer.parseInt(value)); break;
                case 1:  stmt.setString(1, column); stmt.setString(2, value); break;
                case 2:  stmt.setString(1, column); stmt.setString(2, value); break;
                case 3:  stmt.setString(1, column); stmt.setString(2, value); break;
            }        
            
            stmt.executeUpdate();  // Añade el usuario.
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void tableSong (JTable table){
        String query = "SELECT * FROM cancion;";
        
        try{
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("album")});                
            }
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }        
    }
    
     public void tableAlbum (JTable table){
        String query = "SELECT * FROM album;";
        
        try{
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("fecha_lanzamiento")});                
            }
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }        
    }
}
