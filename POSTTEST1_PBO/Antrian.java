public class Antrian {

    int nomor;
    Pasien pasien;

    Antrian(int nomor, Pasien pasien) {
        this.nomor = nomor;
        this.pasien = pasien;
    }

    void tampilkan() {
        System.out.println("Nomor Antrian : " + nomor);
        pasien.tampilkan();
        System.out.println("----------------------");
    }
}
