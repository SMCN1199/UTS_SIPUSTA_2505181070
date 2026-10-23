package com.mycompany.uts_sipusta_2505181070;

import eksepsi.PustakaException;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Koleksi;
import model.Majalah;
import java.util.Comparator;

public class UTS_SIPUSTA_2505181070 {

    public static void main(String[] args) {
        KatalogPerpustakaan perpustakaan = new KatalogPerpustakaan();

        muatDataUji(perpustakaan);
        jalankanSimulasi(perpustakaan);
    }

    // Method khusus untuk mengisi data uji
    private static void muatDataUji(KatalogPerpustakaan p) {
        p.tambahkanKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        p.tambahkanKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        p.tambahkanKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "A-05", true));
        p.tambahkanKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "A-06", false));
        p.tambahkanKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        p.tambahkanKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));
    }

    // Method utama untuk menjalankan semua instruksi
    private static void jalankanSimulasi(KatalogPerpustakaan p) {
        System.out.println(" FASE 1: KATALOG AWAL ");
        p.tampilkanKatalog();
        
        System.out.println("\n FASE 2: KATALOG URUT JUDUL ");
        p.urutkanKoleksi(Comparator.comparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER));
        p.tampilkanKatalog();

        System.out.println("\n FASE 3: KATALOG LAYAK DIPINJAM DULU ");
        p.urutkanKoleksi(new UrutLayakLaluJudul());
        p.tampilkanKatalog();

        System.out.println("\n FASE 4: PROSES PEMINJAMAN ");
        prosesPeminjaman(p, "BK-001");
        prosesPeminjaman(p, "BK-001");
        prosesPeminjaman(p, "BK-002");
        prosesPeminjaman(p, "MJ-001");
        prosesPeminjaman(p, "MJ-002");
        prosesPeminjaman(p, "XX-999");

        System.out.println("\n FASE 5: EKSPOR FILE ");
        EksporKatalog.cetakKeFile(p.ambilSemuaKoleksi(), "katalog.txt");
    }

    private static void prosesPeminjaman(KatalogPerpustakaan p, String kode) {
        try {
            p.lakukanPeminjaman(kode);
        } catch (PustakaException e) {
            System.out.println("[GAGAL] " + e.getMessage());
        }
    }
}
