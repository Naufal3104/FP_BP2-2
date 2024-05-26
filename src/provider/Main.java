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
                cUser user = new cUser();
                user.Login();
            } else if (pilih0 == 2) {
                // handle member login
            }
        }
        System.out.println("Thanks!");
    }
}
