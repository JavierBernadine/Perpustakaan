package id.ac.unud.perpustakaan.Repository;
 
import id.ac.unud.perpustakaan.Model.Buku;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.util.List;
import java.util.Optional;
 
public interface BukuRepository extends JpaRepository<Buku, Long> {
 
    boolean existsByKodeBuku(String kodeBuku);
 
    boolean existsByKodeBukuAndIdNot(String kodeBuku, Long id);
 
    @Query("""
            select b from Buku b
            where (:kategori = '' or b.kategori = :kategori)
              and (lower(b.judul) like lower(concat('%', :q, '%'))
                   or lower(b.penulis) like lower(concat('%', :q, '%'))
                   or lower(b.kategori) like lower(concat('%', :q, '%')))
            order by b.judul
            """)
    List<Buku> cari(@Param("q") String q, @Param("kategori") String kategori);
 
    @Query("select distinct b.kategori from Buku b order by b.kategori")
    List<String> daftarKategori();
 

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select b from Buku b where b.id = :id")
    Optional<Buku> findByIdUntukUpdate(@Param("id") Long id);
}
