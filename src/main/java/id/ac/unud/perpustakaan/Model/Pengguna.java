package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pengguna")
public class Pengguna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 
    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "nama_lengkap", nullable = false, length = 100)
    private String namaLengkap;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Peran peran;

    @Column(name = "program_studi", length = 100)
    private String programStudi;

    private Integer angkatan;

    @Column(name = "no_telepon", length = 20)
    private String noTelepon;

    @Column(length = 255)
    private String alamat;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private StatusAnggota status = StatusAnggota.AKTIF;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getNamaLengkap() { return namaLengkap; }
    public void setNamaLengkap(String namaLengkap) { this.namaLengkap = namaLengkap; }

    public Peran getPeran() { return peran; }
    public void setPeran(Peran peran) { this.peran = peran; }

    public String getProgramStudi() { return programStudi; }
    public void setProgramStudi(String programStudi) { this.programStudi = programStudi; }

    public Integer getAngkatan() { return angkatan; }
    public void setAngkatan(Integer angkatan) { this.angkatan = angkatan; }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public StatusAnggota getStatus() { return status; }
    public void setStatus(StatusAnggota status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}