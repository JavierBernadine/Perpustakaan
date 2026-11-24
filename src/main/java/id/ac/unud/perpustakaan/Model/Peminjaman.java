package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long penggunaId;
    private Long bukuId;
    private String tanggalPengajuan;
    private String tanggalPinjam;
    private String tanggalJatuhTempo;
    private String tanggalKembali;
    private StatusPeminjaman status;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getPenggunaId() {return penggunaId;}

    public void setPenggunaId(Long penggunaId) {this.penggunaId = penggunaId;}

    public Long getBukuId() {return bukuId;}

    public void setBukuId(Long bukuId) {this.bukuId = bukuId;}

    public String getTanggalPengajuan() {return tanggalPengajuan;}

    public void setTanggalPengajuan(String tanggalPengajuan) {this.tanggalPengajuan = tanggalPengajuan;}

    public String getTanggalPinjam() {return tanggalPinjam;}

    public void setTanggalPinjam(String tanggalPinjam) {this.tanggalPinjam = tanggalPinjam;}

    public String getTanggalJatuhTempo() {return tanggalJatuhTempo;}

    public void setTanggalJatuhTempo(String tanggalJatuhTempo) {this.tanggalJatuhTempo = tanggalJatuhTempo;}

    public String getTanggalKembali() {return tanggalKembali;}

    public void setTanggalKembali(String tanggalKembali) {this.tanggalKembali = tanggalKembali;}

    public StatusPeminjaman getStatus() {return status;}

    public void setStatus(StatusPeminjaman status) {this.status = status;}
}
