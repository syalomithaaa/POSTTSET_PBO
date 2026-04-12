public class Pasien {
    private String nama;
    private int umur;
    private String keluhan;

    public Pasien(String nama, int umur, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
    }

    // ── Getter & Setter (Encapsulation - Posttest 2) ──────────────────────────
    public String getNama()        { return nama; }
    public void   setNama(String nama)    { this.nama = nama; }

    public int    getUmur()        { return umur; }
    public void   setUmur(int umur)       { this.umur = umur; }

    public String getKeluhan()     { return keluhan; }
    public void   setKeluhan(String k)    { this.keluhan = k; }

    // ── Method yang akan di-Override tiap subclass (Posttest 3) ───────────────
    public String getTipePasien() {
        return "Pasien Reguler";
    }

    public String getKeteranganTambahan() {
        return "Tidak ada keterangan tambahan.";
    }

    // ── POLYMORPHISM: OVERLOADING tampilInfo() ────────────────────────────────
    // Overload 1 – tanpa parameter: tampil ringkas
    public void tampilInfo() {
        System.out.println("  Nama    : " + nama);
        System.out.println("  Umur    : " + umur + " tahun");
        System.out.println("  Tipe    : " + getTipePasien());
    }

    // Overload 2 – dengan boolean: tampil lengkap jika true
    public void tampilInfo(boolean lengkap) {
        tampilInfo();
        if (lengkap) {
            System.out.println("  Keluhan : " + keluhan);
            System.out.println("  Ket.    : " + getKeteranganTambahan());
        }
    }

    // Overload 3 – dengan String label: tampil dengan header kustom
    public void tampilInfo(String label) {
        System.out.println("──── " + label + " ────");
        tampilInfo(true);
    }

    // ── POLYMORPHISM: OVERRIDE toString() ────────────────────────────────────
    @Override
    public String toString() {
        return "[" + getTipePasien() + "] " + nama
               + " | " + umur + " thn | " + keluhan;
    }

    // ── POLYMORPHISM: OVERLOADING hitungBiaya() ──────────────────────────────
    // Overload 1 – tarif dasar
    public double hitungBiaya() {
        return 50000; // biaya dasar konsultasi
    }

    // Overload 2 – tarif dasar + biaya obat
    public double hitungBiaya(double biayaObat) {
        return hitungBiaya() + biayaObat;
    }

    // Overload 3 – tarif dasar + biaya obat + biaya lab
    public double hitungBiaya(double biayaObat, double biayaLab) {
        return hitungBiaya(biayaObat) + biayaLab;
    }
}
