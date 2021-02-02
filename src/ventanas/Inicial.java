/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import codigo.Conexion;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author angel
 */
public class Inicial extends javax.swing.JFrame {
    
    Conexion conexion = new Conexion();
    
    int row = 0; // fila pinchada con el raton
    int col = 0; // columna pinchada con el raton
    String edit = ""; // valor que edito
    int edit2 = 0;
    int id = 0; // valor que edito


    /*
     * Creates new form Inicial
     */
    public Inicial() {
        initComponents();
        conexion.conectar();
        conexion.tableSong(jTableCanciones); // pongo los valores de la BBDD en las tablas
        conexion.tableAlbum(jTableAlbunes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlbunes = new javax.swing.JTable();
        jButtonActualizarAlbum = new javax.swing.JButton();
        jButtonAñadirAlbum = new javax.swing.JButton();
        jButtonEliminarAlbum = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jTextId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextCombo = new javax.swing.JTextField();
        jComboBox = new javax.swing.JComboBox<>();
        jButtonAñadir = new javax.swing.JButton();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCanciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButtonEliminarCancion = new javax.swing.JButton();
        jButtonActualizarCancion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jTableAlbunes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Autor", "Fecha Lanzamineto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAlbunes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlbunesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAlbunes);

        jButtonActualizarAlbum.setText("Actualizar");
        jButtonActualizarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarAlbumActionPerformed(evt);
            }
        });

        jButtonAñadirAlbum.setText("Añadir");

        jButtonEliminarAlbum.setText("Eliminar");
        jButtonEliminarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEliminarAlbum)
                .addGap(49, 49, 49)
                .addComponent(jButtonActualizarAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAñadirAlbum)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizarAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAñadirAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminarAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Albunes", jInternalFrame1);

        jInternalFrame2.setVisible(true);

        jTextId.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("ID");

        jTextTitulo.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Titulo");

        jTextAutor.setPreferredSize(new java.awt.Dimension(65, 25));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setText("Autor");

        jTextCombo.setPreferredSize(new java.awt.Dimension(65, 25));

        jComboBox.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Album", "Fecha de Alta"}));

        jButtonAñadir.setText("Añadir");
        jButtonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 179, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jTextCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jButtonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Añadir", jInternalFrame2);

        jInternalFrame3.setVisible(true);

        jTableCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Autor", "Album"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCancionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCanciones);

        jButton1.setText("Añadir");

        jButtonEliminarCancion.setText("Eliminar");
        jButtonEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCancionActionPerformed(evt);
            }
        });

        jButtonActualizarCancion.setText("Actualizar");
        jButtonActualizarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarCancionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonEliminarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButtonActualizarCancion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEliminarCancion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonActualizarCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Canciones", jInternalFrame3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirActionPerformed
        if (jComboBox.getSelectedItem().equals("Album")) { // Comprueba cual de los dos elementos es el seleccionado
            conexion.addSong(Integer.parseInt(jTextId.getText()), jTextTitulo.getText(), jTextAutor.getText(), Integer.parseInt(jTextCombo.getText())); // paso los valores a la funcion    
        }
        else{
            conexion.addAlbum(Integer.parseInt(jTextId.getText()), jTextTitulo.getText(), jTextAutor.getText(), jTextCombo.getText());
        }
        
        updateTableAlbum(); // actualizo los valores de la tabla
        updateTableSong();  
    }//GEN-LAST:event_jButtonAñadirActionPerformed

    private void jButtonActualizarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarAlbumActionPerformed
        if(jTableAlbunes.isEditing()){
            JOptionPane.showMessageDialog(null, "Deje de editar el campo (Pulse ENTER para dejar de editar).", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(col != 0){
                edit = (String) ((DefaultTableModel)jTableAlbunes.getModel()).getValueAt(row, col);//cojo el valor editado
                conexion.updateAlbum(col, edit, id); // paso los valores a la otra funcion
            }
        }  
        
        updateTableAlbum(); // actualizo los valores de la tabla
    }//GEN-LAST:event_jButtonActualizarAlbumActionPerformed

    private void jTableAlbunesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlbunesMouseClicked
        JTable source = (JTable) evt.getSource();
        row = source.rowAtPoint(evt.getPoint()); // me devuelve la fila pinchada
        col = source.columnAtPoint(evt.getPoint());    
        id = (int) source.getModel().getValueAt(row, 0);
        
    }//GEN-LAST:event_jTableAlbunesMouseClicked

    private void jButtonActualizarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarCancionActionPerformed
        if(jTableCanciones.isEditing()){
            JOptionPane.showMessageDialog(null, "Deje de editar el campo (Pulse ENTER para dejar de editar).", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(col != 0 && col != 3){
                edit = (String) ((DefaultTableModel)jTableCanciones.getModel()).getValueAt(row, col);//cojo el valor editado
                conexion.updateSong(col, edit, edit2, id); // paso los valores a la otra funcion               
            }
            if(col == 3){
                edit2 = (int) Integer.parseInt((String) ((DefaultTableModel)jTableCanciones.getModel()).getValueAt(row, col));//cojo el valor editado
                conexion.updateSong(col, edit, edit2, id); // paso los valores a la otra funcion
            }
        }  
        
        updateTableSong(); // actualizo los valores de la tabla
    }//GEN-LAST:event_jButtonActualizarCancionActionPerformed

    private void jTableCancionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCancionesMouseClicked
        JTable source = (JTable) evt.getSource();
        row = source.rowAtPoint(evt.getPoint()); // me devuelve la fila pinchada
        col = source.columnAtPoint(evt.getPoint());    
        id = (int) source.getModel().getValueAt(row, 0);
    }//GEN-LAST:event_jTableCancionesMouseClicked

    private void jButtonEliminarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarAlbumActionPerformed
        conexion.deleteAlbum(id);
        
        updateTableAlbum(); // actualizo los valores de la tabla
    }//GEN-LAST:event_jButtonEliminarAlbumActionPerformed

    private void jButtonEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCancionActionPerformed
        conexion.deleteSong(id);
        
        updateTableSong(); // actualizo los valores de la tabla
    }//GEN-LAST:event_jButtonEliminarCancionActionPerformed

    public void updateTableAlbum(){ // actualizo la tabla
        while(jTableAlbunes.getRowCount() != 0) ((DefaultTableModel)jTableAlbunes.getModel()).removeRow(0); // consigue el total de columnas y las elimina
        
        conexion.tableAlbum(jTableAlbunes);
    }

    public void updateTableSong(){
        while(jTableCanciones.getRowCount() != 0) ((DefaultTableModel)jTableCanciones.getModel()).removeRow(0);
        
        conexion.tableSong(jTableCanciones);
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizarAlbum;
    private javax.swing.JButton jButtonActualizarCancion;
    private javax.swing.JButton jButtonAñadir;
    private javax.swing.JButton jButtonAñadirAlbum;
    private javax.swing.JButton jButtonEliminarAlbum;
    private javax.swing.JButton jButtonEliminarCancion;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableAlbunes;
    public javax.swing.JTable jTableCanciones;
    private javax.swing.JTextField jTextAutor;
    private javax.swing.JTextField jTextCombo;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextTitulo;
    // End of variables declaration//GEN-END:variables
}
