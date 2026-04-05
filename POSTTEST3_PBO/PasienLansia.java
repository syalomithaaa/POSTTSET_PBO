public class PasienLansia extends Pasien {

    private String namaWali;
    private String riwayatPenyakit;

    public PasienLansia(String nama, int umur, String keluhan, String namaWali, String riwayatPenyakit) {
        super(nama, umur, keluhan);
        this.namaWali = namaWali;
        this.riwayatPenyakit = riwayatPenyakit;
    }

    public String getNamaWali() {
        return namaWali;
    }

    public String getRiwayatPenyakit() {
        return riwayatPenyakit;
    }

    public void setNamaWali(String namaWali) {
        this.namaWali = namaWali;
    }

    public void setRiwayatPenyakit(String riwayatPenyakit) {
        this.riwayatPenyakit = riwayatPenyakit;
    }

    @Override
    public String getTipePasien() {
        return "Lansia";
    }

    @Override
    public String getKeteranganTambahan() {
        return "Wali: " + namaWali + " | Riwayat: " + riwayatPenyakit;
    }
}
