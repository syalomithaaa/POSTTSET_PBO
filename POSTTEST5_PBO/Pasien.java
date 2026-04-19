public abstract class Pasien {
    private String nama;
    private int umur;
    private String keluhan;

    public Pasien(String nama, int umur, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
    }

    // ── Getter & Setter (Encapsulation) ──────────────────────────────────────
    public String getNama()            { return nama; }
    public void   setNama(String nama) { this.nama = nama; }

    public int    getUmur()            { return umur; }
    public void   setUmur(int umur)    { this.umur = umur; }

    public String getKeluhan()         { return keluhan; }
    public void   setKeluhan(String k) { this.keluhan = k; }

    // ── ABSTRACT METHOD (wajib diimplementasikan oleh subclass) ──────────────
    public abstract String getTipePasien();
    public abstract String getKeteranganTambahan();
    public abstract double hitungBiaya();

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
    // Overload 2 – tarif dasar + biaya obat (jumlah obat)
    public double hitungBiaya(int jumlahObat) {
        return hitungBiaya() + (jumlahObat * 15000);
    }

    // Overload 3 – tarif dasar + biaya obat + persentase tambahan
    public double hitungBiaya(int jumlahObat, double persenTambahan) {
        double subtotal = hitungBiaya(jumlahObat);
        return subtotal + (subtotal * persenTambahan / 100);
    }
}
