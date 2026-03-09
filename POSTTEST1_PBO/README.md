
# 🏥 SISTEM ANTRIAN PASIEN - Klinik Citra Medika

## 📚 Deskripsi Proyek

Sistem Antrian Klinik Citra Medika adalah program sederhana berbasis Java yang digunakan untuk membantu mengelola antrian pasien di sebuah klinik. 
Program ini memungkinkan petugas klinik untuk menambahkan pasien ke dalam antrian, melihat daftar antrian, mengubah data pasien, serta menghapus pasien dari antrian.

Program ini dibuat untuk memenuhi tugas **Posttest 1 Pemrograman Berorientasi Objek (PBO)**.

---

## 🎯 Tujuan Proyek

1. Menyelesaikan tugas praktikum Posttest 1 PBO
2. Menerapkan konsep Object-Oriented Programming (OOP) pada Java
3. Mengimplementasikan operasi CRUD (Create, Read, Update, Delete)
4. Menggunakan ArrayList sebagai penyimpanan data dinamis
5. Memahami penggunaan class dan object

---

## ⚙️ Fitur Program

### 🧾 Menu Antrian Pasien

- ➕ Menambahkan pasien baru ke dalam antrian
- 📋 Melihat seluruh daftar antrian pasien
- ✏️ Mengubah data pasien dalam antrian
- 🗑️ Menghapus pasien dari daftar antrian

---

## 🏗️ Struktur Class

Program ini menggunakan beberapa class utama.

### Class Pasien

- nama : String
- umur : int
- keluhan : String

Method:
- tampilkan()

Class ini digunakan untuk menyimpan informasi pasien yang datang ke klinik.

---

### Class Antrian

- nomor : int
- pasien : Pasien

Method:
- tampilkan()

Class ini digunakan untuk menyimpan nomor antrian serta data pasien yang terkait.

---

### Class Main

Class ini berfungsi sebagai program utama yang berisi:

- Menu program
- Proses input data
- Operasi CRUD pada ArrayList

---

## 📖 Cara Menggunakan Program

### Alur Program

START  
↓  
MENU UTAMA  
1. Tambah Antrian  
2. Lihat Antrian  
3. Update Antrian  
4. Hapus Antrian  
5. Exit  
↓  
Program menjalankan proses sesuai pilihan user

---

### Contoh Input Pasien

Nama Pasien : Andi  
Umur : 25  
Keluhan : Demam

Output:
Pasien berhasil masuk ke dalam antrian.

---

## 🧠 Konsep OOP yang Digunakan

✔ Class & Object  
Digunakan untuk membuat struktur data seperti Pasien dan Antrian.

✔ Constructor  
Digunakan untuk memberikan nilai awal saat objek dibuat.

✔ ArrayList  
Digunakan untuk menyimpan data antrian secara dinamis.

✔ Looping  
Digunakan untuk menampilkan daftar antrian pasien.

✔ Conditional (If / Switch)  
Digunakan untuk mengatur pilihan menu program.

✔ CRUD Operations  
Create, Read, Update, Delete data pasien.

---

## 🖥️ Contoh Tampilan Program

==============================
SISTEM ANTRIAN KLINIK
CITRA MEDIKA
==============================
1. Tambah Antrian
2. Lihat Antrian
3. Update Antrian
4. Hapus Antrian
5. Exit

Pilih Menu:

---

## 📌 Kesimpulan

Program Sistem Antrian Klinik Citra Medika berhasil dibuat menggunakan konsep dasar Object-Oriented Programming (OOP).

Program ini mampu:
- Menyimpan data pasien dalam antrian
- Mengelola data menggunakan operasi CRUD
- Menggunakan ArrayList sebagai penyimpanan data
- Menjalankan program dengan menu interaktif

---

## 👨‍💻 Author

Nama : (Isi Nama Kamu)  
NIM  : (Isi NIM Kamu)
