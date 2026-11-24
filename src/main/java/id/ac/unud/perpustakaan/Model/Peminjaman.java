package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long penggunaId;
    private long bukuId;
    private String tanggalPengajuan;
    private String tanggalPinjam;
    private String tanggalJatuhTempo;
    private String tanggalKembali;
    private StatusPeminjaman status;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getPenggunaId() {return penggunaId;}

    public void setPenggunaId(long penggunaId) {this.penggunaId = penggunaId;}

    public long getBukuId() {return bukuId;}

    public void setBukuId(long bukuId) {this.bukuId = bukuId;}

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
