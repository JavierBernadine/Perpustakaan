package id.ac.unud.perpustakaan.Repository;
 
import id.ac.unud.perpustakaan.Model.Pengguna;
import id.ac.unud.perpustakaan.Model.Peran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.util.List;
import java.util.Optional;
 
public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {
 
    Optional<Pengguna> findByUsername(String username);
 
    boolean existsByUsername(String username);
 
    long countByPeran(Peran peran);
 
    @Query("""
            select p from Pengguna p
            where p.peran = :peran
              and (lower(p.namaLengkap) like lower(concat('%', :q, '%'))
                   or lower(p.username) like lower(concat('%', :q, '%')))
            order by p.namaLengkap
            """)
    List<Pengguna> cariAnggota(@Param("peran") Peran peran, @Param("q") String q);
}
