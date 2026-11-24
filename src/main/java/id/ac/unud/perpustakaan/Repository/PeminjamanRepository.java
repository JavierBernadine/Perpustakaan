package id.ac.unud.perpustakaan.Repository;

import id.ac.unud.perpustakaan.Model.Peminjaman;
import id.ac.unud.perpustakaan.Model.StatusPeminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {

   
    List<Peminjaman> findByAnggotaIdOrderByTanggalPengajuanDesc(Long anggotaId);

    List<Peminjaman> findByAnggotaIdAndStatus(Long anggotaId, StatusPeminjaman status);

   
    List<Peminjaman> findByStatus(StatusPeminjaman status);

    List<Peminjaman> findAllByOrderByTanggalPengajuanDesc();

    
    boolean existsByAnggotaIdAndBukuIdAndStatusIn(Long anggotaId, Long bukuId,
                                                  Collection<StatusPeminjaman> statuses);

    
    long countByAnggotaIdAndStatus(Long anggotaId, StatusPeminjaman status);

    
    List<Peminjaman> findByStatusAndTanggalJatuhTempoBefore(StatusPeminjaman status, LocalDate tanggal);

    
    boolean existsByBukuIdAndStatusIn(Long bukuId, Collection<StatusPeminjaman> statuses);
}