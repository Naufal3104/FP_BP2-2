/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provider;

import java.sql.*;

public class cMakanan {

    cKoneksi koneksi = new cKoneksi();

    public cMakanan() {
        koneksi.connect();
    }

    public void tampilkanDataMakanan() {
        try {
            Connection con = koneksi.getCon();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_makanan, nama_makanan, harga, stok FROM makanan");

            System.out.println("Data Makanan:");
            System.out.println("ID\tNama Makanan\t\t\tHarga\tStok");
            while (rs.next()) {
                int id = rs.getInt("id_makanan");
                String nama = rs.getString("nama_makanan");
                double harga = rs.getDouble("harga");
                int stok = rs.getInt("stok");

                System.out.printf("%d\t%-30s\t%.0f\t%d\n", id, nama, harga, stok);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ubahDataMakanan(int idm, String mkn, int hrg, int stk) {
        try {
            Connection con = koneksi.getCon();
            PreparedStatement stmt = con.prepareStatement("UPDATE makanan SET nama_makanan=?, harga=?, stok=? WHERE id_makanan=?");
            stmt.setString(1, mkn);
            stmt.setDouble(2, hrg);
            stmt.setInt(3, stk);
            stmt.setInt(4, idm);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data makanan dengan ID " + idm + " berhasil diubah.");
            } else {
                System.out.println("Data makanan dengan ID " + idm + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tambahDataMakanan(String mkn, int hrg, int stk) {
        try {
            Connection con = koneksi.getCon();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO makanan VALUES(?,?,?,?)");
            stmt.setInt(1, 0);
            stmt.setString(2, mkn);
            stmt.setInt(3, hrg);
            stmt.setInt(4, stk);
            stmt.executeUpdate();
            System.out.println("Berhasil Menambahkan data!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
