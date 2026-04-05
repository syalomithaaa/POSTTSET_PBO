# Sistem Antrian Klinik Citra Medika

## Deskripsi
Program ini merupakan sistem untuk mengelola antrian pasien di Klinik Citra Medika menggunakan bahasa Java dengan konsep Object Oriented Programming (OOP).

## Fitur Program
1. Tambah Antrian (Create) — dengan pilihan tipe pasien
2. Lihat Antrian (Read)
3. Update Antrian (Update) — menyesuaikan tipe pasien
4. Hapus Antrian (Delete)

## Konsep yang Digunakan

### Posttest 2 (sebelumnya)
- Encapsulation
- Access Modifier (private dan public)
- Getter dan Setter

### Posttest 3 (saat ini) — Inheritance
- **Single Inheritance**: setiap subclass mewarisi langsung dari `Pasien`
- **Superclass**: `Pasien` — menyimpan atribut umum (nama, umur, keluhan)
- **3 Subclass/Childclass**:
  - `PasienUmum` → mewarisi `Pasien`, tambahan: `nomorBPJS`
  - `PasienLansia` → mewarisi `Pasien`, tambahan: `namaWali`, `riwayatPenyakit`
  - `PasienDarurat` → mewarisi `Pasien`, tambahan: `tingkatKegawatan`, `petugasPengantar`
- **Method Override**: `getTipePasien()` dan `getKeteranganTambahan()` di-override tiap subclass
- **Polymorphism**: `Antrian` menerima objek `Pasien` apapun (bisa Umum/Lansia/Darurat)
- **instanceof**: digunakan di `update()` untuk mengenali tipe pasien saat runtime

## Struktur Inheritance

```
Pasien (superclass)
├── PasienUmum    (subclass 1)
├── PasienLansia  (subclass 2)
└── PasienDarurat (subclass 3)
```

## Cara Menjalankan

Compile:
```
javac Pasien.java PasienUmum.java PasienLansia.java PasienDarurat.java Antrian.java Main.java
```

Run:
```
java Main
```

## Author
Nama : (Isi Nama)
NIM  : (Isi NIM)
