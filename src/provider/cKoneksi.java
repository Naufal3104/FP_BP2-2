/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provider;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class cKoneksi {

    private String url = "jdbc:mysql://localhost/db_kasir";
    private String username_xampp = "root";
    private String password_xampp = "";
    private Connection con;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, username_xampp, password_xampp);
//            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }
}
