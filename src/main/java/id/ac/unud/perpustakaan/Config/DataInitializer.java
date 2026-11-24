package id.ac.unud.perpustakaan.Config;
 
import id.ac.unud.perpustakaan.Model.Buku;
import id.ac.unud.perpustakaan.Model.Pengguna;
import id.ac.unud.perpustakaan.Model.Peran;
import id.ac.unud.perpustakaan.Repository.BukuRepository;
import id.ac.unud.perpustakaan.Repository.PenggunaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
 
/** Mengisi data awal (akun Admin, contoh anggota, contoh buku) bila tabel masih kosong. */
@Configuration
public class DataInitializer {
 
    @Bean
    CommandLineRunner isiDataAwal(PenggunaRepository penggunaRepo,
                                  BukuRepository bukuRepo,
                                  PasswordEncoder encoder) {
        return args -> {
            if (penggunaRepo.count() == 0) {
                penggunaRepo.save(pengguna("admin", "Admin Perpustakaan", Peran.ADMIN,
                        null, null, encoder.encode("Admin#12345")));
                penggunaRepo.save(pengguna("2508561001", "Ni Made Contoh Satu", Peran.MAHASISWA,
                        "Teknik Informatika", 2025, encoder.encode("mahasiswa123")));
                penggunaRepo.save(pengguna("2508561002", "I Kadek Contoh Dua", Peran.MAHASISWA,
                        "Teknik Informatika", 2025, encoder.encode("mahasiswa123")));
            }
            if (bukuRepo.count() == 0) {
                bukuRepo.save(buku(
                        "BK-001", "Clean Code", "Robert C. Martin", "Prentice Hall", 2008, "Pemrograman", 3));
                bukuRepo.save(buku(
                        "BK-002", "Introduction to Algorithms", "Thomas H. Cormen", "MIT Press", 2022, "Algoritma", 2));
                bukuRepo.save(buku(
                        "BK-003", "Database System Concepts", "Abraham Silberschatz", "McGraw-Hill", 2019, "Basis Data", 4));
                bukuRepo.save(buku(
                        "BK-004", "Computer Networking: A Top-Down Approach", "James F. Kurose", "Pearson", 2021, "Jaringan", 2));
                bukuRepo.save(buku(
                        "BK-005", "Laskar Pelangi", "Andrea Hirata", "Bentang Pustaka", 2005, "Novel", 5));
                bukuRepo.save(buku(
                        "BK-006", "Sapiens", "Yuval Noah Harari", "Harvill Secker", 2014, "Sejarah", 1));
            }
        };
    }
 
    private static Pengguna pengguna(String username, String nama, Peran peran,
                                     String prodi, Integer angkatan, String hash) {
        Pengguna p = new Pengguna();
        p.setUsername(username);
        p.setNamaLengkap(nama);
        p.setPeran(peran);
        p.setProgramStudi(prodi);
        p.setAngkatan(angkatan);
        p.setPasswordHash(hash);
        return p;
    }
 
    private static Buku buku(String kode, String judul, String penulis, String penerbit,
                             int tahun, String kategori, int stok) {
        Buku b = new Buku();
        b.setKodeBuku(kode);
        b.setJudul(judul);
        b.setPenulis(penulis);
        b.setPenerbit(penerbit);
        b.setTahunTerbit(tahun);
        b.setKategori(kategori);
        b.setStok(stok);
        return b;
    }}
