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
    private String namaLengkap;
    private Peran peran;
    private String programStudi;
    private String angkatan;
    private String noTelepon;
    private String alamat;
    private StatusAnggota status;
    private String createdAt;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getNamaLengkap() {return namaLengkap;}

    public void setNamaLengkap(String namaLengkap) {this.namaLengkap = namaLengkap;}

    public Peran getPeran() {return peran;}

    public void setPeran(Peran peran) {this.peran = peran;}

    public String getProgramStudi() {return programStudi;}

    public void setProgramStudi(String programStudi) {this.programStudi = programStudi;}

    public String getAngkatan() {return angkatan;}

    public void setAngkatan(String angkatan) {this.angkatan = angkatan;}

    public String getNoTelepon() {return noTelepon;}

    public void setNoTelepon(String noTelepon) {this.noTelepon = noTelepon;}

    public String getAlamat() {return alamat;}

    public void setAlamat(String alamat) {this.alamat = alamat;}

    public StatusAnggota getStatus() {return status;}

    public void setStatus(StatusAnggota status) {this.status = status;}

    public String getCreatedAt() {return createdAt;}

    public void setCreatedAt(String createdAt) {this.createdAt = createdAt;}

    @PrePersist
    void saatDibuat() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now().toString();
        }
    }
}
