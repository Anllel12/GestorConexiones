/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class CreateBBDD {
    
    public static Connection con = null;
    
    public static void create(String name){
        
        String user= "root";
        String pass = "";
        
        try {          
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=UTC", user, pass);  // Creamos la Base de Datos.
            
            dataBase(name);
            
            assert con != null;
            
            con.setAutoCommit(false);
            
            createTables();
           
        } catch (SQLException ex) {
            Logger.getLogger(CreateBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void dataBase(String name) throws SQLException {
        Statement stmt = con.createStatement();
            
        String data = String.format("CREATE DATABASE IF NOT EXISTS %s;", name);           
        stmt.executeUpdate(data);
        
        String base = String.format("USE %s;", name); 
        stmt.executeUpdate(base);
        
        stmt.close();
    }
    
    private static void createTables() throws SQLException {  // Esto contiene toda la creación de tablas.
        createAlbumTable();
        createSongTable();
        insertTables();
    }
    
    private static void insertTables() throws SQLException {  // Esto contiene toda la creación de tablas.
        insertAlbumTable();
        insertSongTable();
    }
    
    private static void createAlbumTable() throws SQLException {  // Creamos la tabla Album.
        Statement stmt = con.createStatement();

        String albumTable = "CREATE TABLE IF NOT EXISTS `album` (\n" +
        "`id` INT(10) NOT NULL,\n" +
        "`titulo` VARCHAR(100) NOT NULL,\n" +
        "`autor` VARCHAR(100) NOT NULL,\n" +
        "`fecha_lanzamiento` VARCHAR(10) NOT NULL,\n" +
        "PRIMARY KEY (`id`));";
        
        stmt.executeUpdate(albumTable);
        stmt.close();
        con.commit();
    }
    
    private static void createSongTable() throws SQLException {  // Creamos la tabla Canciones.
        Statement stmt = con.createStatement();

        String songTable = "CREATE TABLE IF NOT EXISTS `cancion` (\n" +
        "`id` INT(10),\n" +
        "`titulo` VARCHAR(100),\n" +
        "`autor` VARCHAR(100),\n" +
        "`album` INT(10),\n" +
        "PRIMARY KEY (`id`));";
        
        stmt.executeUpdate(songTable);
        stmt.close();
        con.commit();
    }
    
    private static void insertAlbumTable() throws SQLException {  // Creamos la tabla Canciones.
        Statement stmt = con.createStatement();

        String albumTable = "INSERT IGNORE INTO `album` VALUES \n" +
        "(1, 'Mi Caja de Musica', 'Denom', '21-08-2020');";
        
        stmt.executeUpdate(albumTable);
        stmt.close();
        con.commit();
    }
    
    private static void insertSongTable() throws SQLException {  // Creamos la tabla Canciones.
        Statement stmt = con.createStatement();

        String songTable = "INSERT IGNORE INTO `cancion` VALUES \n" +
        "(1, 'En el Horno', 'Denom', '1'),\n" +
        "(2, 'Game Over', 'Denom', '1');";
        
        stmt.executeUpdate(songTable);
        stmt.close();
        con.commit();
    }
}
