public class PasienUmum extends Pasien implements IPasienInfo {
    private String nomorBPJS;

    public PasienUmum(String nama, int umur, String keluhan, String nomorBPJS) {
        super(nama, umur, keluhan);
        this.nomorBPJS = nomorBPJS;
    }

    public String getNomorBPJS()          { return nomorBPJS; }
    public void   setNomorBPJS(String no) { this.nomorBPJS = no; }

    // =============================================
    // POLYMORPHISM - METHOD OVERRIDE (Abstract Method)
    // =============================================

    @Override
    public String getTipePasien() {
        return "Pasien Umum";
    }

    @Override
    public String getKeteranganTambahan() {
        return "No. BPJS: " + nomorBPJS;
    }

    // Override hitungBiaya() - Pasien Umum dapat subsidi BPJS 30%
    @Override
    public double hitungBiaya() {
        return 50000 * 0.70; // biaya dasar dikurangi subsidi BPJS 30%
    }

    // Override hitungBiaya() dengan jumlah obat - subsidi BPJS berlaku juga untuk obat
    @Override
    public double hitungBiaya(int jumlahObat) {
        return (50000 + (jumlahObat * 15000)) * 0.70;
    }

    // =============================================
    // IMPLEMENTASI INTERFACE IPasienInfo
    // =============================================

    @Override
    public String getRingkasanInfo() {
        return getNama() + " | " + getUmur() + " thn | " + getTipePasien()
               + " | BPJS: " + nomorBPJS;
    }

    @Override
    public boolean isDataValid() {
        return getNama() != null && !getNama().isEmpty()
            && getKeluhan() != null && !getKeluhan().isEmpty()
            && nomorBPJS != null && !nomorBPJS.isEmpty()
            && getUmur() > 0;
    }

    @Override
    public String getPrioritas() {
        return "SEDANG";
    }
}
