public class Pasien {

    String nama;
    int umur;
    String keluhan;

    Pasien(String nama, int umur, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
    }

    void tampilkan() {
        System.out.println("Nama    : " + nama);
        System.out.println("Umur    : " + umur);
        System.out.println("Keluhan : " + keluhan);
    }
}
