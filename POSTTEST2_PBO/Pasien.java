public class Pasien {

    private String nama;
    private int umur;
    private String keluhan;

    public Pasien(String nama, int umur, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        if (umur < 0) {
            System.out.println("Umur tidak valid");
        } else {
            this.umur = umur;
        }
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public void tampilkan() {
        System.out.println("Nama    : " + nama);
        System.out.println("Umur    : " + umur);
        System.out.println("Keluhan : " + keluhan);
    }
}
