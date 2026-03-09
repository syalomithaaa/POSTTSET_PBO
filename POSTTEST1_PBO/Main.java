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
        System.out.print("Nama pasien : ");
        String nama = input.nextLine();

        System.out.print("Umur : ");
        int umur = input.nextInt();
        input.nextLine();

        System.out.print("Keluhan : ");
        String keluhan = input.nextLine();

        Pasien pasien = new Pasien(nama, umur, keluhan);
        Antrian antrian = new Antrian(nomorAntrian++, pasien);

        daftarAntrian.add(antrian);

        System.out.println("Pasien berhasil masuk antrian!");
    }

    static void lihat() {
        if (daftarAntrian.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }

        for (Antrian a : daftarAntrian) {
            a.tampilkan();
        }
    }

    static void update() {
        lihat();

        System.out.print("Masukkan nomor antrian yang ingin diupdate: ");
        int nomor = input.nextInt();
        input.nextLine();

        for (Antrian a : daftarAntrian) {
            if (a.nomor == nomor) {

                System.out.print("Nama baru : ");
                a.pasien.nama = input.nextLine();

                System.out.print("Umur baru : ");
                a.pasien.umur = input.nextInt();
                input.nextLine();

                System.out.print("Keluhan baru : ");
                a.pasien.keluhan = input.nextLine();

                System.out.println("Data berhasil diupdate!");
                return;
            }
        }

        System.out.println("Nomor antrian tidak ditemukan.");
    }

    static void hapus() {
        lihat();

        System.out.print("Masukkan nomor antrian yang ingin dihapus: ");
        int nomor = input.nextInt();

        for (int i = 0; i < daftarAntrian.size(); i++) {
            if (daftarAntrian.get(i).nomor == nomor) {
                daftarAntrian.remove(i);
                System.out.println("Antrian berhasil dihapus!");
                return;
            }
        }

        System.out.println("Nomor antrian tidak ditemukan.");
    }
}
