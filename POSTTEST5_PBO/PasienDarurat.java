public class PasienDarurat extends Pasien implements IPasienInfo {
    private String tingkatKegawatan; // RINGAN / SEDANG / KRITIS
    private String petugasPengantar;

    public PasienDarurat(String nama, int umur, String keluhan, String tingkatKegawatan, String petugasPengantar) {
        super(nama, umur, keluhan);
        this.tingkatKegawatan = tingkatKegawatan;
        this.petugasPengantar = petugasPengantar;
    }

    public String getTingkatKegawatan()         { return tingkatKegawatan; }
    public void   setTingkatKegawatan(String t) { this.tingkatKegawatan = t; }
    public String getPetugasPengantar()         { return petugasPengantar; }
    public void   setPetugasPengantar(String p) { this.petugasPengantar = p; }

    // =============================================
    // POLYMORPHISM - METHOD OVERRIDE (Abstract Method)
    // =============================================

    @Override
    public String getTipePasien() {
        return "Pasien Darurat";
    }

    @Override
    public String getKeteranganTambahan() {
        return "Kegawatan: " + tingkatKegawatan + " | Pengantar: " + petugasPengantar;
    }

    // Override hitungBiaya() - ada biaya tambahan penanganan darurat
    @Override
    public double hitungBiaya() {
        double biayaTambahan;
        switch (tingkatKegawatan.toUpperCase()) {
            case "KRITIS":  biayaTambahan = 200000; break;
            case "SEDANG":  biayaTambahan = 100000; break;
            default:        biayaTambahan = 50000;  break; // RINGAN
        }
        return 50000 + biayaTambahan;
    }

    // Override hitungBiaya() dengan jumlah obat - biaya darurat + obat
    @Override
    public double hitungBiaya(int jumlahObat) {
        return hitungBiaya() + (jumlahObat * 15000);
    }

    // =============================================
    // IMPLEMENTASI INTERFACE IPasienInfo
    // =============================================

    @Override
    public String getRingkasanInfo() {
        return getNama() + " | " + getUmur() + " thn | " + getTipePasien()
               + " | Kegawatan: " + tingkatKegawatan;
    }

    @Override
    public boolean isDataValid() {
        String level = tingkatKegawatan != null ? tingkatKegawatan.toUpperCase() : "";
        boolean levelValid = level.equals("RINGAN") || level.equals("SEDANG") || level.equals("KRITIS");

        return getNama() != null && !getNama().isEmpty()
            && getKeluhan() != null && !getKeluhan().isEmpty()
            && petugasPengantar != null && !petugasPengantar.isEmpty()
            && levelValid
            && getUmur() > 0;
    }

    @Override
    public String getPrioritas() {
        switch (tingkatKegawatan.toUpperCase()) {
            case "KRITIS": return "TINGGI";
            case "SEDANG": return "TINGGI";
            default:       return "SEDANG"; // RINGAN
        }
    }
}
