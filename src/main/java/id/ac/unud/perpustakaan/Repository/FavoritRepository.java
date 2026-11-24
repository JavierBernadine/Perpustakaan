package id.ac.unud.perpustakaan.Repository;
 
import id.ac.unud.perpustakaan.Model.Favorit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import java.util.List;
import java.util.Optional;
import java.util.Set;
 
public interface FavoritRepository extends JpaRepository<Favorit, Long> {
 
    List<Favorit> findByAnggotaIdOrderByIdDesc(Long anggotaId);
 
    Optional<Favorit> findByAnggotaIdAndBukuId(Long anggotaId, Long bukuId);
 
    boolean existsByAnggotaIdAndBukuId(Long anggotaId, Long bukuId);
 
    void deleteByBukuId(Long bukuId);
 
    void deleteByAnggotaId(Long anggotaId);
 
    @Query("select f.buku.id from Favorit f where f.anggota.id = :anggotaId")
    Set<Long> idBukuFavorit(@Param("anggotaId") Long anggotaId);
}
