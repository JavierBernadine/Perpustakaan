package id.ac.unud.perpustakaan.Repository;
 
import id.ac.unud.perpustakaan.Model.Peminjaman;
import id.ac.unud.perpustakaan.Model.StatusPeminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
 
public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {
 
    long countByStatus(StatusPeminjaman status);
 
    long countByAnggotaIdAndStatusIn(Long anggotaId, Collection<StatusPeminjaman> status);
 
    boolean existsByAnggotaIdAndBukuIdAndStatusIn(Long anggotaId, Long bukuId,
                                                  Collection<StatusPeminjaman> status);
 
    boolean existsByBukuIdAndStatusIn(Long bukuId, Collection<StatusPeminjaman> status);
 
    boolean existsByBukuId(Long bukuId);
 
    boolean existsByAnggotaId(Long anggotaId);
 
    List<Peminjaman> findTop5ByOrderByTanggalPengajuanDescIdDesc();
 
    List<Peminjaman> findByStatusAndTanggalJatuhTempoBeforeOrderByTanggalJatuhTempoAsc(
            StatusPeminjaman status, LocalDate batas);
 
    List<Peminjaman> findByAnggotaIdAndStatusOrderByTanggalJatuhTempoAsc(
            Long anggotaId, StatusPeminjaman status);
 
    List<Peminjaman> findByStatusOrderByTanggalPengajuanAscIdAsc(StatusPeminjaman status);
 
    List<Peminjaman> findByStatusOrderByTanggalJatuhTempoAsc(StatusPeminjaman status);
 
    @Query("""
            select p from Peminjaman p
            where (:anggotaId is null or p.anggota.id = :anggotaId)
              and (:status is null or p.status = :status)
              and (:dari is null or p.tanggalPengajuan >= :dari)
              and (:sampai is null or p.tanggalPengajuan <= :sampai)
            order by p.tanggalPengajuan desc, p.id desc
            """)
    List<Peminjaman> cari(@Param("anggotaId") Long anggotaId,
                          @Param("status") StatusPeminjaman status,
                          @Param("dari") LocalDate dari,
                          @Param("sampai") LocalDate sampai);
}
