package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "peminjaman")
public class Peminjaman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pengguna_id", nullable = false)
    private Pengguna anggota;

    @ManyToOne(optional = false)
    @JoinColumn(name = "buku_id", nullable = false)
    private Buku buku;

    @Column(name = "tanggal_pengajuan", nullable = false)
    private LocalDate tanggalPengajuan;

    @Column(name = "tanggal_pinjam")
    private LocalDate tanggalPinjam;

    @Column(name = "tanggal_jatuh_tempo")
    private LocalDate tanggalJatuhTempo;

    @Column(name = "tanggal_kembali")
    private LocalDate tanggalKembali;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private StatusPeminjaman status = StatusPeminjaman.DIAJUKAN;

    /** Bernilai true bila buku masih dipinjam dan sudah melewati jatuh tempo. */
    public boolean isTerlambat() {
        return status == StatusPeminjaman.DIPINJAM
                && tanggalJatuhTempo != null
                && LocalDate.now().isAfter(tanggalJatuhTempo);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Pengguna getAnggota() { return anggota; }
    public void setAnggota(Pengguna anggota) { this.anggota = anggota; }

    public Buku getBuku() { return buku; }
    public void setBuku(Buku buku) { this.buku = buku; }

    public LocalDate getTanggalPengajuan() { return tanggalPengajuan; }
    public void setTanggalPengajuan(LocalDate tanggalPengajuan) { this.tanggalPengajuan = tanggalPengajuan; }

    public LocalDate getTanggalPinjam() { return tanggalPinjam; }
    public void setTanggalPinjam(LocalDate tanggalPinjam) { this.tanggalPinjam = tanggalPinjam; }

    public LocalDate getTanggalJatuhTempo() { return tanggalJatuhTempo; }
    public void setTanggalJatuhTempo(LocalDate tanggalJatuhTempo) { this.tanggalJatuhTempo = tanggalJatuhTempo; }

    public LocalDate getTanggalKembali() { return tanggalKembali; }
    public void setTanggalKembali(LocalDate tanggalKembali) { this.tanggalKembali = tanggalKembali; }

    public StatusPeminjaman getStatus() { return status; }
    public void setStatus(StatusPeminjaman status) { this.status = status; }
}