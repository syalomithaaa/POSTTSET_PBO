import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Antrian antrian = new Antrian();

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   SISTEM ANTRIAN KLINIK CITRA MEDIKA  ║");
        System.out.println("╚══════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Update Antrian");
            System.out.println("4. Hapus Antrian");
            System.out.println("5. Ringkasan Biaya Pasien");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1: menuTambah(); break;
                case 2: menuLihat(); break;
                case 3: menuUpdate(); break;
                case 4: menuHapus(); break;
                case 5: antrian.tampilRingkasanBiaya(); break;
                case 6:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    running = false;
                    break;
                default:
                    System.out.println("✘ Pilihan tidak valid.");
            }
        }
    }

    static void menuTambah() {
        System.out.println("\n--- Tambah Antrian ---");
        System.out.println("Tipe Pasien:");
        System.out.println("1. Pasien Umum");
        System.out.println("2. Pasien Lansia");
        System.out.println("3. Pasien Darurat");
        System.out.print("Pilih tipe: ");
        int tipe = sc.nextInt();
        sc.nextLine();

        System.out.print("Nama pasien  : ");
        String nama = sc.nextLine();
        System.out.print("Umur         : ");
        int umur = sc.nextInt();
        sc.nextLine();
        System.out.print("Keluhan      : ");
        String keluhan = sc.nextLine();

        switch (tipe) {
            case 1:
                System.out.print("Nomor BPJS   : ");
                String bpjs = sc.nextLine();
                antrian.tambahAntrian(new PasienUmum(nama, umur, keluhan, bpjs));
                break;
            case 2:
                System.out.print("Nama wali      : ");
                String wali = sc.nextLine();
                System.out.print("Riwayat penyakit: ");
                String riwayat = sc.nextLine();
                antrian.tambahAntrian(new PasienLansia(nama, umur, keluhan, wali, riwayat));
                break;
            case 3:
                System.out.print("Tingkat kegawatan (RINGAN/SEDANG/KRITIS): ");
                String kegawatan = sc.nextLine();
                System.out.print("Petugas pengantar: ");
                String petugas = sc.nextLine();
                antrian.tambahAntrian(new PasienDarurat(nama, umur, keluhan, kegawatan, petugas));
                break;
            default:
                System.out.println("✘ Tipe tidak valid.");
        }
    }

    static void menuLihat() {
        System.out.println("\n--- Lihat Antrian ---");
        System.out.println("1. Tampil lengkap");
        System.out.println("2. Tampil dengan label");
        System.out.print("Pilih: ");
        int opt = sc.nextInt();
        sc.nextLine();
        if (opt == 2) {
            System.out.print("Masukkan label: ");
            String label = sc.nextLine();
            antrian.lihatAntrian(label);
        } else {
            antrian.lihatAntrian();
        }
    }

    static void menuUpdate() {
        antrian.lihatAntrian();
        System.out.print("\nMasukkan nomor antrian yang diupdate (mulai dari 1): ");
        int no = sc.nextInt() - 1;
        sc.nextLine();
        System.out.print("Keluhan baru: ");
        String keluhan = sc.nextLine();
        antrian.updateAntrian(no, keluhan);
    }

    static void menuHapus() {
        antrian.lihatAntrian();
        System.out.print("\nMasukkan nomor antrian yang dihapus (mulai dari 1): ");
        int no = sc.nextInt() - 1;
        sc.nextLine();
        antrian.hapusAntrian(no);
    }
}
