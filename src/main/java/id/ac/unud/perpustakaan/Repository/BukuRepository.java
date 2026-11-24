package id.ac.unud.perpustakaan.Repository;

import id.ac.unud.perpustakaan.Model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {

    List<Buku> findByJudulContainingIgnoreCase(String judul);

    List<Buku> findByPenulisContainingIgnoreCase(String penulis);

    Optional<Buku> findByIsbn(String isbn);
}