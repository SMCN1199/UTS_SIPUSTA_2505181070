package layanan;

import model.Koleksi;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EksporKatalog {

    public static void cetakKeFile(List<Koleksi> daftar, String namaFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(namaFile))) {
            pw.println("KODE | JUDUL | JENIS | TAHUN | KETERANGAN");

            for (int i = 0; i < daftar.size(); i++) {
                Koleksi k = daftar.get(i);
                String baris = String.format("%s | %s | %s | %d | %s",
                        k.getKode(), k.getJudul(), k.jenisKoleksi(), k.getTahunTerbit(), k.keterangan());
                pw.println(baris);
            }
            System.out.println("Berhasil menyimpan ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Gagal ekspor: " + e.getMessage());
        }
    }
}
