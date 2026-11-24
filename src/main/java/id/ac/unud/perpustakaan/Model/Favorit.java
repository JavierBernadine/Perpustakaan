package id.ac.unud.perpustakaan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Favorit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long penggunaId;
    private long bukuId;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getPenggunaId() {return penggunaId;}

    public void setPenggunaId(long penggunaId) {this.penggunaId = penggunaId;}

    public long getBukuId() {return bukuId;}

    public void setBukuId(long bukuId) {this.bukuId = bukuId;}
}
