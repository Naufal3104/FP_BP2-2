/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provider;

import java.util.Scanner;

/**
 *
 * @author ahnaf
 */
public class cAplikasi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cBarang brg1 = new cBarang("Nasi Goreng", 11000);
        cBarang brg2 = new cBarang("Nasi Goreng Jawa", 13000);
        cBarang brg3 = new cBarang("Nasi Goreng Sei Kecombrang", 19000);
        cBarang brg4 = new cBarang("Es Teh", 3000);
        cBarang brg5 = new cBarang("Es Jeruk", 4000);
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih = 0, pilih3 = 0;
        int kode = 100, jumlah;
        do {
            System.out.println("APLIKASI TOKO WARUNG ORTEGA");
            System.out.println("1.Pembeli");
            System.out.println("2.Member");
            System.out.println("3.Admin");
            System.out.println("4.Pemilik");
            System.out.println("5.Exit");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    //pembeli
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    int pilihP = 0;
                    System.out.print("Masukkan Nama : ");
                    String nama = sc.next();
                    do {
                        kode++;
                        System.out.println("Akun Pembeli");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Kembali");
                        System.out.print("Pilih : ");
                        pilihP = sc.nextInt();
                        switch (pilihP) {
                            case 1:
                                cTransaksi br = null;
                                System.out.println("DAFTAR BARANG");
                                System.out.println("1.Nasi Goreng");
                                System.out.println("2.Nasi Goreng Jawa");
                                System.out.println("3.Nasi Goreng Sei Kecombrang");
                                System.out.println("4.Es Teh");
                                System.out.println("5.Es Jeruk");
                                System.out.print("Pilih : ");
                                pilih3 = sc.nextInt();
                                System.out.print("Jumlah : ");
                                jumlah = sc.nextInt();

                                if (pilih3 == 1) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg1, jumlah, 0);
                                } else if (pilih3 == 2) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg2, jumlah, 0);
                                } else if (pilih3 == 3) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg3, jumlah, 0);
                                } else if (pilih3 == 4) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg4, jumlah, 0);
                                } else if (pilih3 == 5) {
                                    br = new cTransaksi(String.valueOf(kode), nama, brg5, jumlah, 0);
                                }
                                beli.tambahTransaksi(br);
                                break;
                            case 2:
                                beli.lihatTransaksi();
                                System.out.print("Hapus Nomor : ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3:
                                beli.lihatTransaksi();
                                break;
                            case 4:
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Selamat Datang kembali...");
                                break;
                        }
                    } while (pilihP != 4);
                    break;
                case 2:
                    break;
                case 3:
                    jual.lihatTransaksi();
                    cTransaksi t = jual.getFront();
                    do {
                        if (t.getStatus() == 0) {
                            System.out.println("Kode    : " + t.getKode());
                            System.out.println("Pembeli : " + t.getPembeli());
                            System.out.println("Barang  : " + t.getBarang().getNama());
                            System.out.println("Jumlah  : " + t.getJumlah());
                            System.out.println("-Pilih Aksi-");
                            System.out.println("1.Diproses");
                            System.out.println("2.Selesai");
                            System.out.print("Pilih = ");
                            int aksi = sc.nextInt();
                            if (aksi == 1) {
                                jual.prosesTransaksi(t);
                                System.out.println("Berhasil diproses..");
                            } else {
                                break;
                            }
                        }
                        t = t.next;
                    } while (t != null);
                    break;
                case 4:
                    System.out.println("Jumlah Transaksi Diproses : " + jual.lihatDiproses());
                    System.out.println("Pemasukan : " + jual.lihatPemasukan());
                    break;
                case 5:
                    System.out.println("Terimakasih");

            }

        } while (pilih
                != 5);
    }
}
