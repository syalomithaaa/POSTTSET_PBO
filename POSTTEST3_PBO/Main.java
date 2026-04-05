import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Antrian> daftarAntrian = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int nomorAntrian = 1;

    public static void main(String[] args) {

        int pilih;

        do {
            System.out.println("\n=== SISTEM ANTRIAN KLINIK CITRA MEDIKA ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Update Antrian");
            System.out.println("4. Hapus Antrian");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    tambah();
                    break;
                case 2:
                    lihat();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    hapus();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak ada!");
            }

        } while (pilih != 5);
    }

    static void tambah() {
        System.out.println("\n--- Pilih Tipe Pasien ---");
        System.out.println("1. Pasien Umum");
        System.out.println("2. Pasien Lansia");
        System.out.println("3. Pasien Darurat");
        System.out.print("Pilih tipe: ");
        int tipe = input.nextInt();
        input.nextLine();

        System.out.print("Nama pasien : ");
        String nama = input.nextLine();

        System.out.print("Umur        : ");
        int umur = input.nextInt();
        input.nextLine();

        System.out.print("Keluhan     : ");
        String keluhan = input.nextLine();

        Pasien pasien = null;

        switch (tipe) {
            case 1:
                System.out.print("Nomor BPJS (kosongkan jika tidak ada): ");
                String bpjs = input.nextLine();
                pasien = new PasienUmum(nama, umur, keluhan, bpjs);
                break;

            case 2:
                if (umur < 60) {
                    System.out.println("Peringatan: Pasien lansia umumnya berusia 60 tahun ke atas.");
                }
                System.out.print("Nama wali         : ");
                String wali = input.nextLine();
                System.out.print("Riwayat penyakit  : ");
                String riwayat = input.nextLine();
                pasien = new PasienLansia(nama, umur, keluhan, wali, riwayat);
                break;

            case 3:
                System.out.println("Tingkat kegawatan: 1. Ringan  2. Sedang  3. Kritis");
                System.out.print("Pilih: ");
                int kegawatanPilih = input.nextInt();
                input.nextLine();
                String kegawatan;
                switch (kegawatanPilih) {
                    case 1: kegawatan = "Ringan"; break;
                    case 2: kegawatan = "Sedang"; break;
                    case 3: kegawatan = "Kritis"; break;
                    default: kegawatan = "Tidak Diketahui";
                }
                System.out.print("Nama petugas pengantar: ");
                String pengantar = input.nextLine();
                pasien = new PasienDarurat(nama, umur, keluhan, kegawatan, pengantar);
                break;

            default:
                System.out.println("Tipe tidak valid, pasien tidak ditambahkan.");
                return;
        }

        Antrian antrian = new Antrian(nomorAntrian++, pasien);
        daftarAntrian.add(antrian);
        System.out.println("Pasien berhasil masuk antrian nomor " + (nomorAntrian - 1) + "!");
    }

    static void lihat() {
        if (daftarAntrian.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }

        System.out.println("\n===== DAFTAR ANTRIAN =====");
        for (Antrian a : daftarAntrian) {
            a.tampilkan();
        }
    }

    static void update() {
        lihat();
        if (daftarAntrian.isEmpty()) return;

        System.out.print("Masukkan nomor antrian yang ingin diupdate: ");
        int nomor = input.nextInt();
        input.nextLine();

        for (Antrian a : daftarAntrian) {
            if (a.getNomor() == nomor) {
                Pasien p = a.getPasien();

                System.out.print("Nama baru    : ");
                String nama = input.nextLine();

                System.out.print("Umur baru    : ");
                int umur = input.nextInt();
                input.nextLine();

                System.out.print("Keluhan baru : ");
                String keluhan = input.nextLine();

                p.setNama(nama);
                p.setUmur(umur);
                p.setKeluhan(keluhan);

                // Update data spesifik per tipe pasien
                if (p instanceof PasienUmum) {
                    PasienUmum pu = (PasienUmum) p;
                    System.out.print("Nomor BPJS baru: ");
                    String bpjs = input.nextLine();
                    pu.setNomorBPJS(bpjs);

                } else if (p instanceof PasienLansia) {
                    PasienLansia pl = (PasienLansia) p;
                    System.out.print("Nama wali baru        : ");
                    String wali = input.nextLine();
                    System.out.print("Riwayat penyakit baru : ");
                    String riwayat = input.nextLine();
                    pl.setNamaWali(wali);
                    pl.setRiwayatPenyakit(riwayat);

                } else if (p instanceof PasienDarurat) {
                    PasienDarurat pd = (PasienDarurat) p;
                    System.out.println("Tingkat kegawatan: 1. Ringan  2. Sedang  3. Kritis");
                    System.out.print("Pilih: ");
                    int k = input.nextInt();
                    input.nextLine();
                    String kegawatan;
                    switch (k) {
                        case 1: kegawatan = "Ringan"; break;
                        case 2: kegawatan = "Sedang"; break;
                        case 3: kegawatan = "Kritis"; break;
                        default: kegawatan = "Tidak Diketahui";
                    }
                    System.out.print("Nama petugas pengantar baru: ");
                    String pengantar = input.nextLine();
                    pd.setTingkatKegawatan(kegawatan);
                    pd.setPetugasPengantar(pengantar);
                }

                System.out.println("Data berhasil diupdate!");
                return;
            }
        }

        System.out.println("Nomor antrian tidak ditemukan.");
    }

    static void hapus() {
        lihat();
        if (daftarAntrian.isEmpty()) return;

        System.out.print("Masukkan nomor antrian yang ingin dihapus: ");
        int nomor = input.nextInt();

        for (int i = 0; i < daftarAntrian.size(); i++) {
            if (daftarAntrian.get(i).getNomor() == nomor) {
                daftarAntrian.remove(i);
                System.out.println("Antrian berhasil dihapus!");
                return;
            }
        }

        System.out.println("Nomor antrian tidak ditemukan.");
    }
}
