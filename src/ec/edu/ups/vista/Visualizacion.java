/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuezadaBryam
 */
public class Visualizacion extends javax.swing.JFrame {
//declaracion de atributos
    DefaultListModel direc;
    DefaultListModel arch;
    DefaultListModel oculto;
    private String ruta;
    private String rutaPasada;
    private String atras;
    

    /**
     * Creates new form Visualizacio
     */
    public Visualizacion() {
        initComponents();
    }

    private static void eliminar(File archivoEliminar) {
        if (archivoEliminar.isDirectory()) {
            for (File archivo : archivoEliminar.listFiles()) {
                eliminar(archivo);
            }
        }
        archivoEliminar.delete();
    }

    public void Listas() {
        ruta = txtRuta.getText();
        File directorio = new File(ruta);
        if (directorio.isDirectory() == true) {
            File[] archivos = directorio.listFiles();
            DefaultListModel modelo = new DefaultListModel();
            DefaultListModel modelo1 = new DefaultListModel();
            DefaultListModel modelo2 = new DefaultListModel();
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    modelo.addElement(archivo.getName());
                }
            }
            for (File archivo : archivos) {
                if (archivo.isFile()) {
                    modelo1.addElement(archivo.getName());
                }
            }
            for (File archivo : archivos) {
                if (archivo.isHidden()) {
                    modelo2.addElement(archivo.getName());
                }
            }
            lstDirectorios.setModel(modelo);
            lstArchivos.setModel(modelo1);
            lstOcultos.setModel(modelo2);
        }

    }
    public void mostrarInformacionArchivoSeleccionado(String rutaSeleccionada) {
        //obtengo la fecha de ultima modificacion
        File archivoSeleccionado = new File(rutaSeleccionada);
        long fechaMilisegundos = archivoSeleccionado.lastModified();
        Date fecha = new Date(fechaMilisegundos);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formato.format(fecha);
        txtModificacion.setText("Fecha de ultima modificacion: " + fechaTexto);

        //obtengo la ruta absoluta
        String rutaAbsoluta = archivoSeleccionado.getAbsolutePath();
        txtRAbsoluta.setText("Ruta absoluta: " + rutaAbsoluta);

        //obtengo el tamano del archivo en kb
        long tamanoEnBytes = archivoSeleccionado.length();
        long tamanoEnKBytes = tamanoEnBytes / 1024l;

        txtTamano.setText("Tamaño (Kb): " + tamanoEnKBytes);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTamaño = new javax.swing.JLabel();
        txtModificacion = new javax.swing.JTextField();
        txtRAbsoluta = new javax.swing.JTextField();
        txtTamano = new javax.swing.JTextField();
        lblModificacion = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDirectorios = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstArchivos = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstOcultos = new javax.swing.JList();
        btnSalir = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenuItem();
        MenuRenombrar = new javax.swing.JMenuItem();
        menuNuevoArchivo = new javax.swing.JMenuItem();
        menuEliminar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setText("RUTA:");

        txtRuta.setBackground(new java.awt.Color(51, 255, 204));

        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel3.setText("OCULTOS");

        jLabel1.setText("DIRECTORIOS");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("ARCHIVOS");

        jLabel2.setText("ARCHIVOS");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("INFORMACION");

        lblTamaño.setText("TAMAÑO EN KB: ");

        lblModificacion.setText("ULTIMA MODIFICACION:");

        lblRuta.setText("RUTA ABSOLUTA:");

        lstDirectorios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDirectoriosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstDirectorios);

        lstArchivos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstArchivosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstArchivos);

        lstOcultos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOcultosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstOcultos);

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jMenuArchivo.setText("ARCHIVO");

        menuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuNuevo.setText("NUEVO ARCHIVO");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(menuNuevo);

        MenuRenombrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        MenuRenombrar.setText("RENOMBRAR");
        MenuRenombrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRenombrarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(MenuRenombrar);

        menuNuevoArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuNuevoArchivo.setText("NUEVA CARPETA");
        menuNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoArchivoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(menuNuevoArchivo);

        menuEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuEliminar.setText("ELIMINAR");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(menuEliminar);

        menuBar.add(jMenuArchivo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRuta)
                            .addComponent(lblTamaño)
                            .addComponent(lblModificacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtModificacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addComponent(txtRAbsoluta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTamano))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRuta))
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnListar)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnAtras))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(28, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(122, 122, 122)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(470, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar)
                    .addComponent(btnAtras))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(lblModificacion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRAbsoluta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamaño)
                    .addComponent(txtTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnSalir)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(474, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // metodo aplicado para hacer funcionar el boton hacia atras
        String regresar = txtRuta.getText();
        char r;
        String dato = "";
        for (int i = regresar.length() - 1; i > 0; i--) {
            r = regresar.charAt(i);
            dato = r + dato;
            if (r == '\\') {
                atras = regresar.replace(dato, "");
                i = 0;
            }
        }
        txtRuta.setText(atras);
        Listas();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // imprime las listas que se encuentren en la ruta ingresada
        Listas();
        /*
         File ruta;
         ruta = new File(txtRuta.getText());
         File[] archivos = ruta.listFiles();

         for (File archivo : archivos) {

         if (archivo.isDirectory()) {
         if (archivo.isHidden()) {
         System.out.println("Ocultos " + archivo.getName());
         String lista = archivo.getName();
         oculto.addElement(lista);

         } else {
         System.out.println("Directorios " + archivo.getName());
         String lista = archivo.getName();
         directorio.addElement(lista);
         }

         } else if (archivo.isFile()) {
         if (archivo.isHidden()) {
         System.out.println("Ocultos " + archivo.getName());
         String lista = archivo.getName();
         oculto.addElement(lista);

         } else {
         System.out.println("Archivos " + archivo.getName());
         String lista = archivo.getName();
         archiv.addElement(lista);
         }

         } else if (archivo.isHidden()) {

         System.out.println("Ocultos " + archivo.getName());
         String lista = archivo.getName();
         archiv.addElement(lista);

         }
         }

         {

         }*/
    }//GEN-LAST:event_btnListarActionPerformed

    private void lstDirectoriosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDirectoriosValueChanged
        //muestra los directorios de la ruta ingresada
        if (!lstDirectorios.isSelectionEmpty()) {
            String seleccion = lstDirectorios.getSelectedValue().toString();
            String rutaCompleta = ruta + "\\" + seleccion;
            txtRAbsoluta.setText(rutaCompleta);
            File fichero = new File(rutaCompleta);
            long modificacion = fichero.lastModified();
            String pattern = "yyyy-MM-dd hh:mm aa";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            Date fechaModificacion = new Date(modificacion);

            txtModificacion.setText(simpleDateFormat.format(fechaModificacion));
            //long length = mostrarInformacionArchivoSeleccionado();
            //txtTamano.setText(Math.round(Math.ceil(length / 1024.0)) + " Kb");

            lstDirectorios.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        String rut = txtRuta.getText();
                        if (!lstDirectorios.isSelectionEmpty()) {
                            String selec = lstDirectorios.getSelectedValue().toString();
                            atras = selec;
                            String rutfin = rut + "\\" + selec;
                            txtRuta.setText(rutfin);
                            Listas();
                        }
                    }
                }
            });
        }
    }//GEN-LAST:event_lstDirectoriosValueChanged

    private void lstArchivosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstArchivosValueChanged
        //muestra los archivos del directorio seleccionado
        if (!lstArchivos.isSelectionEmpty()) {
            String seleccion = lstArchivos.getSelectedValue().toString();
            String rutaCompleta = ruta + "\\" + seleccion;
            txtRuta.setText(rutaCompleta);
            File fichero = new File(rutaCompleta);
            long modificacion = fichero.lastModified();
            String pattern = "yyyy-MM-dd hh:mm aa";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            Date fechaModificacion = new Date(modificacion);

            txtModificacion.setText(simpleDateFormat.format(fechaModificacion));
            txtTamano.setText(Math.round(Math.ceil(fichero.length() / 1024.0)) + " Kb");
        }
    }//GEN-LAST:event_lstArchivosValueChanged

    private void lstOcultosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOcultosValueChanged
        //muestra los archivos ocultos del directorio selecionado
        String seleccion = lstOcultos.getSelectedValue().toString();
        String rutaCompleta = ruta + "\\" + seleccion;
        txtRuta.setText(rutaCompleta);
        File fichero = new File(rutaCompleta);
        long modificacion = fichero.lastModified();
        String pattern = "yyyy-MM-dd hh:mm aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date fechaModificacion = new Date(modificacion);

        txtModificacion.setText(simpleDateFormat.format(fechaModificacion));

        txtTamano.setText(Math.round(Math.ceil(fichero.length() / 1024.0)) + " Kb");
    }//GEN-LAST:event_lstOcultosValueChanged

    private void menuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoActionPerformed
        //permite crear un nuevo archivo
        String nombreArchivo = JOptionPane.showInputDialog("INGRESE NOMBRE DEL NUEVO ARCHIVO:");
        String ruta = txtRuta.getText().trim() + "\\" + nombreArchivo;

        File archivoNuevo = new File(ruta);
        if (!archivoNuevo.exists()) {
            try {
                archivoNuevo.createNewFile();
            } catch (IOException ex) {
                System.err.println("Error al crear el archivo");
            }
        }
    }//GEN-LAST:event_menuNuevoActionPerformed

    private void MenuRenombrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRenombrarActionPerformed
        //permite al usuario cambiar el nombre del archivo
        String archivoSeleccionado = null;
        if (!lstArchivos.isSelectionEmpty()) {
            archivoSeleccionado = String.valueOf(lstArchivos.getSelectedValue());
        } else if (!lstDirectorios.isSelectionEmpty()) {
            archivoSeleccionado = String.valueOf(lstDirectorios.getSelectedValue());
        } else {
            archivoSeleccionado = String.valueOf(lstOcultos.getSelectedValue());
        }
        String rutaArchivoSeleccionada = txtRuta.getText().trim() + "/" + archivoSeleccionado;
        File archivo = new File(rutaArchivoSeleccionada);
        String nombreNuevoArchivo = JOptionPane.showInputDialog("INGRESE NUEVO NOMBRE:");
        String rutaNuevoArchivo = txtRuta.getText().trim() + "/" + nombreNuevoArchivo;
        File archivoNuevo = new File(rutaNuevoArchivo);
        if (archivoNuevo.exists()) {
            JOptionPane.showMessageDialog(this, "YA EXISTE UN ARCHIVO CON ESE NOMBRE");
        } else {
            archivo.renameTo(archivoNuevo);
        }
    }//GEN-LAST:event_MenuRenombrarActionPerformed

    private void menuNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoArchivoActionPerformed
        //permite al usuario crear una nueva carpeta
        if (lstDirectorios.getSelectedIndex() != -1) {
            String seleccion = lstDirectorios.getSelectedValue().toString();
            String rutaCompleta = ruta + "\\" + seleccion;
            String nombreArchivo = JOptionPane.showInputDialog("INGRESE NOMBRE DE LA CARPETA:");
            String rutaCrear = rutaCompleta + "\\" + nombreArchivo;

            File archivoNuevo = new File(rutaCrear);
            if (!archivoNuevo.exists()) {
                archivoNuevo.mkdir();
                JOptionPane.showMessageDialog(null, "CARPETA CREADA CON EXITO");
            } else {
                JOptionPane.showMessageDialog(this, "YA EXISTE UNA CARPETA CON ESE NOMBRE, INTENTE CON OTRO NOMBRE");
            }
        }


    }//GEN-LAST:event_menuNuevoArchivoActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        //metodo aplicado para eliminar ya sea un archivo, una carpeta o una carpeta con archivos.
        String archivoSeleccionado = null;
        boolean isValid = true;
        if (!lstArchivos.isSelectionEmpty()) {
            archivoSeleccionado = lstArchivos.getSelectedValue().toString();
        } else if (!lstDirectorios.isSelectionEmpty()) {
            archivoSeleccionado = lstDirectorios.getSelectedValue().toString();
        } else if (!lstOcultos.isSelectionEmpty()) {
            archivoSeleccionado = lstOcultos.getSelectedValue().toString();
        } else {
            isValid = false;
            JOptionPane.showMessageDialog(this, "Seleccione un archivo o carpeta");
        }
        if (isValid == true) {
            String rutaArchivoSeleccionado = ruta + "\\" + archivoSeleccionado;
            File archivo = new File(rutaArchivoSeleccionado);
            eliminar(archivo);

            Listas();

        }

    }//GEN-LAST:event_menuEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //boton para salir del programa
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Visualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuRenombrar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblModificacion;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblTamaño;
    private javax.swing.JList lstArchivos;
    private javax.swing.JList lstDirectorios;
    private javax.swing.JList lstOcultos;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JMenuItem menuNuevo;
    private javax.swing.JMenuItem menuNuevoArchivo;
    private javax.swing.JTextField txtModificacion;
    private javax.swing.JTextField txtRAbsoluta;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtTamano;
    // End of variables declaration//GEN-END:variables

}
