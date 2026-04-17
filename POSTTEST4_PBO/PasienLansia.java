public class PasienLansia extends Pasien {
    private String namaWali;
    private String riwayatPenyakit;

    public PasienLansia(String nama, int umur, String keluhan, String namaWali, String riwayatPenyakit) {
        super(nama, umur, keluhan);
        this.namaWali = namaWali;
        this.riwayatPenyakit = riwayatPenyakit;
    }

    public String getNamaWali()               { return namaWali; }
    public void   setNamaWali(String w)       { this.namaWali = w; }
    public String getRiwayatPenyakit()        { return riwayatPenyakit; }
    public void   setRiwayatPenyakit(String r){ this.riwayatPenyakit = r; }

    // =============================================
    // POLYMORPHISM - METHOD OVERRIDE (Posttest 3 & 4)
    // =============================================

    @Override
    public String getTipePasien() {
        return "Pasien Lansia";
    }

    @Override
    public String getKeteranganTambahan() {
        return "Wali: " + namaWali + " | Riwayat: " + riwayatPenyakit;
    }

    // Override hitungBiaya() #1 - Pasien Lansia gratis biaya dasar (program lansia)
    @Override
    public double hitungBiaya() {
        return 0; // gratis konsultasi untuk lansia
    }

    // Override hitungBiaya() #2 - hanya bayar biaya obat
    @Override
    public double hitungBiaya(int jumlahObat) {
        return jumlahObat * 15000; // konsultasi gratis, hanya bayar obat
    }
}
