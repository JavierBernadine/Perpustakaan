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
    private long peminjaman_id;
    private String hari_terlambat;
    private double nominal;
    private StatusDenda status;
    private String tanggal_bayar;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getPeminjaman_id() {return peminjaman_id;}

    public void setPeminjaman_id(long peminjaman_id) {this.peminjaman_id = peminjaman_id;}

    public String getHari_terlambat() {return hari_terlambat;}

    public void setHari_terlambat(String hari_terlambat) {this.hari_terlambat = hari_terlambat;}

    public double getNominal() {return nominal;}

    public void setNominal(double nominal) {this.nominal = nominal;}

    public StatusDenda getStatus() {return status;}

    public void setStatus(StatusDenda status) {this.status = status;}

    public String getTanggal_bayar() {return tanggal_bayar;}

    public void setTanggal_bayar(String tanggal_bayar) {this.tanggal_bayar = tanggal_bayar;}
}
