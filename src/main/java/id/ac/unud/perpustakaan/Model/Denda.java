package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Denda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long peminjamanId;
    private String hariTerlambat;
    private double nominal;
    private StatusDenda status;
    private String tanggalBayar;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getPeminjamanId() {return peminjamanId;}

    public void setPeminjamanId(long peminjamanId) {this.peminjamanId = peminjamanId;}

    public String getHariTerlambat() {return hariTerlambat;}

    public void setHariTerlambat(String hariTerlambat) {this.hariTerlambat = hariTerlambat;}

    public double getNominal() {return nominal;}

    public void setNominal(double nominal) {this.nominal = nominal;}

    public StatusDenda getStatus() {return status;}

    public void setStatus(StatusDenda status) {this.status = status;}

    public String getTanggalBayar() {return tanggalBayar;}

    public void setTanggalBayar(String tanggalBayar) {this.tanggalBayar = tanggalBayar;}
}
