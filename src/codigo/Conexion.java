/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import BBDD.CreateBBDD;
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
    
    CreateBBDD BBDD = new CreateBBDD();
    
    public void desconectar() {
        try {
            BBDD.con.close();
            System.out.println("Desconectado a la Base de Datos");
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }
    }
    
    public void addSong(int id, String titulo, String autor, int album){  // añade Canciones.
        String query = "INSERT INTO cancion(id,titulo,autor,album) VALUES (?, ?, ?, ?);";
        System.out.println(id);
        System.out.println(titulo);
        System.out.println(autor);
        System.out.println(album);
        
        try{
            PreparedStatement stmt = BBDD.con.prepareStatement(query);
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
            PreparedStatement stmt = BBDD.con.prepareStatement(query);
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
            Statement stmt = BBDD.con.createStatement();
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
    
    public void updateSong(int col, String value, int album, int id){ // actualiza los valores de Cancion
        String query = "UPDATE album SET(? = ?)";
        
        try{
            Statement stmt = BBDD.con.createStatement();
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
    
    public void deleteAlbum(int id){ // elimina los valores de Album
        String query = "DELETE FROM album WHERE id = ?";
        
        try{
            PreparedStatement stmt = BBDD.con.prepareStatement(query);
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
            PreparedStatement stmt = BBDD.con.prepareStatement(query);
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
            Statement stmt = BBDD.con.createStatement();
            
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
    
    public void tableAlbum (JTable table){ // selecciono todo de la tabla para poner en la UI
        String query = "SELECT * FROM album;";
        
        try{
            Statement stmt = BBDD.con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                
                DefaultTableModel model = (DefaultTableModel) table.getModel(); // añade filas a la tabla automaticamente
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("fecha_lanzamiento")});                
            }
            
            rs.close();
            stmt.close();
        }
        catch(SQLException ex){
            System.out.println(ex.toString());
        }        
    }
    
    public String findAlbum (int column, String value){ // busca los valores que le dices
        String text = "";
        String query = "";
        switch(column){ // segun lo elegido en el comboBox entra en un lado o en otro
            case 0: query = "SELECT * FROM album WHERE id = ?;"; break;
            case 1: query = "SELECT * FROM album WHERE titulo = ?;"; break;
            case 2: query = "SELECT * FROM album WHERE autor = ?;"; break;
            case 3: query = "SELECT * FROM album WHERE fecha_lanzamiento = ?;"; break;
        }

        try{
            PreparedStatement stmt = BBDD.con.prepareStatement(query);
            stmt.setString(1, value);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) { // lo pongo en un Jtext
                text += String.format("Id: %s \nTitulo: %s\n Autor: %s\n Fecha Lanzamiento: %s", rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("fecha_lanzamiento"));
            }
            
            rs.close();
            stmt.close();          
        }
        catch (Exception ex){
            System.out.println(ex);
        } 
        
        return text;
    }
    
    public String findSong (int column, String value){ // busca los valores que le dices
        String text = "";
        String query = "";
        switch(column){ // segun lo elegido en el comboBox entra en un lado o en otro
            case 0: query = "SELECT * FROM cancion WHERE id = ?;"; break;
            case 1: query = "SELECT * FROM cancion WHERE titulo = ?;"; break;
            case 2: query = "SELECT * FROM cancion WHERE autor = ?;"; break;
            case 3: query = "SELECT * FROM cancion WHERE album = ?;"; break;
        }
        
        try{
            PreparedStatement stmt = BBDD.con.prepareStatement(query);
            stmt.setString(1, value);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) { // lo pongo en un Jtext
                text += String.format("Id: %s \nTitulo: %s\nAutor: %s\nAlbum: %s\n\n", rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getString("album"));
            }
            
            rs.close();
            stmt.close();          
        }
        catch (Exception ex){
            System.out.println(ex);
        } 
        
        return text;
    }
}
