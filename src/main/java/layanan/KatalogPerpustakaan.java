package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {

    private List<Koleksi> koleksiList;

    public KatalogPerpustakaan() {
        this.koleksiList = new ArrayList<>();
    }

    public void tambahkanKoleksi(Koleksi koleksi) {
        koleksiList.add(koleksi);
    }

    public List<Koleksi> ambilSemuaKoleksi() {
        return koleksiList;
    }

    public Koleksi cariBerdasarkanKode(String kode) {
        for (int i = 0; i < koleksiList.size(); i++) {
            Koleksi k = koleksiList.get(i);
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

    public void tampilkanKatalog() {
        System.out.println("------------------------------------------------------------");
        for (Koleksi k : koleksiList) {
            System.out.println(k.deskripsi());
        }
    }

    public void urutkanKoleksi(Comparator<Koleksi> comparator) {
        koleksiList.sort(comparator);
    }

    public void lakukanPeminjaman(String kode) throws PustakaException {
        Koleksi k = cariBerdasarkanKode(kode);

        if (k == null) {
            throw new PustakaException("Kode " + kode + " tidak ditemukan.");
        } else if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(k.getJudul() + " sedang dipinjam orang lain.");
        } else if (!k.isLayakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul() + " tidak layak dipinjam: " + k.alasanTidakLayak());
        }

        k.setSedangDipinjam(true);
        System.out.println("[SUKSES] Meminjam: " + k.getJudul());
    }
}
