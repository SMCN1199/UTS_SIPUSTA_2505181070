package model;

public abstract class Koleksi {

    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean status) {
        this.sedangDipinjam = status;
    }

    public abstract boolean isLayakDipinjam();

    public abstract String jenisKoleksi();

    public String alasanTidakLayak() {
        return "persyaratan peminjaman belum terpenuhi";
    }

    public String lokasiArsip() {
        return "Akses Digital (Tanpa Rak)"; // Ubah teks sedikit
    }

    public String keterangan() {
        return "-";
    }

    public String deskripsi() {
        String status = isLayakDipinjam() ? "Layak" : "Tidak Layak";
        return kode + " [" + jenisKoleksi() + "] \"" + judul + "\" (" + tahunTerbit + ") - " + status;
    }
}
