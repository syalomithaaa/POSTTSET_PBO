public class PasienUmum extends Pasien {
    private String nomorBPJS;

    public PasienUmum(String nama, int umur, String keluhan, String nomorBPJS) {
        super(nama, umur, keluhan);
        this.nomorBPJS = nomorBPJS;
    }

    public String getNomorBPJS()          { return nomorBPJS; }
    public void   setNomorBPJS(String no) { this.nomorBPJS = no; }

    // =============================================
    // POLYMORPHISM - METHOD OVERRIDE (Posttest 3 & 4)
    // =============================================

    @Override
    public String getTipePasien() {
        return "Pasien Umum";
    }

    @Override
    public String getKeteranganTambahan() {
        return "No. BPJS: " + nomorBPJS;
    }

    // Override hitungBiaya() #1 - Pasien Umum dapat subsidi BPJS 30%
    @Override
    public double hitungBiaya() {
        return super.hitungBiaya() * 0.70;
    }

    // Override hitungBiaya() #2 - subsidi BPJS berlaku juga untuk obat
    @Override
    public double hitungBiaya(int jumlahObat) {
        return super.hitungBiaya(jumlahObat) * 0.70;
    }
}
