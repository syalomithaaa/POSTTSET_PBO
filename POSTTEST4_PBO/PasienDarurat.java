public class PasienDarurat extends Pasien {
    private String tingkatKegawatan; // RINGAN / SEDANG / KRITIS
    private String petugasPengantar;

    public PasienDarurat(String nama, int umur, String keluhan, String tingkatKegawatan, String petugasPengantar) {
        super(nama, umur, keluhan);
        this.tingkatKegawatan = tingkatKegawatan;
        this.petugasPengantar = petugasPengantar;
    }

    public String getTingkatKegawatan()           { return tingkatKegawatan; }
    public void   setTingkatKegawatan(String t)   { this.tingkatKegawatan = t; }
    public String getPetugasPengantar()           { return petugasPengantar; }
    public void   setPetugasPengantar(String p)   { this.petugasPengantar = p; }

    // =============================================
    // POLYMORPHISM - METHOD OVERRIDE (Posttest 3 & 4)
    // =============================================

    @Override
    public String getTipePasien() {
        return "Pasien Darurat";
    }

    @Override
    public String getKeteranganTambahan() {
        return "Kegawatan: " + tingkatKegawatan + " | Pengantar: " + petugasPengantar;
    }

    // Override hitungBiaya() #1 - ada biaya tambahan penanganan darurat
    @Override
    public double hitungBiaya() {
        double biayaTambahan;
        switch (tingkatKegawatan.toUpperCase()) {
            case "KRITIS":  biayaTambahan = 200000; break;
            case "SEDANG":  biayaTambahan = 100000; break;
            default:        biayaTambahan = 50000;  break; // RINGAN
        }
        return super.hitungBiaya() + biayaTambahan;
    }

    // Override hitungBiaya() #2 - biaya darurat + obat
    @Override
    public double hitungBiaya(int jumlahObat) {
        return hitungBiaya() + (jumlahObat * 15000);
    }
}
