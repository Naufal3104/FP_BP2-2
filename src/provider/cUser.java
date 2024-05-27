/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provider;

import java.util.Scanner;
import java.sql.*;
import javax.swing.InputMap;

/**
 *
 * @author LENOVO
 */
public class cUser {

    private String username;
    private String password;
    private int id_user;
    private int id_level;

    cUser() {
        
    }

    public void Login() {
        cMakanan makanan = new cMakanan();
        Scanner input = new Scanner(System.in);
        int pilih0 = 0, pilih1 = 0;
        System.out.println("==== Login Form ====");
        System.out.print("Masukkan username: ");
        username = input.next();
        System.out.print("Masukkan password: ");
        password = input.next();
    }

    public int getId_User() {
        return id_user;
    }

    public int getId_Level() {
        return id_level;
    }

    public void saveUserSession(int id, int level) {
        id_user = id;
        id_level = level;
    }
}
