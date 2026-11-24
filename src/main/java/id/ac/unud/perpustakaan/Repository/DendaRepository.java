package id.ac.unud.perpustakaan.Repository;

import id.ac.unud.perpustakaan.Model.Denda;
import id.ac.unud.perpustakaan.Model.StatusDenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DendaRepository extends JpaRepository<Denda, Long> {

    
    Optional<Denda> findByPeminjamanId(Long peminjamanId);

    boolean existsByPeminjamanId(Long peminjamanId);

    List<Denda> findByStatus(StatusDenda status);

   
    List<Denda> findByPeminjamanAnggotaId(Long anggotaId);

    List<Denda> findByPeminjamanAnggotaIdAndStatus(Long anggotaId, StatusDenda status);

   
    @Query("""
            SELECT SUM(d.nominal) FROM Denda d
            WHERE d.peminjaman.anggota.id = :anggotaId AND d.status = :status
            """)
    Long totalNominalByAnggotaAndStatus(@Param("anggotaId") Long anggotaId,
                                        @Param("status") StatusDenda status);
}