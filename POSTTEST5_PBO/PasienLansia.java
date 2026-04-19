public class PasienLansia extends Pasien implements IPasienInfo {
    private String namaWali;
    private String riwayatPenyakit;

    public PasienLansia(String nama, int umur, String keluhan, String namaWali, String riwayatPenyakit) {
        super(nama, umur, keluhan);
        this.namaWali = namaWali;
        this.riwayatPenyakit = riwayatPenyakit;
    }

    public String getNamaWali()                { return namaWali; }
    public void   setNamaWali(String w)        { this.namaWali = w; }
    public String getRiwayatPenyakit()         { return riwayatPenyakit; }
    public void   setRiwayatPenyakit(String r) { this.riwayatPenyakit = r; }

    // =============================================
    // POLYMORPHISM - METHOD OVERRIDE (Abstract Method)
    // =============================================

    @Override
    public String getTipePasien() {
        return "Pasien Lansia";
    }

    @Override
    public String getKeteranganTambahan() {
        return "Wali: " + namaWali + " | Riwayat: " + riwayatPenyakit;
    }

    // Override hitungBiaya() - Pasien Lansia gratis biaya konsultasi
    @Override
    public double hitungBiaya() {
        return 0; // gratis konsultasi untuk lansia
    }

    // Override hitungBiaya() dengan jumlah obat - hanya bayar obat
    @Override
    public double hitungBiaya(int jumlahObat) {
        return jumlahObat * 15000; // konsultasi gratis, hanya bayar obat
    }

    // =============================================
    // IMPLEMENTASI INTERFACE IPasienInfo
    // =============================================

    @Override
    public String getRingkasanInfo() {
        return getNama() + " | " + getUmur() + " thn | " + getTipePasien()
               + " | Wali: " + namaWali;
    }

    @Override
    public boolean isDataValid() {
        return getNama() != null && !getNama().isEmpty()
            && getKeluhan() != null && !getKeluhan().isEmpty()
            && namaWali != null && !namaWali.isEmpty()
            && riwayatPenyakit != null && !riwayatPenyakit.isEmpty()
            && getUmur() >= 60; // lansia minimal 60 tahun
    }

    @Override
    public String getPrioritas() {
        return "SEDANG";
    }
}
