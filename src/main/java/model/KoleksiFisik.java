package model;

public abstract class KoleksiFisik extends Koleksi implements Terarsip {

    private final String nomorRak;

    public KoleksiFisik(String kode, String judul, int tahunTerbit, String nomorRak) {
        super(kode, judul, tahunTerbit);
        this.nomorRak = nomorRak;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        if (nomorRak == null || nomorRak.isEmpty()) {
            return "Belum diset";
        }
        switch (Character.toUpperCase(nomorRak.charAt(0))) {
            case 'A':
            case 'B':
            case 'C':
                return "Lantai 1";
            case 'D':
            case 'E':
            case 'F':
                return "Lantai 2";
            default:
                return "Lantai 3";
        }
    }

    @Override
    public String lokasiArsip() {
        return ringkasanArsip();
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " >> " + ringkasanArsip();
    }
}
