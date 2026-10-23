package model;

public class BukuCetak extends KoleksiFisik {

    private final int jumlahHalaman;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit, nomorRak);
        this.jumlahHalaman = jumlahHalaman;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public String jenisKoleksi() {
        return "Buku Cetak";
    }

    @Override
    public boolean isLayakDipinjam() {
        return this.sedangDiperbaiki == false;
    }

    @Override
    public String alasanTidakLayak() {
        return "kondisi buku sedang dalam perbaikan";
    }

    @Override
    public String keterangan() {
        return String.format("%d hlm | %s", jumlahHalaman, (sedangDiperbaiki ? "Rusak" : "Bagus"));
    }

    @Override
    public String deskripsi() {
        String kondisi = sedangDiperbaiki ? "Sedang Diperbaiki" : "Siap Dipinjam";
        return super.deskripsi() + " | Info: " + jumlahHalaman + " halaman, Kondisi: " + kondisi;
    }
}
