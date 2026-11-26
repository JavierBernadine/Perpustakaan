package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String nama_lengkap;
    private Peran peran;
    private String program_studi;
    private String angkatan;
    private String no_telepon;
    private String alamat;
    private StatusAnggota status;
    private String created_at;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getNamaLengkap() {return nama_lengkap;}

    public void setNamaLengkap(String namaLengkap) {this.nama_lengkap = namaLengkap;}

    public Peran getPeran() {return peran;}

    public void setPeran(Peran peran) {this.peran = peran;}

    public String getProgramStudi() {return program_studi;}

    public void setProgramStudi(String programStudi) {this.program_studi = programStudi;}

    public String getAngkatan() {return angkatan;}

    public void setAngkatan(String angkatan) {this.angkatan = angkatan;}

    public String getNo_telepon() {return no_telepon;}

    public void setNo_telepon(String no_telepon) {this.no_telepon = no_telepon;}

    public String getAlamat() {return alamat;}

    public void setAlamat(String alamat) {this.alamat = alamat;}

    public StatusAnggota getStatus() {return status;}

    public void setStatus(StatusAnggota status) {this.status = status;}

    public String getCreated_at() {return created_at;}

    public void setCreated_at(String created_at) {this.created_at = created_at;}

    @PrePersist
    void saatDibuat() {
        if (created_at == null) {
            created_at = LocalDateTime.now().toString();
        }
    }
}
