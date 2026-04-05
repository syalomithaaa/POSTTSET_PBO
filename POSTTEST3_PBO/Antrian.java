public class Antrian {

    private int nomor;
    private Pasien pasien;

    public Antrian(int nomor, Pasien pasien) {
        this.nomor = nomor;
        this.pasien = pasien;
    }

    public int getNomor() {
        return nomor;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void tampilkan() {
        System.out.println("Nomor Antrian : " + nomor);
        pasien.tampilkan();
        System.out.println("----------------------");
    }
}
