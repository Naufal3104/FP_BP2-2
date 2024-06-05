package provider;

public class cBarang {

    String nama;
    int harga;

    cBarang(String n, int h) {
        nama = n;
        harga = h;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setNama(String n) {
        nama = n;
    }

    public void setHarga(int h) {
        harga = h;
    }
}
