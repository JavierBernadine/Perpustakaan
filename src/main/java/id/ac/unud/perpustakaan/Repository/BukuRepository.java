package id.ac.unud.perpustakaan.Repository;

import id.ac.unud.perpustakaan.Model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {

   
    Optional<Buku> findByKodeBuku(String kodeBuku);

   
    boolean existsByKodeBuku(String kodeBuku);

   
    boolean existsByKodeBukuAndIdNot(String kodeBuku, Long id);

    
    List<Buku> findByJudulContainingIgnoreCase(String judul);

    List<Buku> findByPenulisContainingIgnoreCase(String penulis);

    List<Buku> findByKategoriIgnoreCase(String kategori);

   
    List<Buku> findByStokGreaterThan(Integer stok);

    
    @Query("""
            SELECT b FROM Buku b
            WHERE LOWER(b.judul) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(b.penulis) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(b.kodeBuku) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    List<Buku> cariBuku(@Param("keyword") String keyword);

    
    @Query("SELECT DISTINCT b.kategori FROM Buku b ORDER BY b.kategori")
    List<String> findAllKategori();
}