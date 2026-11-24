package id.ac.unud.perpustakaan.Repository;
 
import id.ac.unud.perpustakaan.Model.Denda;
import id.ac.unud.perpustakaan.Model.StatusDenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.util.List;
 
public interface DendaRepository extends JpaRepository<Denda, Long> {
 
    long countByStatus(StatusDenda status);
 
    boolean existsByPeminjamanAnggotaIdAndStatus(Long anggotaId, StatusDenda status);
 
    long countByPeminjamanAnggotaIdAndStatus(Long anggotaId, StatusDenda status);
 
    List<Denda> findAllByOrderByStatusAscIdDesc();
 
    List<Denda> findByPeminjamanAnggotaIdOrderByStatusAscIdDesc(Long anggotaId);
 
    @Query("select coalesce(sum(d.nominal), 0L) from Denda d where d.status = :status")
    long totalNominal(@Param("status") StatusDenda status);
 
    @Query("""
            select coalesce(sum(d.nominal), 0L) from Denda d
            where d.peminjaman.anggota.id = :anggotaId and d.status = :status
            """)
    long totalNominalByAnggota(@Param("anggotaId") Long anggotaId,
                               @Param("status") StatusDenda status);
}
