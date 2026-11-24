package id.ac.unud.perpustakaan.Config;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
 
@Component
public class AturanPerpustakaan {
 
    private final int masaPinjamHari;
    private final long tarifDendaPerHari;
    private final int maksPinjamanAktif;
 
    public AturanPerpustakaan(
            @Value("${perpus.masa-pinjam-hari:7}") int masaPinjamHari,
            @Value("${perpus.tarif-denda-per-hari:5000}") long tarifDendaPerHari,
            @Value("${perpus.maks-pinjaman-aktif:3}") int maksPinjamanAktif) {
        this.masaPinjamHari = masaPinjamHari;
        this.tarifDendaPerHari = tarifDendaPerHari;
        this.maksPinjamanAktif = maksPinjamanAktif;
    }
 
    /** Jumlah hari keterlambatan; 0 jika dikembalikan tepat waktu atau lebih awal. */
    public int hariTerlambat(LocalDate jatuhTempo, LocalDate tanggalKembali) {
        long selisih = ChronoUnit.DAYS.between(jatuhTempo, tanggalKembali);
        return (int) Math.max(0, selisih);
    }
 
    /** Denda = hari terlambat x tarif per hari (satu peminjaman = satu buku). */
    public long hitungDenda(int hariTerlambat) {
        return hariTerlambat * tarifDendaPerHari;
    }
 
    public int getMasaPinjamHari() { return masaPinjamHari; 

    }
    public long getTarifDendaPerHari() { return tarifDendaPerHari; 

    }
    public int getMaksPinjamanAktif() { return maksPinjamanAktif; 
        
    }
}

