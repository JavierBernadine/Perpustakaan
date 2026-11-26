package id.ac.unud.perpustakaan.Model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Denda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    @OneToOne(optional = false)
    @JoinColumn (name = "peminjaman_id", nullable = false, unique = true)
    private Peminjaman peminjaman;

    @Column (name = "hari_terlambat", nullable = false)
    private int hariTerlambat;

    @Column(nullable = false)
    private long nominal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private StatusDenda status = StatusDenda.BELUM;

    @Column (name = "tangga_bayar")
    private LocalDate tanggalBayar;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public int getHariTerlambat() {
        return hariTerlambat;
    }

    public void setHariTerlambat(int hariTerlambat) {
        this.hariTerlambat = hariTerlambat;}

    public long getNominal() {
        return nominal;
    }

    public StatusDenda getStatus() {
        return status;
    }

    public LocalDate getTanggalBayar() {
        return tanggalBayar;
    }

    public void setNominal(long nominal) {
        this.nominal = nominal;
    }

    public void setStatus(StatusDenda status) {
        this.status = status;}

    public void setTanggalBayar(LocalDate tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

}
