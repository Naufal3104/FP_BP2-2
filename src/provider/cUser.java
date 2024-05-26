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

    cKoneksi koneksi = new cKoneksi();
    private String username;
    private String password;
    private int id_user;
    private int id_level;

    cUser() {
        koneksi.connect();
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
        try {
            Connection con = koneksi.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login berhasil!");
                System.out.println("Selamat Datang, " + username + "!");
                int idUser = rs.getInt("id_user");
                int idLevel = rs.getInt("id_level");
                saveUserSession(idUser, idLevel);
                while (pilih0 != 6) {
                    System.out.println("Menu Admin");
                    System.out.println("1. Master User");
                    System.out.println("2. Master Member");
                    System.out.println("3. Master Makanan");
                    System.out.println("4. Master Transaksi");
                    System.out.println("5. Menu Kasir");
                    System.out.println("6. Logout");
                    System.out.print("Pilih : ");
                    pilih0 = input.nextInt();
                    switch (pilih0) {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:
                            while (pilih1 != 4) {
                                makanan.tampilkanDataMakanan();
                                System.out.println("1. Tambah data");
                                System.out.println("2. Ubah data");
                                System.out.println("3. Hapus data");
                                System.out.println("4. Kembali");
                                System.out.print("Pilih : ");
                                pilih1 = input.nextInt();
                                if (pilih1 == 1) {
                                    System.out.print("Masukkan Nama Makanan : ");
                                    String mkn = input.nextLine();
                                    input.nextLine();
                                    System.out.print("Masukkan Harga Makanan : ");
                                    int hrg = input.nextInt();
                                    System.out.print("Masukkan Stok Makanan : ");
                                    int stk = input.nextInt();
                                    makanan.tambahDataMakanan(mkn, hrg, stk);
                                } else if (pilih1 == 2) {
                                    System.out.print("Pilih Id Makanan yang akan diubah : ");
                                    int idm = input.nextInt();
                                    input.nextLine(); // Membersihkan buffer input

                                    PreparedStatement ed = con.prepareStatement("SELECT * FROM makanan WHERE id_makanan = ?");
                                    ed.setInt(1, idm);
                                    ResultSet rse = ed.executeQuery();

                                    if (rse.next()) {
                                        System.out.println("Nama Lama : " + rse.getString("nama_makanan"));
                                        System.out.print("Nama Baru : ");
                                        String mkn = input.nextLine(); // Membaca string setelah membersihkan buffer
                                        System.out.println("Harga Lama : " + rse.getString("harga"));
                                        System.out.print("Harga Baru : ");
                                        int hrg = input.nextInt();
                                        System.out.println("Stok Lama : " + rse.getString("stok"));
                                        System.out.print("Stok Baru : ");
                                        int stk = input.nextInt();
                                        makanan.ubahDataMakanan(idm, mkn, hrg, stk);
                                    } else {
                                        System.out.println("Data tidak ditemukan, coba lagi!");
                                    }

                                } else if (pilih1 == 3) {
                                    System.out.print("Pilh Id Makanan yang akan dihapus : ");
                                    int idm = input.nextInt();
                                    makanan.hapusDataMakanan(idm);
                                } else if (pilih1 > 4 && pilih1 < 1) {
                                    System.out.println("Input tidak valid!");
                                }
                            }
                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                    }
                }
            } else {
                System.out.println("Username atau password salah.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
