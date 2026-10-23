package layanan;

import model.Koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi a, Koleksi b) {
        // Logika if-else manual
        if (a.isLayakDipinjam() && !b.isLayakDipinjam()) {
            return -1;
        } else if (!a.isLayakDipinjam() && b.isLayakDipinjam()) {
            return 1;
        } else {
            return a.getJudul().compareToIgnoreCase(b.getJudul());
        }
    }
}
