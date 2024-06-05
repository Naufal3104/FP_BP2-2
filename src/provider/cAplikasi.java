package provider;

import java.util.InputMismatchException;
import java.util.Scanner;

public class cAplikasi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cBarang brg1 = new cBarang("Nasi Goreng", 11000);
        cBarang brg2 = new cBarang("Nasi Goreng Jawa", 13000);
        cBarang brg3 = new cBarang("Nasi Goreng Sei Kecombrang", 19000);
        cBarang brg4 = new cBarang("Es Teh", 3000);
        cBarang brg5 = new cBarang("Es Jeruk", 4000);
        int id1 = 10, pwd1 = 100;
        int id2 = 11, pwd2 = 110;
        int id3 = 12, pwd3 = 120;
        int id, pin;
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
                    boolean valid = false;
                    do {
                        System.out.print("ID = ");
                        id = sc.nextInt();
                        System.out.print("PIN = ");
                        pin = sc.nextInt();
                        if (id == id1 && pin == pwd1) {
                            valid = true;
                        } else if (id == id2 && pin == pwd2) {
                            valid = true;
                        } else if (id == id3 && pin == pwd3) {
                            valid = true;
                        }
                        if (valid == false) {
                            System.out.println("ID/PIN Salah!");
                        } else {
                            break;
                        }
                    } while (valid == true);
                    if (valid == true) {
                        System.out.println("Selamat Datang..");
                        beli = new cDaftarTransaksi();
                        do {
                            kode++;
                            System.out.println("Akun Member");
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
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg1, jumlah, 0);
                                    } else if (pilih3 == 2) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg2, jumlah, 0);
                                    } else if (pilih3 == 3) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg3, jumlah, 0);
                                    } else if (pilih3 == 4) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg4, jumlah, 0);
                                    } else if (pilih3 == 5) {
                                        br = new cTransaksi(String.valueOf(kode), String.valueOf(id), brg5, jumlah, 0);
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
                                    beli.lihatTransaksiMember();
                                    break;
                                case 4:
                                    jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                    System.out.println("Selamat Datang kembali...");
                                    break;
                            }
                        } while (pilihP != 4);
                    }
                    break;
                case 3:
                    System.out.println("Akun Admin");
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
                    int pilih4;
                    do {
                        System.out.println("Akun Owner");
                        System.out.println("Jumlah Transaksi Diproses : " + jual.lihatDiproses());
                        System.out.println("Pemasukan : " + jual.lihatPemasukan());
                        System.out.println("1. Ubah Barang");
                        System.out.println("2. Lihat Barang");
                        System.out.println("3. Kembali");
                        pilih4 = sc.nextInt();
                        if (pilih4 == 1) {
                            System.out.print("Masukkan nama barang yang akan diubah: ");
                            sc.nextLine(); // Mengonsumsi karakter newline setelah membaca angka
                            String namaBarang = sc.nextLine(); // Menggunakan sc.nextLine() untuk membaca seluruh baris
                            System.out.print("Masukkan harga baru: ");
                            int hargaBaru = 0;
                            try {
                                hargaBaru = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Input harga tidak valid. Harap masukkan angka.");
                                return; // Keluar dari fungsi jika input tidak valid
                            }
                            jual.ubahNamaDanHarga(namaBarang, hargaBaru, brg1, brg2, brg3, brg4, brg5);
                        } else if (pilih4 == 2) {
                            jual.lihatSemuaBarang(brg1, brg2, brg3, brg4, brg5);
                        }
                    } while (pilih4 != 3);
                    break;
                case 5:
                    System.out.println("Terimakasih");
            }
        } while (pilih != 5);
    }
}
