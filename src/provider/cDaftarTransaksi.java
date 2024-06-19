package provider;

public class cDaftarTransaksi {

    cTransaksi front, rear;
    int jumlah;
    double totalPendapatan = 0, totalNasgor = 0, totalNasgorJawa = 0, totalNasgorKecombrang = 0, totalEsTeh = 0, totalEsJeruk = 0;
    double totalBelanjaAndi = 0, totalBelanjaDono = 0, totalBelanjaRenita = 0;

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
        double penjualan = t.getBarang().getHarga() * t.getJumlah();
        if (t.getBarang().getNama().equals("Nasi Goreng")) {
            if (t.getPembeli().equals("10") || t.getPembeli().equals("11") || t.getPembeli().equals("12")) {
                totalNasgor += penjualan - (penjualan * 0.1);
            } else {
                totalNasgor += penjualan;
            }
            totalPendapatan += totalNasgor;
        } else if (t.getBarang().getNama().equals("Nasi Goreng Jawa")) {
            if (t.getPembeli().equals("10") || t.getPembeli().equals("11") || t.getPembeli().equals("12")) {
                totalNasgorJawa += penjualan - (penjualan * 0.1);
            } else {
                totalNasgorJawa += penjualan;
            }
            totalPendapatan += totalNasgorJawa;
        } else if (t.getBarang().getNama().equals("Nasi Goreng Sei Kecombrang")) {
            if (t.getPembeli().equals("10") || t.getPembeli().equals("11") || t.getPembeli().equals("12")) {
                totalNasgorKecombrang += penjualan - (penjualan * 0.1);
            } else {
                totalNasgorKecombrang += penjualan;
            }
            totalPendapatan += totalNasgorKecombrang;
        } else if (t.getBarang().getNama().equals("Es Teh")) {
            if (t.getPembeli().equals("10") || t.getPembeli().equals("11") || t.getPembeli().equals("12")) {
                totalEsTeh += penjualan - (penjualan * 0.1);
            } else {
                totalEsTeh += penjualan;
            }
            totalPendapatan += totalEsTeh;
        } else if (t.getBarang().getNama().equals("Es Jeruk")) {
            if (t.getPembeli().equals("10") || t.getPembeli().equals("11") || t.getPembeli().equals("12")) {
                totalEsJeruk += penjualan - (penjualan * 0.1);
            } else {
                totalEsJeruk += penjualan;
            }
            totalPendapatan += totalEsJeruk;
        }

        if (t.getPembeli().equals("10")) { // asumsikan id "10" adalah Andi
            totalBelanjaAndi += penjualan - (penjualan * 0.1);
        } else if (t.getPembeli().equals("11")) { // asumsikan id "11" adalah Dono
            totalBelanjaDono += penjualan - (penjualan * 0.1);
        } else if (t.getPembeli().equals("12")) { // asumsikan id "12" adalah Renita
            totalBelanjaRenita += penjualan - (penjualan * 0.1);
        }
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
        return totalPendapatan;
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

    public void tampilkanTotalPenjualan() {
        System.out.println("1. Nasi Goreng : " + totalNasgor);
        System.out.println("2. Nasi Goreng Jawa : " + totalNasgorJawa);
        System.out.println("3. Nasi Goreng Sei Kecombrang : " + totalNasgorKecombrang);
        System.out.println("4. Es Teh : " + totalEsTeh);
        System.out.println("5. Es Jeruk : " + totalEsJeruk);
    }

    public void tampilkanPengeluaranMember() {
        System.out.println("1. Andi   : " + totalBelanjaAndi);
        System.out.println("2. Dono   : " + totalBelanjaDono);
        System.out.println("3. Renita : " + totalBelanjaRenita);
    }

    private void tampilkanGrafikBarang(String namaBarang, double totalPenjualan) {
        int jumlahStrip = (int) (totalPenjualan / 5000); // Pembulatan ke bawah ke puluhan ribu
        StringBuilder grafik = new StringBuilder();
        for (int i = 0; i < jumlahStrip; i++) {
            grafik.append("X");
        }
        System.out.println(namaBarang + " : " + grafik.toString() + " " + totalPenjualan);
    }

    public void tampilkanGrafikPenjualan() {
        System.out.println("Grafik Penjualan:");
        tampilkanGrafikBarang("Nasi Goreng", totalNasgor);
        tampilkanGrafikBarang("Nasi Goreng Jawa", totalNasgorJawa);
        tampilkanGrafikBarang("Nasi Goreng Sei Kecombrang", totalNasgorKecombrang);
        tampilkanGrafikBarang("Es Teh", totalEsTeh);
        tampilkanGrafikBarang("Es Jeruk", totalEsJeruk);
    }
}
