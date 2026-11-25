package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "buku")
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Kode buku wajib diisi")
    @Size(max = 20, message = "Kode buku maksimal 20 karakter")
    @Column(name = "kode_buku", nullable = false, unique = true, length = 20)
    private String kodeBuku;

    @NotBlank(message = "Judul wajib diisi")
    @Size(max = 200, message = "Judul maksimal 200 karakter")
    @Column(nullable = false, length = 200)
    private String judul;

    @NotBlank(message = "Penulis wajib diisi")
    @Size(max = 100, message = "Penulis maksimal 100 karakter")
    @Column(nullable = false, length = 100)
    private String penulis;

    @Size(max = 100, message = "Penerbit maksimal 100 karakter")
    @Column(length = 100)
    private String penerbit;

    @Min(value = 1000, message = "Tahun terbit tidak valid")
    @Max(value = 2100, message = "Tahun terbit tidak valid")
    @Column(name = "tahun_terbit")
    private Integer tahunTerbit;

    @NotBlank(message = "Kategori wajib diisi")
    @Size(max = 50, message = "Kategori maksimal 50 karakter")
    @Column(nullable = false, length = 50)
    private String kategori;

    @Size(max = 2000, message = "Sinopsis maksimal 2000 karakter")
    @Column(length = 2000)
    private String sinopsis;

    @NotNull(message = "Stok wajib diisi")
    @Min(value = 0, message = "Stok tidak boleh negatif")
    @Column(nullable = false)
    private Integer stok;


    @Size(max = 255, message = "URL sampul maksimal 255 karakter")
    private String sampul;

    public Long getId() { 
        return id;
     }
    
    
    public String getKodeBuku() {
         return kodeBuku; 
        }
    

    public String getJudul() {
         return judul; 
        }
  

    public String getPenulis() {
         return penulis; }

    public String getPenerbit() { 
        return penerbit;  }
    

    public Integer getTahunTerbit() {
         return tahunTerbit;
         }
    

    public String getKategori() {
         return kategori; 
        }
    

    public String getSinopsis() {
         return sinopsis; 
        }
    


    public Integer getStok() {
         return stok;

     }
   

    public String getSampul() {
         return sampul; 
        }
    

    public void setId(Long id) { 
        this.id = id; }

    public void setKodeBuku(String kodeBuku) { 
        this.kodeBuku = kodeBuku; }

    public void setJudul(String judul) {
         this.judul = judul; }

    public void setPenulis(String penulis) { 
        this.penulis = penulis; }

    public void setPenerbit(String penerbit) { 
        this.penerbit = penerbit; }

    public void setTahunTerbit(Integer tahunTerbit) {
         this.tahunTerbit = tahunTerbit; }

    public void setKategori(String kategori) { 
        this.kategori = kategori; }

    public void setSampul(String sampul) { 
        this.sampul = sampul; }

    public void setStok(Integer stok) { 
        this.stok = stok; }
        
    public void setSinopsis(String sinopsis) {
         this.sinopsis = sinopsis; }
}