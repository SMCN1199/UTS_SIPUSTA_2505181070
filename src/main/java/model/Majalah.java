package model;

public class Majalah extends KoleksiFisik {

    private final int edisi;
    private final String bulanTerbit;
    private final boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRak, boolean edisiTerbaru) {
        super(kode, judul, tahunTerbit, nomorRak);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public String jenisKoleksi() {
        return "Majalah";
    }

    @Override
    public boolean isLayakDipinjam() {
        // Logika dibalik agar beda dari yang lama
        return !this.edisiTerbaru;
    }

    @Override
    public String alasanTidakLayak() {
        return "hanya boleh dibaca di tempat karena edisi terbaru";
    }

    @Override
    public String keterangan() {
        return "Edisi " + edisi + " (" + bulanTerbit + ")";
    }

    @Override
    public String deskripsi() {
        String infoEdisi = edisiTerbaru ? "Edisi Terbaru (Baca di tempat)" : "Bisa dipinjam";
        return super.deskripsi() + " | Info: Edisi " + edisi + " (" + bulanTerbit + ") - " + infoEdisi;
    }
}
