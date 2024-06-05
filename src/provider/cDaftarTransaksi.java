package provider;

public class cDaftarTransaksi {

    cTransaksi front, rear;
    int jumlah;

    cDaftarTransaksi() {
        front = rear = null;
        jumlah = 0;
    }

    public cTransaksi getFront() {
        return front;
    }

    public cTransaksi getRear() {
        return rear;
    }

    public void tambahTransaksi(cTransaksi baru) {
        if (baru != null) {
            if (rear == null) {
                front = rear = baru;
            } else {
                rear.next = baru;
                rear = baru;
            }
            System.out.println("Tambah Sukses");
        } else {
            System.out.println("Gagal menambah transaksi. Data transaksi tidak valid.");
        }
    }

    public void lihatTransaksi() {
        int i = 1;
        System.out.println("DAFTAR TRANSAKSI");
        for (cTransaksi t = front; t != null; t = t.next) {
            System.out.print(i + ". ");
            System.out.print(t.getKode() + " | ");
            System.out.print(t.getPembeli() + " | ");
            System.out.print(t.getBarang().getNama() + " | ");
            System.out.println(t.getJumlah() + " | ");
            System.out.println(t.getStatus() + " | ");
            i++;
        }
        System.out.println("");
    }

    public void lihatTransaksiMember() {
        int i = 1;
        double total = 0, diskon;
        System.out.println("DAFTAR TRANSAKSI MEMBER");
        for (cTransaksi t = front; t != null; t = t.next) {
            System.out.print(i + ". ");
            System.out.print(t.getKode() + " | ");
            System.out.print(t.getPembeli() + " | ");
            System.out.print(t.getBarang().getNama() + " | ");
            System.out.println(t.getJumlah() + " | ");
            System.out.println(t.getStatus() + " | ");
            i++;
            total = total + (t.getBarang().getHarga() * t.getJumlah());
        }
        System.out.println("Total Belanja  : " + total);
        System.out.println("Diskon         : " + (0.1 * total));
        System.out.println("Jumlah Dibayar : " + (total - (0.1 * total)));
    }

    public void hapusTransaksi(int nomor) {
        cTransaksi t = front;
        cTransaksi prev = null;
        int i = 1;
        boolean found = false; // Tambahkan variabel untuk menandai apakah transaksi ditemukan

        while (t != null) {
            if (i == nomor) {
                found = true; // Transaksi ditemukan
                break;
            }
            i++;
            prev = t;
            t = t.next;
        }

        if (found) {
            // Hapus transaksi
            if (nomor == 1) {
                if (t.next == null) {
                    front = rear = null;
                } else {
                    front = front.next;
                    t.next = null;
                }
            } else {
                // Hapus ujung belakang
                if (t.next == null) {
                    rear = prev;
                    rear.next = null;
                } else {
                    prev.next = t.next;
                    t.next = null;
                }
            }
            System.out.println("[" + t.getBarang().getNama() + "] dihapus...");
        } else {
            System.out.println("Transaksi dengan nomor " + nomor + " tidak ditemukan.");
        }
    }

    public void sambungTransaksi(cTransaksi depan, cTransaksi belakang) {
        if (rear == null) {
            front = depan;
            rear = belakang;
        } else {
            rear.next = depan;
            rear = belakang;
        }

    }

    public void prosesTransaksi(cTransaksi t) {
        t.setStatus(1);
    }

    public int lihatDiproses() {
        cTransaksi t = front;
        int proses = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                proses++;
            }
        }
        return proses;
    }

    public double lihatPemasukan() {
        cTransaksi t = front;
        double nominal = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
                System.out.print("Kode : " + t.getKode());
                if (t.getPembeli().compareToIgnoreCase("10") == 0 || t.getPembeli().compareToIgnoreCase("11") == 0 || t.getPembeli().compareToIgnoreCase("12") == 0) {
                    nominal = nominal - (0.1 * nominal);
                }
            }
        }
        return nominal;
    }

    public void ubahNamaDanHarga(String n, int h, cBarang brg1, cBarang brg2, cBarang brg3, cBarang brg4, cBarang brg5) {        
        // Periksa nama barang satu per satu dan ubah harganya jika ditemukan
        if (brg1.getNama().equalsIgnoreCase(n)) {
            brg1.setHarga(h);
        } else if (brg2.getNama().equalsIgnoreCase(n)) {
            brg2.setHarga(h);
        } else if (brg3.getNama().equalsIgnoreCase(n)) {
            brg3.setHarga(h);
        } else if (brg4.getNama().equalsIgnoreCase(n)) {
            brg4.setHarga(h);
        } else if (brg5.getNama().equalsIgnoreCase(n)) {
            brg5.setHarga(h);
        } else {
            System.out.println("Barang dengan nama '" + n + "' tidak ditemukan.");
        }
    }

    public void lihatSemuaBarang(cBarang barang1, cBarang barang2, cBarang barang3, cBarang barang4, cBarang barang5) {
        System.out.println("DAFTAR SEMUA BARANG");

        // Tampilkan data nama dan harga dari semua objek barang
        if (barang1 != null) {
            System.out.println("1. " + barang1.getNama() + " | Harga: " + barang1.getHarga());
        }
        if (barang2 != null) {
            System.out.println("2. " + barang2.getNama() + " | Harga: " + barang2.getHarga());
        }
        if (barang3 != null) {
            System.out.println("3. " + barang3.getNama() + " | Harga: " + barang3.getHarga());
        }
        if (barang4 != null) {
            System.out.println("4. " + barang4.getNama() + " | Harga: " + barang4.getHarga());
        }
        if (barang5 != null) {
            System.out.println("5. " + barang5.getNama() + " | Harga: " + barang5.getHarga());
        }
    }
}
