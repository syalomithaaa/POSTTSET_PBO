public class PasienDarurat extends Pasien {

    private String tingkatKegawatan; // Ringan, Sedang, Kritis
    private String petugasPengantar;

    public PasienDarurat(String nama, int umur, String keluhan, String tingkatKegawatan, String petugasPengantar) {
        super(nama, umur, keluhan);
        this.tingkatKegawatan = tingkatKegawatan;
        this.petugasPengantar = petugasPengantar;
    }

    public String getTingkatKegawatan() {
        return tingkatKegawatan;
    }

    public String getPetugasPengantar() {
        return petugasPengantar;
    }

    public void setTingkatKegawatan(String tingkatKegawatan) {
        this.tingkatKegawatan = tingkatKegawatan;
    }

    public void setPetugasPengantar(String petugasPengantar) {
        this.petugasPengantar = petugasPengantar;
    }

    @Override
    public String getTipePasien() {
        return "Darurat";
    }

    @Override
    public String getKeteranganTambahan() {
        return "Kegawatan: " + tingkatKegawatan + " | Pengantar: " + petugasPengantar;
    }
}
