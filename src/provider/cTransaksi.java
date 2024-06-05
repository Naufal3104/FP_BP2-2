package provider;
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
