import java.util.ArrayList;

public class Antrian {
    private ArrayList<Pasien> daftarAntrian;
    private int nomorUrut;

    public Antrian() {
        daftarAntrian = new ArrayList<>();
        nomorUrut = 1;
    }

    // Tambah antrian dengan validasi via Interface IPasienInfo
    public void tambahAntrian(Pasien pasien) {
        // Cek apakah objek mengimplementasikan IPasienInfo (polymorphism via interface)
        if (pasien instanceof IPasienInfo) {
            IPasienInfo info = (IPasienInfo) pasien;
            if (!info.isDataValid()) {
                System.out.println("✘ Data pasien tidak valid! Pastikan semua field terisi dengan benar.");
                return;
            }
            System.out.println("  Prioritas antrian  : " + info.getPrioritas());
            System.out.println("  Ringkasan          : " + info.getRingkasanInfo());
        }
        daftarAntrian.add(pasien);
        System.out.println("✔ Pasien '" + pasien.getNama() + "' berhasil ditambahkan ke antrian no. " + nomorUrut++);
    }

    // Lihat semua antrian - tampilInfo() tanpa parameter (Overloading #1)
    public void lihatAntrian() {
        if (daftarAntrian.isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("\n========== DAFTAR ANTRIAN KLINIK CITRA MEDIKA ==========");
        int no = 1;
        for (Pasien p : daftarAntrian) {
            System.out.println("\nNo. Antrian: " + no++);
            p.tampilInfo(true); // Overloading #2: dengan boolean
        }
    }

    // Lihat antrian dengan label (Overloading #3: dengan String)
    public void lihatAntrian(String label) {
        System.out.println("\n========== " + label.toUpperCase() + " ==========");
        int no = 1;
        for (Pasien p : daftarAntrian) {
            System.out.println("\nNo. " + no++);
            p.tampilInfo(label); // Overloading #3
        }
    }

    // Update antrian - menggunakan instanceof
    public void updateAntrian(int index, String keluhan) {
        if (index < 0 || index >= daftarAntrian.size()) {
            System.out.println("✘ Nomor antrian tidak ditemukan.");
            return;
        }
        Pasien p = daftarAntrian.get(index);
        p.setKeluhan(keluhan);

        if (p instanceof PasienUmum) {
            System.out.print("Masukkan nomor BPJS baru: ");
        } else if (p instanceof PasienLansia) {
            System.out.print("Masukkan nama wali baru: ");
        } else if (p instanceof PasienDarurat) {
            System.out.print("Masukkan tingkat kegawatan baru: ");
        }
        System.out.println("✔ Data pasien '" + p.getNama() + "' berhasil diupdate.");
    }

    // Hapus antrian
    public void hapusAntrian(int index) {
        if (index < 0 || index >= daftarAntrian.size()) {
            System.out.println("✘ Nomor antrian tidak ditemukan.");
            return;
        }
        String nama = daftarAntrian.get(index).getNama();
        daftarAntrian.remove(index);
        System.out.println("✔ Antrian pasien '" + nama + "' berhasil dihapus.");
    }

    // Tampil ringkasan biaya semua pasien (demonstrasi Overloading hitungBiaya)
    public void tampilRingkasanBiaya() {
        System.out.println("\n========== RINGKASAN BIAYA PASIEN ==========");
        for (Pasien p : daftarAntrian) {
            System.out.println("\nPasien : " + p.getNama() + " (" + p.getTipePasien() + ")");
            System.out.printf("  Biaya konsultasi saja    : Rp %.0f%n", p.hitungBiaya());
            System.out.printf("  Biaya + 3 obat           : Rp %.0f%n", p.hitungBiaya(3));
            System.out.printf("  Biaya + 3 obat + 10%%    : Rp %.0f%n", p.hitungBiaya(3, 10));
        }
        System.out.println("=============================================");
    }

    // Tampil semua prioritas antrian menggunakan Interface IPasienInfo
    public void tampilPrioritas() {
        System.out.println("\n========== PRIORITAS ANTRIAN ==========");
        int no = 1;
        for (Pasien p : daftarAntrian) {
            if (p instanceof IPasienInfo) {
                IPasienInfo info = (IPasienInfo) p;
                System.out.println("No." + no + " | " + info.getRingkasanInfo()
                                   + " | Prioritas: " + info.getPrioritas());
            }
            no++;
        }
        System.out.println("=======================================");
    }

    public ArrayList<Pasien> getDaftarAntrian() {
        return daftarAntrian;
    }
}
