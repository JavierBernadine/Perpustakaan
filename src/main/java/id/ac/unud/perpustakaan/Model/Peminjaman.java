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
    private long pengguna_id;
    private long buku_id;
    private String tanggal_pengajuan;
    private String tanggal_pinjam;
    private String tanggal_jatuh_tempo;
    private String tanggal_kembali;
    private StatusPeminjaman status;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getPengguna_id() {return pengguna_id;}

    public void setPengguna_id(long pengguna_id) {this.pengguna_id = pengguna_id;}

    public long getBuku_id() {return buku_id;}

    public void setBuku_id(long buku_id) {this.buku_id = buku_id;}

    public String getTanggal_pengajuan() {return tanggal_pengajuan;}

    public void setTanggal_pengajuan(String tanggal_pengajuan) {this.tanggal_pengajuan = tanggal_pengajuan;}

    public String getTanggal_pinjam() {return tanggal_pinjam;}

    public void setTanggal_pinjam(String tanggal_pinjam) {this.tanggal_pinjam = tanggal_pinjam;}

    public String getTanggal_jatuh_tempo() {return tanggal_jatuh_tempo;}

    public void setTanggal_jatuh_tempo(String tanggal_jatuh_tempo) {this.tanggal_jatuh_tempo = tanggal_jatuh_tempo;}

    public String getTanggal_kembali() {return tanggal_kembali;}

    public void setTanggal_kembali(String tanggal_kembali) {this.tanggal_kembali = tanggal_kembali;}

    public StatusPeminjaman getStatus() {return status;}

    public void setStatus(StatusPeminjaman status) {this.status = status;}
}
