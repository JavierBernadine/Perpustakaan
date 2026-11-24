package id.ac.unud.perpustakaan.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String judul;
    private String penulis;
    private String penerbit;
    private String tahunTerbit;
    private String kategori;
    private String sinopsis;
    private int stok;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getJudul() {return judul;}

    public void setJudul(String judul) {this.judul = judul;}

    public String getPenulis() {return penulis;}

    public void setPenulis(String penulis) {this.penulis = penulis;}

    public String getPenerbit() {return penerbit;}

    public void setPenerbit(String penerbit) {this.penerbit = penerbit;}

    public String getTahunTerbit() {return tahunTerbit;}

    public void setTahunTerbit(String tahunTerbit) {this.tahunTerbit = tahunTerbit;}

    public String getKategori() {return kategori;}

    public void setKategori(String kategori) {this.kategori = kategori;}

    public String getSinopsis() {return sinopsis;}

    public void setSinopsis(String sinopsis) {this.sinopsis = sinopsis;}

    public int getStok() {return stok;}

    public void setStok(int stok) {this.stok = stok;}
}
