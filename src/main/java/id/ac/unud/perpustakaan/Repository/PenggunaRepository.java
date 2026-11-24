package id.ac.unud.perpustakaan.Repository;

import id.ac.unud.perpustakaan.Model.Pengguna;
import id.ac.unud.perpustakaan.Model.Peran;
import id.ac.unud.perpustakaan.Model.StatusAnggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {

    Optional<Pengguna> findByUsername(String username);

  
    boolean existsByUsername(String username);

    List<Pengguna> findByPeran(Peran peran);

    List<Pengguna> findByStatus(StatusAnggota status);

    List<Pengguna> findByPeranAndStatus(Peran peran, StatusAnggota status);

   
    @Query("""
            SELECT p FROM Pengguna p
            WHERE LOWER(p.namaLengkap) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(p.username) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)
    List<Pengguna> cariPengguna(@Param("keyword") String keyword);
}