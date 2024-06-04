/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package provider;

/**
 *
 * @author ahnaf
 */
public class cTransaksi {

    String kode;
    String pembeli;
    cBarang barang;
    int jumlahBrg;
    int status;
    cTransaksi next;

    cTransaksi(String k, String p, cBarang b, int j, int s) {
        kode = k;
        pembeli = p;
        barang = b;
        jumlahBrg = j;
        status = s;
        next = null;
    }

    public void setStatus(int s) {
        status = s;
    }

    public String getKode() {
        return kode;
    }

    public String getPembeli() {
        return pembeli;
    }

    public cBarang getBarang() {
        return barang;
    }

    public int getJumlah() {          //penghitungan biaya
        return jumlahBrg;
    }

    public int getStatus() {
        return status;
    }
}
