package model;

public class BerkasDigital extends Koleksi {

    private final double ukuranMB;
    private final String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public String jenisKoleksi() {
        return "Berkas Digital";
    }

    @Override
    public boolean isLayakDipinjam() {
        return true; // Selalu layak
    }

    @Override
    public String keterangan() {
        return String.format("%.1f MB | %s", ukuranMB, tautanUnduh);
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Info: " + ukuranMB + " MB, Link: " + tautanUnduh;
    }
}
