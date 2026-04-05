public class PasienUmum extends Pasien {

    private String nomorBPJS;

    public PasienUmum(String nama, int umur, String keluhan, String nomorBPJS) {
        super(nama, umur, keluhan);
        this.nomorBPJS = nomorBPJS;
    }

    public String getNomorBPJS() {
        return nomorBPJS;
    }

    public void setNomorBPJS(String nomorBPJS) {
        this.nomorBPJS = nomorBPJS;
    }

    @Override
    public String getTipePasien() {
        return "Umum";
    }

    @Override
    public String getKeteranganTambahan() {
        return "No. BPJS: " + (nomorBPJS.isEmpty() ? "Tidak Ada (Umum)" : nomorBPJS);
    }
}
