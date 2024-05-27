/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provider;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Main {

    public static void main(String[] args) {
        cUser user1 = new cUser(1, "Admin", "admin", "admin123", 1);
        cUser user2 = new cUser(2, "Manager", "manager", "manager123", 2);
        cDoubleLinkedList<cUser> userList = new cDoubleLinkedList<>();
        userList.addToEnd(user1);
        userList.addToEnd(user2);
        Scanner input = new Scanner(System.in);
        int pilih0 = 0;
        while (pilih0 != 3) {
            System.out.println("Selamat Datang");
            System.out.println("Silahkan pilih tipe pengguna anda");
            System.out.println("1. User");
            System.out.println("2. Member");
            System.out.println("3. Keluar");
            System.out.print("Pilih : ");
            pilih0 = input.nextInt();
            if (pilih0 == 1) {
                System.out.println("==== Login Form ====");
                System.out.print("Masukkan username: ");
                String inputUsername = input.next();
                System.out.print("Masukkan password: ");
                String inputPassword = input.next();
                cUser user = new cUser();
                user.setUsername(inputUsername);
                user.setPassword(inputPassword);
                user.Login(userList);
            } else if (pilih0 == 2) {
                // handle member login
            }
        }
        System.out.println("Thanks!");
    }
}
