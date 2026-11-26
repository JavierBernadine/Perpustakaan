package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.*;


@Entity 
@Table( name= "favorit", uniqueConstraints= @UniqueConstraint(columnNames = {"pengguna_id", "buku_id"}))
public class Favorit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pengguna_id", nullable = false)
    private Pengguna anggota;
    
    @ManyToOne(optional = false)
    @JoinColumn (name = "buku_id", nullable = false)
    private Buku buku;

    public Long getId(){return id;}

    public Pengguna getAnggota(){return anggota;}

    public Buku getBuku() {return buku;}

    public void setId(Long id) {this.id = id;}

    public void setAnggota (Pengguna anggota){this.anggota = anggota;}

    public void setBuku (Buku buku) {this.buku = buku;}
} 
