/**
 * Interface IPasienInfo
 * Mendefinisikan kontrak informasi dan validasi untuk semua tipe pasien.
 * Minimal memiliki 2 method sesuai instruksi Posttest 5.
 */
public interface IPasienInfo {

    /**
     * Mengembalikan ringkasan singkat informasi pasien dalam satu baris.
     * Contoh: "Budi | 45 thn | Pasien Umum | BPJS: 001234"
     */
    String getRingkasanInfo();

    /**
     * Memvalidasi apakah data pasien sudah lengkap dan valid.
     * Contoh: cek nomor BPJS tidak kosong, tingkat kegawatan valid, dsb.
     * @return true jika data valid, false jika ada data yang tidak valid/kosong.
     */
    boolean isDataValid();

    /**
     * Mengembalikan kategori prioritas antrian pasien.
     * TINGGI = Darurat/Kritis, SEDANG = Lansia/Umum, RENDAH = default
     */
    String getPrioritas();
}
