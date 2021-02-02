/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.Connection;
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
    
    public void addSong(int id, String titulo, String autor, int album){  // añade Canciones.
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
            
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void addAlbum(int id, String titulo, String autor, String fecha){  // añade Albunes.
        String query = "INSERT INTO album(id,titulo,autor,fecha_lanzamiento) VALUES (?, ?, ?, ?);";
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, titulo);
            stmt.setString(3, autor);
            stmt.setString(4, fecha);
            
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void updateAlbum(int col, String value, int id){ // actualiza los valores de Album
        String query = "UPDATE album SET(? = ?)";
        
        System.out.println(String.format("UPDATE album SET titulo = %s WHERE id = %s", value, id));
        try{
            Statement stmt = con.createStatement();
            switch(col){ // segun el numero de la columna hace una cosa u otra              
                case 1: query = String.format("UPDATE album SET titulo = '%s' WHERE id = %s", value, id); break;
                case 2: query = String.format("UPDATE album SET autor = '%s' WHERE id = %s", value, id); break;
                case 3: query = String.format("UPDATE album SET fecha_lanzamiento = '%s' WHERE id = %s", value, id); break;
            }        
            
            stmt.executeUpdate(query);
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void updateSong(int col, String value, int album, int id){ // actualiza los valores de Album
        String query = "UPDATE album SET(? = ?)";
        
        try{
            Statement stmt = con.createStatement();
            switch(col){ // segun el numero de la columna hace una cosa u otra
                case 1: query = String.format("UPDATE cancion SET titulo = '%s' WHERE id = %s", value, id); break;
                case 2: query = String.format("UPDATE cancion SET autor = '%s' WHERE id = %s", value, id); break;
                case 3: query = String.format("UPDATE cancion SET album = %s WHERE id = %s", album, id); break;
            }        
            
            stmt.executeUpdate(query);
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void deleteAlbum(int id){ // actualiza los valores de Album
        String query = "DELETE FROM album WHERE id = ?";
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void deleteSong(int id){ // elimino los valores de Cancion
        String query = "DELETE FROM cancion WHERE id = ?";
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void tableSong (JTable table){ // selecciono todo de la tabla para poner en la UI
        String query = "SELECT * FROM cancion;";
        
        try{
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // añade filas a la tabla automaticamente
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("album")});                
            }
            
            rs.close();
            stmt.close();
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
            
            rs.close();
            stmt.close();
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }        
    }
}
